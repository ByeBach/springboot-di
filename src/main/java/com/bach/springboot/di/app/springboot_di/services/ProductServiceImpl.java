package com.bach.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bach.springboot.di.app.springboot_di.models.Product;
import com.bach.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private Environment enviroment;
    private ProductRepository repository;

    public ProductServiceImpl(@Qualifier ("productList")ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll(){
        //aplica impuesto al precio del producto
        //cuidado con el principio de inmutibilidad
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * enviroment.getProperty("config.price.tax", Double.class);
            Product newProd = new Product(p.getId(), p.getName(), priceTax.longValue()); //se genera una nueva instancia
            return newProd;
            // p.setPrice(priceTax.longValue());
            // return p; //se modifica la instancia original
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }

   

}
