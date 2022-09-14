package todoapp.springbootdatajpa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todoapp.springbootdatajpa.dao.TodoRepository;
import todoapp.springbootdatajpa.entity.Todo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class TodoServiceImpl implements TodoService{


    TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository theTodoRepository) {
        this.todoRepository = theTodoRepository;
    }


    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(int todoId) {
        Optional<Todo> result = todoRepository.findById(todoId);

        Todo theTodo = null;

        if(result.isPresent()) {
            theTodo = result.get();
        }
        else {
            throw new RuntimeException("Not Found!");
        }


        return theTodo;
    }

    @Override
    public void saveTodo(Todo theTodo) {
        todoRepository.save(theTodo);
    }

    @Override
    public void deleteTodo(int todoId) {
        todoRepository.deleteById(todoId);
    }

}
