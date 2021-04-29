package ru.yuri.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.yuri.model.People;
import ru.yuri.services.PeopleService;

@Controller
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private PeopleService service;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", service.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable("id") int id, Model model){
        model.addAttribute("person", service.get(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new People());
        return "people/news";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") People people){
        service.save(people);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", service.get(id));
        return "people/edit";
    }
    @PatchMapping("/{id}")
    public  String update(@ModelAttribute("person") People people){
        service.update(people);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public  String delete(@PathVariable("id") int id){
        service.delete(id);
        return "redirect:/people";
    }
}
