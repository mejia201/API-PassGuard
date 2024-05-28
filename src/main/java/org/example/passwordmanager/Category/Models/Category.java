package org.example.passwordmanager.Category.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.example.passwordmanager.User.Models.User;

@Entity
@Data
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String categoryName;
    private String description;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;

}
