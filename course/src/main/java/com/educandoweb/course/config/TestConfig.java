package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.educandoweb.course.entities.CategoryTable;
import com.educandoweb.course.entities.OrderItem;
import com.educandoweb.course.entities.OrderTable;
import com.educandoweb.course.entities.Payment;
import com.educandoweb.course.entities.ProductTable;
import com.educandoweb.course.entities.UserTable;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderItemRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.ProductRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception{
		
		ProductTable p1 = new ProductTable(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		ProductTable p2 = new ProductTable(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		ProductTable p3 = new ProductTable(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		ProductTable p4 = new ProductTable(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		ProductTable p5 = new ProductTable(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 

		
		CategoryTable cat1 = new CategoryTable(null, "Electronics");
		CategoryTable cat2 = new CategoryTable(null, "Books");
		CategoryTable cat3 = new CategoryTable(null, "Computers");
		
		UserTable u1 = new UserTable(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		UserTable u2 = new UserTable(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

		OrderTable o1 = new OrderTable(null, Instant.parse("2019-06-20T19:53:07Z"), u1, "PAID");
		OrderTable o2 = new OrderTable(null, Instant.parse("2019-07-21T03:42:10Z"), u2, "PAID");
		OrderTable o3 = new OrderTable(null, Instant.parse("2019-07-22T15:21:22Z"), u1, "PAID");
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2, cat3));
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T19:53:07Z"), o1);
		o1.setPayment(pay1);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		orderRepository.saveAll(Arrays.asList(o1,o2, o3));
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		
		
		orderRepository.save(o1);
		
	}
}
