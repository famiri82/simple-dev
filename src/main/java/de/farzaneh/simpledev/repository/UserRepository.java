package de.farzaneh.simpledev.repository;

import de.farzaneh.simpledev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
