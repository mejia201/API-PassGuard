package org.example.passwordmanager.Password.Repository;

import org.example.passwordmanager.Category.Models.Category;
import org.example.passwordmanager.Password.Models.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasswordRepository  extends JpaRepository<Password, Long> {
    @Query(value = "SELECT * FROM Passwords p WHERE user_id = :userId", nativeQuery = true)
    List<Password> findByUserId(Long userId);
}
