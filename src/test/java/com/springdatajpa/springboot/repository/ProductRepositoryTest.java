package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        //create a product
        Product product = new Product();
        product.setName("Iphone 12");
        product.setDescription("New Iphone 12");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal("100"));
        product.setActive(true);
        product.setImageUrl("https://www.iphone12.com");

        //save the product
        Product savedProduct = productRepository.save(product);

        //display the product
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());
        System.out.println(savedProduct.getDescription());
    }

    @Test
    void updateUsingSaveMethod() {
        // find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        // update the entity information
        product.setName("updated Iphone 12");
        product.setDescription("updated New Iphone 12");

        // save the updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod() {
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        System.out.println(product.toString());
    }

    @Test
    void saveAllMethod() {
        //create a product
        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("product 2 description");
        product2.setSku("100ABCD");
        product2.setPrice(new BigDecimal("200"));
        product2.setActive(true);
        product2.setImageUrl("product 2.png");

        //create a product
        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("product 3 description");
        product3.setSku("100ABCDE");
        product3.setPrice(new BigDecimal("300"));
        product3.setActive(true);
        product3.setImageUrl("product 3.png");

        //save the product
        productRepository.saveAll(List.of(product2, product3));
        System.out.println(List.of(product2, product3));
    }

    @Test
    void findAllMethod() {
        List<Product> products = productRepository.findAll();

        // display the products in different ways
        System.out.println("case 1");
        System.out.println(products);

        System.out.println("case 2");
        products.forEach(System.out::println);

        System.out.println("case 3");
        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void deleteByIdMethod() {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod() {
        // find or retrieve an entity by id
        Long id = 2L;
        Product product = productRepository.findById(id).get();

        // delete the entity
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod() {


        productRepository.deleteAll();

//        Product product = productRepository.findById(5L).get();
//
//        Product product1 = productRepository.findById(6L).get();
//
//        productRepository.deleteAll(List.of(product, product1));
    }

    @Test
    void existsByIdMethod() {
        Long id = 7L;
        boolean exists = productRepository.existsById(id);
        System.out.println(exists);
    }

    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }

}