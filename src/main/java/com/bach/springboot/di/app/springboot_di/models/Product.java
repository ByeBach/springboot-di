package com.bach.springboot.di.app.springboot_di.models;

public class Product {
    private Long id;
    private String name;
    private Long Price;
    
    public Product() {
    }

    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        Price = price;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getPrice() {
        return Price;
    }
    public void setPrice(Long price) {
        Price = price;
    }

    

}
