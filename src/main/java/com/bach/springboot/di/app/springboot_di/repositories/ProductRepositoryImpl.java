package com.bach.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
//import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.bach.springboot.di.app.springboot_di.models.Product;

//@RequestScope
@Primary
@SessionScope
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Computer", 1000L),
            new Product(2L, "Mouse", 20L),
            new Product(3L, "Keyboard", 50L),
            new Product(4L, "Monitor", 200L),
            new Product(5L, "Printer", 150L)
        );
    }
    @Override
    public List<Product> findAll(){
        return data;
    }
    @Override
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
    

}
