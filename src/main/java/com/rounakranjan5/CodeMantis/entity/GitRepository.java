package com.rounakranjan5.CodeMantis.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class GitRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String githubRepoId;

    private String name;

    private String fullName;

    private String owner;

    private String url;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "gitRepository")
    private List<PullRequest> pullRequests;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
