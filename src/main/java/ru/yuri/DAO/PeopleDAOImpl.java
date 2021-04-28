package ru.yuri.DAO;

import org.springframework.stereotype.Repository;
import ru.yuri.model.People;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PeopleDAOImpl implements PeopleDAO {

    @PersistenceContext
    EntityManager manager;

    @Override
    public List<People> index() {
        return manager.createQuery("select p from People p").getResultList();
    }

    @Override
    public People get(int id) {
        return manager.find(People.class, new Long(id));
    }

    @Override
    public void save(People person) {
        manager.persist(person);
    }

    @Override
    public void update(People person) {
        manager.merge(person);
    }

    @Override
    public void delete(int id) {
        manager.remove(get(id));
    }
}
