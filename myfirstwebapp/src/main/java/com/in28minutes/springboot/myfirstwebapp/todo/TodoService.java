package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static final List<Todo> todos = new ArrayList<>();
    static int count = 0;
    static{
        todos.add(new Todo(++count, "Aano", "Learn Shaayri", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++count, "Aano", "Learn Kavita", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++count, "Aano", "Read kavitaaye", LocalDate.now().plusYears(1), false));
    }


    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate =
                todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }
    public void addToDo(String username,String description, LocalDate date, boolean isDone){
        todos.add(new Todo(++count,username,description, date, isDone));
    }

    public void deleteById(int id) {
        for(Todo todo: todos){
            if(todo.getId() == id) {
                todos.remove(todo);
                break;
            }
        }
    }

    public Todo getToDoById(int id) {

        for(Todo todo: todos){
            if(id==todo.getId()) return todo;
        }
        return null;
    }

    public void updateToDo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}

