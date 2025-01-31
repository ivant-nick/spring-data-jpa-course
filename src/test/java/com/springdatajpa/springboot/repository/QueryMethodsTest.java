package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {

        Product product = productRepository.findByName("product 2");
        System.out.println(product.toString());
    }

    @Test
    void findByIdMethod() {

        Product product = productRepository.findById(1L).get();
        System.out.println(product.toString());
    }

    @Test
    void findByNameOrDescriptionMethod() {

        List<Product> products = productRepository.findByNameOrDescription("Iphone 12", "New Iphone 12");
        products.forEach((product) -> {
            System.out.println(product.toString());
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findByNameAndDescriptionMethod() {

        List<Product> products = productRepository.findByNameAndDescription("Iphone 12", "New Iphone 12");
        products.forEach((product) -> {
            System.out.println(product.toString());
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findDistinctByNameMethod() {

        Product product = productRepository.findDistinctByName("Iphone 12");
        System.out.println(product.toString());
    }

    @Test
    void findByPriceGreaterThanMethod() {

        List<Product> products = productRepository.findByPriceGreaterThan(BigDecimal.valueOf(100));
        products.forEach((product) -> {
            System.out.println(product.toString());
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findByPriceLessThanMethod() {

        List<Product> products = productRepository.findByPriceLessThan(BigDecimal.valueOf(200));
        products.forEach((product) -> {
            System.out.println(product.toString());
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findByNameContainingMethod() {

        List<Product> products = productRepository.findByNameContaining("product");
        products.forEach((product) -> {
            System.out.println(product.toString());
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findByNameLikeMethod() {

        List<Product> products = productRepository.findByNameLike("product%");
        products.forEach((product) -> {
            System.out.println(product.toString());
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findByPriceBetweenMethod() {

        List<Product> products = productRepository.findByPriceBetween(BigDecimal.valueOf(100), BigDecimal.valueOf(300));
        products.forEach((product) -> {
            System.out.println(product.toString());
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findByDateCreatedBetweenMethod() {

        // start date
        LocalDateTime startDate = LocalDateTime.of(2025, 01, 31, 01, 54, 49 );

        // end date
        LocalDateTime endDate = LocalDateTime.of(2025, 01, 31, 01, 55, 20 );

        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);
        products.forEach((product) -> {
            System.out.println(product.toString());
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findByNameInMethod() {

        List<Product> products = productRepository.findByNameIn(List.of("Iphone 12","product 2", "product 3"));
        products.forEach((product) -> {
            System.out.println(product.toString());
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findFirst2ByOrderByNameAscMethod() {

        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
        products.forEach((product) -> {
            System.out.println(product.toString());
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findTop2ByOrderByPriceDescMethod() {

        List<Product> products = productRepository.findTop2ByOrderByPriceDesc();
        products.forEach((product) -> {
            System.out.println(product.toString());
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

}
