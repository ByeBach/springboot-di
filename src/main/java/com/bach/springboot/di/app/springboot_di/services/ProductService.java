package com.bach.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.bach.springboot.di.app.springboot_di.models.Product;
import com.bach.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll(){
        //aplica impuesto al precio del producto
        //cuidado con el principio de inmutibilidad
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue()); //se genera una nueva instancia
            return newProd;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }

}
