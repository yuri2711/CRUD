package ru.yuri.services;

import ru.yuri.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> index();
    Person get(int id);
    void save(Person person);
    void update(Person person);
    void delete(int id);
}
