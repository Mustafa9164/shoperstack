package com.jsp.prc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.prc.entity.Product;
import com.jsp.prc.exception.ProductNotFoundException;
import com.jsp.prc.repo.ProductRepo;
import com.jsp.prc.util.ResponseStructure;

@Service
public class ProductService{
	
	@Autowired
	private ProductRepo productRepo;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		if(productRepo.existsById(product.getProductId())) {
			throw new ProductNotFoundException("Product Withe Given id = " + product.getProductId() + " Not Found"); 
		}
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		structure.setData(productRepo.save(product));
		structure.setMessage("product saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Product>> findById(Integer productId) {
		Optional<Product> optional = productRepo.findById(productId);
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		if(optional.isPresent()) {
		structure.setData(optional.get());
		structure.setMessage("product found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		throw new ProductNotFoundException("Product Withe Given id = " + productId + " Not Found");	
		}

	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct() {
		List<Product> findAll = productRepo.findAll();
		ResponseStructure<List<Product>> structure=new ResponseStructure<List<Product>>();
		structure.setData(findAll);
		structure.setMessage("Sucess");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Product>> deleteProduct(Integer productId) {
		Optional<Product> optional = productRepo.findById(productId);
		if(optional.isPresent()) {
			productRepo.deleteById(productId);
			ResponseStructure<Product> structure=new ResponseStructure<Product>();
			//structure.setData(productRepo.deleteById(productId));
			structure.setMessage("product deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		throw new ProductNotFoundException("Product Withe Given id = " + productId + " Not Found");
		
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(Integer productId, Product product) {
		Optional<Product> optional = productRepo.findById(productId);
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		if(optional.isPresent()) {
			product.setProductId(productId);
			Product updateProdct = productRepo.save(product);
			structure.setData(updateProdct);
			structure.setMessage("productUpdated sucessfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		throw new ProductNotFoundException("Product Withe Given id = " + productId + " Not Found");
	}

	public ResponseEntity<ResponseStructure<Product>> updateProductPrice(Integer productId, Double productPrice) {
		
		Optional<Product> optional = productRepo.findById(productId);
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		if(optional.isPresent()) {
			
	        // Get the product and update its price
			Product product = optional.get();
			product.setProductPrice(productPrice);
			Product updatedProduct = productRepo.save(product);
			//productRepo.updateProductPrice(productId, productPrice);
			structure.setData(updatedProduct);
			structure.setMessage("product price updated");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		throw new ProductNotFoundException("Product Withe Given id = " + productId + " Not Found");
	}


	

}
