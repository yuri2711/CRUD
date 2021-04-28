package ru.yuri.services;

import ru.yuri.model.People;

import java.util.List;

public interface PeopleService {
    List<People> index();
    People get(int id);
    void save(People person);
    void update(People person);
    void delete(int id);
}
