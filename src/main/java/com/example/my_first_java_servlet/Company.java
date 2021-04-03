package com.example.my_first_java_servlet;

import java.util.Date;

public class Company {
    private int id;
    private String name;
    private Date createdAt;

    public Company(String nome) {
        this.name = nome;
        this.createdAt = new Date();
    }

    public Company(String nome, Date createdAt) {
        this.name = nome;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
