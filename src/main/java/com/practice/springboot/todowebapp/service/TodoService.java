package com.practice.springboot.todowebapp.service;

import com.practice.springboot.todowebapp.model.TodoBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    private static List<TodoBean> todos = new ArrayList<TodoBean>();

    static {
        todos.add(new TodoBean(1,"Jack","Spring API", LocalDate.parse("2021-07-20"),false));
        todos.add(new TodoBean(2,"Jone","Spring MVC", LocalDate.parse("2021-08-20"),false));
        todos.add(new TodoBean(3,"Philippe","Java", LocalDate.parse("2021-07-10"),false));
    }

    public List<TodoBean> retrieveTodoList(String userName){
        List<TodoBean> todosByUser = new ArrayList<>();
        for (TodoBean todo:
             todos) {
            if(todo.getUser().equalsIgnoreCase(userName)){
                todosByUser.add(todo);
            }
        }
        return todosByUser;
    }

    public List<TodoBean> save(String description, String name) {
        todos.add(new TodoBean(todos.size()+1,name, description, LocalDate.now(), false));
        return todos;
    }

    public void deleteTodo(int id) {
        todos.remove(new TodoBean(id));
    }
}
