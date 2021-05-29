package com.practice.springboot.todowebapp.controller;

import com.practice.springboot.todowebapp.model.TodoBean;
import com.practice.springboot.todowebapp.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value = "list-todos", method = RequestMethod.GET)
    public List<TodoBean> retrieveTodoByUser(ModelMap model){
        String name= (String) model.get("name");
        List<TodoBean> listTodos = todoService.retrieveTodoList(name);
        model.put("todos",listTodos);
        return listTodos;
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showSaveTodo(ModelMap model){
        return "add-todo";
    }


    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String saveTodo(ModelMap model, @RequestParam String description){
        String name= (String) model.get("name");
        todoService.save(description, name);
        return "redirect:/list-todos";
    }
}
