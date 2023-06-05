package com.hiber.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class customers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // generation of ID through Autoincrement in MySQL

    private String name;

    public customers() {
    }

    public customers(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public customers(String name) {
        this.name = name;
    }

    private String address;
}
