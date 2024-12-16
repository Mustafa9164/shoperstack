package com.jsp.prc.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.jsp.prc.entity.Product;
import com.jsp.prc.repo.ProductRepo;
import com.jsp.prc.util.ResponseStructure;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
	
	@Mock
	ProductRepo repo;
	
	@InjectMocks
	ProductService service;
	
	static ArrayList<Product> l1;
	static Product p1;
	static Product p2;
	static Product p3;
	static Product p4;
	
	@BeforeAll
	static void init() {
		l1=new ArrayList<Product>();
	}
	
	@BeforeEach
	void initEachTime() {
		l1=new ArrayList<Product>();

		 p1 = new Product(1, "headphone", "wireless", 1200.0, LocalDate.of(2021, 12, 11));
		 p2 = new Product(2, "mouse", "wireless", 1000.0, LocalDate.of(2020, 8, 11));
		 p3 = new Product(3, "keyboard", "Lighten", 2000.0, LocalDate.of(2023, 9, 9));
		 p4 = new Product(4, "mobile", "10000k battery", 30000.0, LocalDate.of(2024, 11, 1));
		 Product arr[]= {p1,p2,p3,p4};
		 Arrays.asList(arr).stream().forEach(ele->l1.add((Product) ele));
	}

	@Test
	void testSaveProduct() {
		Mockito.when(repo.save(p1)).thenReturn(p1);
		ResponseEntity<ResponseStructure<Product>> temp = service.saveProduct(p1);
		Product actual = temp.getBody().getData();
		Assertions.assertEquals(p1.getProductId(),actual.getProductId());
	}

	@Test
	void testFindById() {
		Mockito.when(repo.findById(p1.getProductId())).thenReturn(Optional.of(p1));
		ResponseEntity<ResponseStructure<Product>> temp = service.findById(p1.getProductId());
		Product actual = temp.getBody().getData();
		Assertions.assertEquals(p1.getProductId(), actual.getProductId());
	}
	
	@Test
	void testFindAllProduct() {
		Mockito.when(repo.findAll()).thenReturn(l1);
		
		ResponseEntity<ResponseStructure<List<Product>>> temp = service.findAllProduct();
		ResponseStructure<List<Product>> body = temp.getBody();
		Assertions.assertEquals(l1.get(0).getProductId(), body.getData().get(0).getProductId());
	}


	
//	@Test
//	void testUpdateProduct() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateProductPrice() {
//		fail("Not yet implemented");
//	}

}
