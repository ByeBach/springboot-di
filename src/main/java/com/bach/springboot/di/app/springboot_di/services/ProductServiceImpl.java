package com.bach.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bach.springboot.di.app.springboot_di.models.Product;
import com.bach.springboot.di.app.springboot_di.repositories.ProductRepository;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll(){
        //aplica impuesto al precio del producto
        //cuidado con el principio de inmutibilidad
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue()); //se genera una nueva instancia
            return newProd;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }

   

}
