package com.infoshare.ex7.controller;

import com.infoshare.ex7.repository.ToDoList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ToDoController {

    private final ToDoList toDoList;

    public ToDoController(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    @GetMapping("/todolist")
    public String getToDoList(Model model) {
        model.addAttribute("todolist", toDoList.getTodolist());
        return "todolist";
    }
}
