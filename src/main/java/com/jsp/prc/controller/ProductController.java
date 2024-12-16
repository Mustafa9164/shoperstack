package com.jsp.prc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.prc.entity.Product;
import com.jsp.prc.service.ProductService;
import com.jsp.prc.util.ResponseStructure;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.*;

@RestController
@RequestMapping("/api/version/products")
@Tag(description = "EMployee Crud Operation", name = "Employee")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product){
		return productService.saveProduct(product);
	}
	
	@GetMapping("/findById")
	public ResponseEntity<ResponseStructure<Product>> findById(@RequestParam Integer productId){
		return productService.findById(productId);
	}
	
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct(){
		return productService.findAllProduct();
	}
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@RequestParam Integer productId){
		return productService.deleteProduct(productId);
	}
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestParam Integer productId,@RequestBody Product product){
		return productService.updateProduct(productId,product);
	}
	@PatchMapping("/updatePrice")
	public ResponseEntity<ResponseStructure<Product>> updateProductPrice(@RequestParam Integer productId,@RequestParam Double productPrice){
		return productService.updateProductPrice(productId,productPrice);
	}

}
