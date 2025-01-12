package br.com.springboot.ibm.challenge.controller;

import br.com.springboot.ibm.challenge.entity.User;
import br.com.springboot.ibm.challenge.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setFullName("Pedro Monteiro");
        user.setEmail("teste@gmail.com");
        user.setPhone("+55 14 99606-2960");
        user.setBirthDate(new Date());
        user.setUserType("admin");
    }

    @Test
    void testAddUserSuccess() {
        when(userService.addUser(user)).thenReturn(user);

        ResponseEntity<Object> response = userController.addUser(user);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(user, response.getBody());
    }

    @Test
    void testGetAllUsersSuccess() {
        List<User> listUser = new ArrayList<>();
        listUser.add(user);

        when(userService.getAllUsers()).thenReturn(listUser);

        ResponseEntity<Object> response = userController.getAllUsers();

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetUserByIdSuccess() {
        when(userService.getUserById(1L)).thenReturn(Optional.of(user));

        ResponseEntity<Object> response = userController.getUserById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(user, response.getBody());
    }

    @Test
    void testUpdateUserByIdSuccess() {
        when(userService.getUserById(1L)).thenReturn(Optional.of(user));
        when(userService.updateUser(user)).thenReturn(user);

        ResponseEntity<Object> response = userController.updateUserById(1L, user);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(user, response.getBody());
    }

    @Test
    void testDeleteUserByIdSuccess() {
        when(userService.getUserById(1L)).thenReturn(Optional.of(user));
        doNothing().when(userService).deleteUser(1L);

        ResponseEntity<Object> response = userController.deleteUserById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("", response.getBody());
    }

}

