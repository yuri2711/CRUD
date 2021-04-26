package ru.yuri.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.yuri.DAO.PeopleDAO;
import ru.yuri.services.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleDAO peopleDAO;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", peopleDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", peopleDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/news";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") Person person){
        peopleDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", peopleDAO.show(id));
        return "people/edit";
    }
    @PatchMapping("/{id}") public  String update(@ModelAttribute("person") Person person, @PathVariable("id") int id){
        peopleDAO.update(id, person);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public  String delete(@PathVariable("id") int id){
        peopleDAO.delete(id);
        return "redirect:/people";
    }
}
