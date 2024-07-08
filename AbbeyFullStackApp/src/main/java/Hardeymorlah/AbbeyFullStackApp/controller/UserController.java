package Hardeymorlah.AbbeyFullStackApp.controller;

import Hardeymorlah.AbbeyFullStackApp.model.DTOs.LoginRequest;
import Hardeymorlah.AbbeyFullStackApp.model.DTOs.LoginResponse;
import Hardeymorlah.AbbeyFullStackApp.model.User;
import Hardeymorlah.AbbeyFullStackApp.service.UserService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@Data
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/all_users")
    public ResponseEntity<List<User>> allUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/user_by_id/{id}")
    public ResponseEntity<User> getById(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/user_by_username")
    public ResponseEntity<User> getByUsername(@RequestParam String username) {
        return userService.findUserByUsername(username);

    }
    @PostMapping("/register")
    public ResponseEntity<User> createUser(@Valid @RequestBody User newUser) {
        return userService.createNewUser(newUser);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest loginRequest) {
        return userService.authenticate(loginRequest);
    }
    @PutMapping("/update_user/{id}")
    public ResponseEntity<User> updateUser(@Valid @PathVariable long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }
    @DeleteMapping("/delete_user/{id}")

    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }
}
