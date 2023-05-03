package com.assetlift.controller;

import com.assetlift.model.User;
import com.assetlift.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/assetlift/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        var user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User userIn) throws URISyntaxException {
        var userOut = userService.saveUser(userIn);
        return ResponseEntity.created(new URI("/users/" + userOut.getId())).body(userOut);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userIn) throws URISyntaxException {
        var userOut = userService.updateUser(id, userIn);
        if (userOut != null) {
            return ResponseEntity.noContent().build();
        }
        return saveUser(userIn);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        var user = userService.getUser(id);
        if (user != null) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
