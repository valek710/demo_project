package com.example.demo_project.controller;

import com.example.demo_project.dto.UserDTO;
import com.example.demo_project.entity.User;
import com.example.demo_project.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Api(value = "User Rest Controller")
public class UserController {

    @Autowired
    private final UserService userService;

    @ApiOperation(value = "Get all Users ", tags = "User")
    @GetMapping("/users")
    public @ResponseBody ResponseEntity<List<UserDTO>> users() {
        return new ResponseEntity<>(userService.getUsers(), OK);
    }

    @ApiOperation(value = "Get user", tags = "User")
    @GetMapping("/user/{id}")
    public @ResponseBody ResponseEntity<UserDTO> user(@PathVariable long id) {
        return new ResponseEntity<>(userService.getUser(id), OK);
    }

    @ApiOperation(value = "Post user ", tags = "User")
    @PostMapping("/user")
    public @ResponseBody ResponseEntity<UserDTO> postUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(new UserDTO(user.getFirstName(), user.getLastName(), user.getAge())), CREATED);
    }

    @ApiOperation(value = "Delete user ", tags = "User")
    @DeleteMapping(value = "/user/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> deleteUser(@PathVariable long id) {
        var user = userService.getUser(id);
        if (user == null)
            return new ResponseEntity<>("{\"error\": \"User with id " + id + " not found!\"}", NOT_FOUND);
        userService.deleteUser(user);
        return new ResponseEntity<>(ACCEPTED);
    }
}
