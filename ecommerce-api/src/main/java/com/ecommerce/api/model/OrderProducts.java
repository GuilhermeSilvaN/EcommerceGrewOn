package com.ecommerce.api.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderProducts implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    private UserEntity user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<Product>();

    public OrderProducts() {}

    public OrderProducts(String id, UserEntity user,  List<Product> products) {
        this.id = id;
        this.user = user;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }
}
