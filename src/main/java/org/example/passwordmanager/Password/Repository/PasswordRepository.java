package org.example.passwordmanager.Password.Repository;

import org.example.passwordmanager.Category.Models.Category;
import org.example.passwordmanager.Password.Models.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PasswordRepository  extends JpaRepository<Password, Long> {
    @Query("SELECT c FROM Password c WHERE c.user.userId = :userId")
    List<Password> findByUserId(Long userId);
}
