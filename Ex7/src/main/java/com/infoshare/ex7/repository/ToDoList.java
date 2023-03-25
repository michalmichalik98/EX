package com.infoshare.ex7.repository;

import com.infoshare.ex7.domain.Category;
import com.infoshare.ex7.domain.ToDo;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoList {

    public List<ToDo> todolist;

    public ToDoList() {
        this.todolist = importToDoList();
    }

    public List<ToDo> getTodolist() {
        return todolist;
    }

    public static List<ToDo> importToDoList() {
        List<ToDo> todolist = new ArrayList<>();
        todolist.add(new ToDo(Category.DOM, "Kupić kilo ziemniaków", 3, LocalDate.of(2023, 12, 1)));
        todolist.add(new ToDo(Category.PRACA, "Wypić w pracy 10 kaw", 5, LocalDate.of(2023, 3, 2)));
        todolist.add(new ToDo(Category.DOM, "Ugotować kilo ziemniaków", 2, LocalDate.of(2023, 3, 3)));

        return todolist;
    }


}
