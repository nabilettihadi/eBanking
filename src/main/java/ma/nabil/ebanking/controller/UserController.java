package ma.nabil.ebanking.controller;

import lombok.RequiredArgsConstructor;
import ma.nabil.ebanking.dto.PasswordChangeDto;
import ma.nabil.ebanking.dto.UserRegistrationDto;
import ma.nabil.ebanking.entities.User;
import ma.nabil.ebanking.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        User user = userService.registerUser(registrationDto);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/myAccount")
    public ResponseEntity<String> getMyAccount() {
        return ResponseEntity.ok("Informations sur le compte de l'utilisateur connecté");
    }

    @GetMapping("/myBalance")
    public ResponseEntity<String> getMyBalance() {
        return ResponseEntity.ok("Solde global des comptes de l'utilisateur connecté");
    }

    @PutMapping("/{username}/changePassword")
    public ResponseEntity<User> changePassword(@PathVariable String username, @RequestBody PasswordChangeDto passwordChangeDto) {
        User user = userService.changePassword(username, passwordChangeDto);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/myLoans")
    public ResponseEntity<String> getMyLoans() {
        return ResponseEntity.ok("Informations sur les prêts de l'utilisateur connecté");
    }

    @GetMapping("/myCards")
    public ResponseEntity<String> getMyCards() {
        return ResponseEntity.ok("Informations sur les cartes de l'utilisateur connecté");
    }
}