package org.example.passwordmanager.Platform.Repository;

import org.example.passwordmanager.Password.Models.Password;
import org.example.passwordmanager.Platform.Models.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {
    @Query(value = "SELECT * FROM Platforms p WHERE user_id = :userId", nativeQuery = true)
    List<Platform> findByUserId(Long userId);
}
