package com.in28minutes.rest.webservices.restfulwebservices.service;

import com.in28minutes.rest.webservices.restfulwebservices.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static Integer userCount = 0;

    static {
        users.add(new User(++userCount, "Tan", LocalDate.now()));
        users.add(new User(++userCount, "Tan1", LocalDate.now()));
        users.add(new User(++userCount, "Tan2", LocalDate.now()));
    }

    public List<User> findAll() {
        return users;
    }

     public User save (User user){
         user.setId(++userCount);
         users.add(user);
        return user;
     }

    public User findOneByID(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);

        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id){
        Predicate<? super  User> predicate = user -> user.getId().equals(id);
               users.removeIf(predicate);

    }
}
