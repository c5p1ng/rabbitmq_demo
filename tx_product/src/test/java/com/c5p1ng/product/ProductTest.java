package com.c5p1ng.product;

import com.c5p1ng.product.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.c5p1ng.core.entity.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ProductApplication.class)
public class ProductTest {

	@Autowired
	private IProductService productService;
	
	@Test
	public void updateProduct() throws Exception{
		Order order = new Order();
		order.setProductId(1006);
		order.setCustomer("Five");
		order.setNumber(1);
		productService.updateProduct(order);
	}
}
