package ru.yuri.DAO;

import ru.yuri.model.Person;

import java.util.List;

public interface PeopleDAO {
    List<Person> index();
    Person get(int id);
    void save(Person person);
    void update(Person person);
    void delete(int id);
}
