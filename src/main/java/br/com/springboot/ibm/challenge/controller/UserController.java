package br.com.springboot.ibm.challenge.controller;

import br.com.springboot.ibm.challenge.entity.User;
import br.com.springboot.ibm.challenge.pattern.TechManageErrors;
import br.com.springboot.ibm.challenge.pattern.TechManagerException;
import br.com.springboot.ibm.challenge.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(user));
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {

        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        if(user.isEmpty()){
            throw new TechManagerException(TechManageErrors.USER_NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> updateUserById(@PathVariable Long id, @RequestBody User userUpdated) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userUpdated));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteUserById(@RequestBody @Valid User userUpdated) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userUpdated));
    }
}
