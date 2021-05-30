package com.practice.springboot.todowebapp.controller;

import com.practice.springboot.todowebapp.model.TodoBean;
import com.practice.springboot.todowebapp.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
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
        model.addAttribute("todo", new TodoBean(0, (String) model.get("name"), "Default Desc",
                LocalDate.now(), false));
        return "add-todo";
    }

    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id){
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String saveTodo(ModelMap model, @ModelAttribute("todo") @Valid TodoBean todo, BindingResult results){

        if(results.hasErrors())
            return "add-todo";

        String name= (String) model.get("name");
        todoService.save(todo.getDescription(), name);
        return "redirect:/list-todos";
    }
}
