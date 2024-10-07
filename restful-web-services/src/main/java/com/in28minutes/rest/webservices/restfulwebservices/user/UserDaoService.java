package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<User>();
    static int count = 0;
    static{
        users.add(new User(++count,"Aano", LocalDate.now().minusYears(20)));
        users.add(new User(++count,"Bano", LocalDate.now().minusYears(20)));
        users.add(new User(++count,"Cano", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User getOne(int id) {
        Predicate<User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        Predicate<User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate); // loops over users list and if predicate is true removes that element.
    }

    public User save(User user) {
        user.setId(++count);
        users.add(user);
        return user;
    }
}
