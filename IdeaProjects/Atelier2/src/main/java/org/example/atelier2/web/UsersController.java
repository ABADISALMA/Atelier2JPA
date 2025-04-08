package org.example.atelier2.web;

import org.example.atelier2.entities.User;
import org.example.atelier2.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    private UserService userService;

    @GetMapping("/users/{username}")
    public User user(@PathVariable String username) {
          User user = userService.findUserByUsername(username);
        return user;
    }
}
