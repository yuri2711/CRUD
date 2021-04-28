package ru.yuri.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yuri.DAO.PeopleDAO;
import ru.yuri.model.People;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PeopleServiceImpl implements PeopleService {

    private final PeopleDAO peopleDAO;

    @Autowired
    public PeopleServiceImpl(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @Override
    public List<People> index() {
        return peopleDAO.index();
    }

    @Override
    public People get(int id) {
        return peopleDAO.get(id);
    }

    @Override
    public void save(People person) {
        peopleDAO.save(person);
    }

    @Override
    public void update(People person) {
        peopleDAO.update(person);
    }

    @Override
    public void delete(int id) {
        peopleDAO.delete(id);
    }
}
