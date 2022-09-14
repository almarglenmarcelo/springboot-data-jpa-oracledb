package todoapp.springbootdatajpa.service;


import todoapp.springbootdatajpa.entity.Todo;


import java.util.List;

public interface TodoService {

    public List<Todo> findAll();

    public Todo findById(int todoId);

    public void saveTodo(Todo theTodo);

    public void deleteTodo(int todoId);
}
