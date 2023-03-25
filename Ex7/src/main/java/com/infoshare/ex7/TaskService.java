package com.infoshare.ex7;

import com.infoshare.ex7.domain.ToDo;
import com.infoshare.ex7.repository.ToDoList;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    public List<ToDo> findHighPriorityToDos() {
        return ToDoList. stream()
                .filter(todo -> todo.getPriority() == 1)
                .collect(Collectors.toList());
    }


    public List<ToDo> findTasksForNextDay() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        return todolist.stream()
                .filter(ToDo -> ToDo.getDueDate().equals(tomorrow))
                .collect(Collectors.toList());
    }
}
