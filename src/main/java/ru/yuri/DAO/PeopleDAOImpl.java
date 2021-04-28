package ru.yuri.DAO;

import org.springframework.stereotype.Repository;
import ru.yuri.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PeopleDAOImpl implements PeopleDAO {

    @PersistenceContext
    EntityManager manager;

    @Override
    public List<Person> index() {
        return manager.createQuery("select p from Person p").getResultList();
    }

    @Override
    public Person get(int id) {
        return manager.find(Person.class, new Long(id));
    }

    @Override
    public void save(Person person) {
        manager.persist(person);
    }

    @Override
    public void update(Person person) {
        manager.merge(person);
    }

    @Override
    public void delete(int id) {
        manager.remove(get(id));
    }
}
