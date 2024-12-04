package ma.nabil.ebanking.controller;

import lombok.RequiredArgsConstructor;
import ma.nabil.ebanking.dto.PasswordChangeDto;
import ma.nabil.ebanking.dto.UserRegistrationDto;
import ma.nabil.ebanking.entities.User;
import ma.nabil.ebanking.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        User user = userService.registerUser(registrationDto);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        User user = userService.getUser(username);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{username}/updateRole")
    public ResponseEntity<User> updateUserRole(@PathVariable String username, @RequestParam String role) {
        User user = userService.updateUserRole(username, role);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{username}")
    public ResponseEntity<User> changePassword(@PathVariable String username, @RequestBody PasswordChangeDto passwordChangeDto) {
        User user = userService.changePassword(username, passwordChangeDto);
        return ResponseEntity.ok(user);
    }
}