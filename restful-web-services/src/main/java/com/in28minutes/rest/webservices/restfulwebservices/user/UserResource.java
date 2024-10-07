package com.in28minutes.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }


    @GetMapping("/users")
    public List<User> getUsers(){
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        User user = userDaoService.getOne(id);

//        If client enters id which doesn't exist i.e non existing user, then user == null. In which case we need to throw right error which 404
        if(user==null) throw new UserNotFoundException("id " + id);
        else return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){ // Adding Validations to object received.
//        @RequestBody User user : means client will send a JSON body, and Spring will automatically convert this into a User object using the @RequestBody annotation.
        User savedUser = userDaoService.save(user); // Data of new user created

//        location is created to give the client location/path/URI of the new resource created
        URI location = ServletUriComponentsBuilder.fromCurrentRequest() // path till jaha se bhi request aaya to create new resource. Here localhost:8080/users
                        .path("/{id}") // adding this to the path -> localhost:8080/users/{id}. id is variable name. We can name it anything.
                        .buildAndExpand(savedUser.getId()) // replace {id} with actual created user id. For eg, users/4
                        .toUri(); // This converts the final URL into a URI object, which can be used in the response.

        return ResponseEntity.created(location).build();
 /*       ResponseEntity: This is a special type in Spring that lets you customize the HTTP response you send back to the client (201 created response ke liye hi typically).
                          You can control things like the status code, headers, and body.
          .created(location): This method is used when you want to tell the client that a new resource has been created. Normally, we pass the URI (Uniform Resource Identifier i.e path to the created user) of the new resource inside created().
          .build(): This method finalizes the building of the response. It means the response is ready. */
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userDaoService.deleteById(id);
    }
}
