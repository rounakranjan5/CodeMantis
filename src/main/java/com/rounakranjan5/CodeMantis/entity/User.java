package com.rounakranjan5.CodeMantis.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer githubUserId;

    private String username;

    private String name;

    private String email;

    private String avatarUrl;

    @OneToMany(mappedBy = "user")
    private List<GitRepository> repositories;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public User(Integer githubUserId, String username, String name, String email, String avatarUrl) {
        this.githubUserId = githubUserId;
        this.username = username;
        this.name = name;
        this.email = email;
        this.avatarUrl = avatarUrl;
    }

}
