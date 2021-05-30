package com.practice.springboot.todowebapp.controller;

import com.practice.springboot.todowebapp.model.TodoBean;
import com.practice.springboot.todowebapp.service.TodoService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException{
                setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }

            @Override
            public String getAsText() throws IllegalArgumentException {
                return DateTimeFormatter.ofPattern("dd/MM/yyyy").format((LocalDate) getValue());
            }
        });
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
        model.addAttribute("todo", new TodoBean(0, (String) model.get("name"), "",
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

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(ModelMap model, @RequestParam int id){
        TodoBean todo = todoService.retrieveByID(id);
        model.put("todo",todo);
        return "add-todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid TodoBean todo){
        todo.setUser((String) model.get("name"));
        todo.setTargetDate(todo.getTargetDate());
        todoService.updateTodo(todo);
        return "redirect:/list-todos";
    }
}
