package org.example.passwordmanager.User.Repository;

import org.example.passwordmanager.User.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
