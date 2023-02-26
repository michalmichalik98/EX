package com.infoshare.ex7.controller;

import com.infoshare.ex7.domain.ToDo;
import com.infoshare.ex7.repository.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ToDoController {

    private final ToDoList toDoList;

    @Autowired
    public ToDoController(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    @GetMapping("/todolist")
    public String getToDoList(Model model) {
        model.addAttribute("todolist", toDoList.getTodolist());
        return "todolist";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("toDo", new ToDo());       //?????????????????
        return "add";
    }

    @PostMapping("/add")
    public String add(ToDo toDo, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }
        toDoList.getTodolist().add(toDo);
        return "redirect:/todolist";

    }
}

