package org.example.passwordmanager.Category.Repository;

import org.example.passwordmanager.Category.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
