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
        return ResponseEntity.status(HttpStatus.OK).body(validUser(userService.getUserById(id)));
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> updateUserById(@PathVariable Long id, @RequestBody @Valid User userUpdated) {
        validUser(userService.getUserById(id));
        userUpdated.setId(id);

        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userUpdated));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteUserById(@PathVariable Long id) {
        validUser(userService.getUserById(id));
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    private User validUser(Optional<User> userValidating){
        if(userValidating.isEmpty()){
            throw new TechManagerException(TechManageErrors.USER_NOT_FOUND);
        }
        return userValidating.get();
    }
}
