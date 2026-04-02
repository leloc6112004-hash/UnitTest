package com.basicproject.config;

import com.basicproject.model.AppUser;
import com.basicproject.model.Profile;
import com.basicproject.model.Role;
import com.basicproject.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DemoDataLoader {

  private final AppUserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Bean
  CommandLineRunner seedDemoUser() {
    return args -> {
      if (userRepository.existsByUsername("demo")) {
        return;
      }
      AppUser u =
          AppUser.builder()
              .username("demo")
              .email("demo@example.com")
              .password(passwordEncoder.encode("demo12345"))
              .firstName("Demo")
              .lastName("User")
              .active(true)
              .staff(false)
              .superuser(false)
              .build();
      Profile p = Profile.builder().role(Role.admin).displayName("Demo Admin").build();
      u.setProfile(p);
      userRepository.save(u);
    };
  }
}
