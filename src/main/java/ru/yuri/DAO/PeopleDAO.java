package ru.yuri.DAO;

import org.springframework.stereotype.Component;
import ru.yuri.services.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT = 0;

    {
        people = new ArrayList<Person>();
        people.add(new Person(++PEOPLE_COUNT, "Юрий", "Тарасенко", 35));
        people.add(new Person(++PEOPLE_COUNT, "Андрей", "Царев", 33));
        people.add(new Person(++PEOPLE_COUNT, "Светлана", "Московская", 17));
        people.add(new Person(++PEOPLE_COUNT, "Екатерина", "Булкина", 27));
        people.add(new Person(++PEOPLE_COUNT, "Вика", "Саратова", 20));
        people.add(new Person(++PEOPLE_COUNT, "Фёкла", "Иванова", 23));
    }

    public List<Person> index(){return people;}

    public Person show(int id){
        return people.stream().filter(p ->p.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
