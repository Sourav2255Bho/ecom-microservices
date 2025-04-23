package com.app.ecom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/api/users")
//    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>>getAllUsers(){
        return new ResponseEntity<>(userService.fetchAllUsers(),HttpStatus.OK);
//        return ResponseEntity.ok(userService.fetchAllUsers());
    }

    @PostMapping("/api/users")
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>("User Created Successfully !", HttpStatus.CREATED);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
//        User user = userService.fetchUser(id);
//        if(user == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(user, HttpStatus.OK) ;
//

        return userService.fetchUser(id).map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        return userService.updateUser(user,id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
