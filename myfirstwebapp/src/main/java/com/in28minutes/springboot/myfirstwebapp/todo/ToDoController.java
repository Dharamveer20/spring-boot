package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@SessionAttributes("name")
@Controller
public class ToDoController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    TodoService todoService;

    public ToDoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/list-todos")
    public String listAllToDos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername ("Uano");

        // Model ke through transferred data bhi request scope me aata hai.
        model.put("todos", todos);// can only be accessed by listToDos view and no other page.
        return "listToDos";
    }

    @RequestMapping(path = "/add-todo", method = RequestMethod.GET)
    public String showNewToDo(ModelMap model) {
        String username = getLoggedinUsername(model);
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
//        Object kyun banaya?
//        Jab user "Add To Do" form kholta hai (/add-todo URL par), us form ko ek empty Todo object chahiye hota hai taaki form ke fields kisi object ke saath bind ho sakein.
        model.put("todo", todo);
//        model.put("todo", todo) ka matlab hai ki hum Todo object ko model mein daal rahe hain, jo baad mein JSP page (frontend) pe access ho sakta hai.
        return "todo";
    }

    @RequestMapping(path = "/add-todo", method = RequestMethod.POST)
    // Whatever the user will enter will be automatically mapped to todo object. This object is known as command bean
    // Make sure ModelMap object is first and the command bean next
    public String addNewToDo(ModelMap model, @Valid Todo todo, BindingResult result) {
//
        if (result.hasErrors()) {
            return "todo";
        }
//        About @Valid Annotation: When a form is submitted, Spring automatically binds the form fields to the corresponding properties of the model object.
//The @Valid annotation tells Spring to check if the fields meet the validation constraints (like @NotNull, @Size, etc.) that you have defined in the model (here Todo Class).

//        ABout BindindResult:
//        Agar Validation perform krne me koi error aaya to BindingResult error ka info store kr lega
//        BindingResult must immediately follow the model object that has been annotated with @Valid. If it’s not in the correct order, Spring MVC will throw an error.
        String username = getLoggedinUsername(model);
        todoService.addToDo(username, todo.getDescription(), todo.getTargetDate(), false);

        return "redirect:list-todos";
    }

    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(path = "/update-todo", method = RequestMethod.GET)
    public String updateToDo(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.getToDoById(id);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(path = "/update-todo", method = RequestMethod.POST)
    public String updateToDo(ModelMap model, @Valid Todo todo, BindingResult result) {
//
        if (result.hasErrors()) {
            return "todo";
        }

        String username = getLoggedinUsername(model);
        todo.setUsername(username);
        todoService.updateToDo(todo);

        return "redirect:list-todos";
    }

    private String getLoggedinUsername(ModelMap model) {

//        Authentication object: Yeh user ki authentication details ko represent karta hai. Hum SecurityContext se yeh details lete hain.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // authentication object se user ka naam (username) return kar rahe hain
        return authentication.getName();
    }
}

