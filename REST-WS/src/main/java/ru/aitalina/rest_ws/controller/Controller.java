package ru.aitalina.rest_ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.aitalina.rest_ws.dao.RoleRepo;
import ru.aitalina.rest_ws.model.User;
import ru.aitalina.rest_ws.model.UserDto;
import ru.aitalina.rest_ws.model.UserRole;
import ru.aitalina.rest_ws.service.UserService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class Controller {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepo roleRepo;

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        List<User> response = userService.findAllUsers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/username/{login}")
    public ResponseEntity<Object> getUserByLogin(@PathVariable("login") String login) {
        User user = userService.findUserByLogin(login);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    @ResponseStatus(HttpStatus.OK)
    public void saveUser(@RequestBody UserDto userDto) {
        User user = new User(userDto.getLogin(), userDto.getPassword(), true);
        System.out.println(userDto.getLogin());
        System.out.println(userDto.getPassword());
        String[] roles = userDto.getRoles();
        for (int i = 0; i<roles.length; i++) {
            UserRole userRole = roleRepo.findUserRoleByRole(roles[i]);
            user.addRole(userRole);
        }
        userService.saveUser(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) //    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable("id") Long id,  @RequestBody UserDto u) {
        User user = userService.findUserById(id);
        user.setLogin(u.getLogin());
        user.setPassword(u.getPassword());
        user.getRole().clear();
        String[] roles = u.getRoles();
        for (int i = 0; i<roles.length; i++) {
            UserRole userRole = roleRepo.findUserRoleByRole(roles[i]);
            System.out.println(userRole);
            user.addRole(userRole);
        }
        userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<Object> getUserRole(@PathVariable("id") Long id) {
        Set<UserRole> response = userService.findUserById(id).getRole();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<Object> getUserRoles() {
        List<UserRole> usersList = roleRepo.findAll();
        String[] users = new String[usersList.size()];
        for (int i=0; i<usersList.size(); i++) {
            users[i]=usersList.get(i).getRole();
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
