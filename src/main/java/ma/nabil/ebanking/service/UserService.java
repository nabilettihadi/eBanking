package ma.nabil.ebanking.service;

import lombok.RequiredArgsConstructor;
import ma.nabil.ebanking.dto.PasswordChangeDto;
import ma.nabil.ebanking.dto.UserRegistrationDto;
import ma.nabil.ebanking.entities.User;
import ma.nabil.ebanking.exceptions.UsernameAlreadyExistsException;
import ma.nabil.ebanking.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(UserRegistrationDto registrationDto) {
        if (userRepository.findByUsername(registrationDto.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }

        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }

    public User updateUserRole(String username, String newRole) {
        User user = getUser(username);
        user.setRole(newRole);
        return userRepository.save(user);
    }

    public User changePassword(String username, PasswordChangeDto passwordChangeDto) {
        User user = getUser(username);

        if (!passwordEncoder.matches(passwordChangeDto.getOldPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid old password");
        }

        user.setPassword(passwordEncoder.encode(passwordChangeDto.getNewPassword()));
        return userRepository.save(user);
    }
}