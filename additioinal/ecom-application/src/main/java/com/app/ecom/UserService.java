package com.app.ecom;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>();
    private Long nextId = 1L;

    public List<User> fetchAllUsers(){
        return userList;
    }

    public void addUser(@RequestBody User user){
        user.setId(nextId++);
        userList.add(user);
    }


    public Optional<User> fetchUser(Long id){
        return userList.stream().filter((user) -> user.getId().equals(id)).findFirst();
    }

    public Optional<User> updateUser(User user, Long id){
        return userList.stream()
                .filter(u -> u.getId().equals(id))
                .map(existingUser -> {
                    existingUser.setFirstName(user.getFirstName());
                    existingUser.setLastName(user.getLastName());
                    return existingUser;
                }).findFirst();
    }
}
