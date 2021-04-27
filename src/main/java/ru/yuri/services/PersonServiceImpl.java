package ru.yuri.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yuri.DAO.PeopleDAO;
import ru.yuri.model.Person;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PeopleDAO peopleDAO;

    @Autowired
    public PersonServiceImpl(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @Override
    public List<Person> index() {
        return peopleDAO.index();
    }

    @Override
    public Person get(int id) {
        return peopleDAO.get(id);
    }

    @Override
    public void save(Person person) {
        peopleDAO.save(person);
    }

    @Override
    public void update(Person person) {
        peopleDAO.update(person);
    }

    @Override
    public void delete(int id) {
        peopleDAO.delete(id);
    }
}
