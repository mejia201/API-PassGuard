package org.example.passwordmanager.Password.Repository;

import org.example.passwordmanager.Password.Models.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository  extends JpaRepository<Password, Long> {
}
