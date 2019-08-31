package ua.jackson.sweater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.jackson.sweater.domain.User;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
