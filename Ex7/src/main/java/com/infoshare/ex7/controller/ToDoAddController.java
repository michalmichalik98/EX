package com.infoshare.ex7.controller;

import com.infoshare.ex7.domain.Category;
import com.infoshare.ex7.domain.ToDo;
import com.infoshare.ex7.repository.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ToDoAddController {

    private final ToDoList toDoList;

    @Autowired
    public ToDoAddController(ToDoList toDoList) {
        this.toDoList = toDoList;
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("toDo", new ToDo();       //?????????????????
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute ToDo toDo) {
        toDoList.getTodolist().add(toDo);
        return "redirect:/";
    }
}
