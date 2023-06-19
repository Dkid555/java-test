package com.app.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private String firstname;
    private String lastName;

    public Person(String firstname, String lastName) {
        this.firstname = firstname;
        this.lastName = lastName;
    }
}
