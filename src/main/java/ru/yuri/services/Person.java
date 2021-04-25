package ru.yuri.services;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private int id;
    private String name;
    private String lastname;
    private int ago;

    public Person(String name, String lastname, int ago) {
        this.name = name;
        this.lastname = lastname;
        this.ago = ago;
    }

    public Person(int id, String name, String lastname, int ago) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.ago = ago;
    }

    public Person() {
    }
}
