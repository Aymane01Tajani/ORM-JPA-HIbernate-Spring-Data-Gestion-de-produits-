package com.example.tp2studentsapp;

import com.example.tp2studentsapp.entities.Product;
import com.example.tp2studentsapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Tp2StudentsAppApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {

        SpringApplication.run(Tp2StudentsAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Computer",4300,3));
        productRepository.save(new Product(null,"Printer",1200,4));
        productRepository.save(new Product(null,"Smart Phone",3200,32));
        List<Product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
                });
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("*************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println(product.getPrice());
        System.out.println("*************");
        System.out.println("-------------");
        List<Product>productList = productRepository.findByNameContains("C");
        productList.forEach(p->{
            System.out.println(p);
                });
        System.out.println("-------------");
        List<Product>productList2 = productRepository.search("%C%");
        productList2.forEach(p->{
            System.out.println(p);
        });
        System.out.println("-------------");
        List<Product>productList3 = productRepository.findByPriceGreaterThan(3000);
        productList3.forEach(p->{
            System.out.println(p);
        });
        System.out.println("-------------");
        List<Product>productList4 = productRepository.searchByPrice(3000);
        productList4.forEach(p->{
            System.out.println(p);
        });
    }
}
