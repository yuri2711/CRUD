package ru.yuri.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yuri.services.Person;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {

    private final EntityManager manager;

    @Autowired
    public PeopleDAO(EntityManager manager) {
        this.manager = manager;
    }

    public List<Person> index() {
        return manager.createQuery("select p from Person p").getResultList();
    }

    public Person show(int id) {
        return manager.getReference(Person.class, new Long(id));
    }

    public void save(Person person) {
        manager.persist(person);
    }

    public void update(Long id) {

    }

    public void delete(int id) {

    }
}
