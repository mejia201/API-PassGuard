package org.example.passwordmanager.Category.Repository;

import org.example.passwordmanager.Category.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c FROM Category c WHERE c.user.userId = :userId")
    List<Category> findByUserId(Long userId);
}
