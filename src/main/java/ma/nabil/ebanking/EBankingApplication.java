package ma.nabil.ebanking;

import ma.nabil.ebanking.entities.User;
import ma.nabil.ebanking.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EBankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(EBankingApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(UserRepository userRepository) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User adminUser = new User();
                adminUser.setUsername("admin");
                adminUser.setPassword(new BCryptPasswordEncoder().encode("adminPassword"));
                adminUser.setRole("ROLE_ADMIN");
                adminUser.setEnabled(true);
                userRepository.save(adminUser);
            }
        };
    }
}