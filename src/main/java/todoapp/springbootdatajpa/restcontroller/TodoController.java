package todoapp.springbootdatajpa.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import todoapp.springbootdatajpa.entity.Todo;
import todoapp.springbootdatajpa.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {


    private TodoService todoService;


    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<Todo> findAll() {

        return todoService.findAll();
    }

    @GetMapping("/todos/{todoId}")
    public Todo findById(@PathVariable int todoId) {

        return todoService.findById(todoId);
    }

    @PostMapping("/todos")
    public String saveTodo(@RequestBody Todo theTodo) {

        todoService.saveTodo(theTodo);

        return theTodo.getTask() + " has been saved!";
    }

    @PutMapping("/todos")
    public Todo updateTodo(@RequestBody Todo theTodo) {

        todoService.saveTodo(theTodo);


        return theTodo;
    }

    @DeleteMapping("/todos/{todoId}")
    public String deleteTodo(@PathVariable int todoId) {

        Todo theTodo = todoService.findById(todoId);

        todoService.deleteTodo(todoId);

        return "Deleted the " + theTodo.getTask()+" with todo with id --" + todoId;
    }



}
