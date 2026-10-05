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
public class PullRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String githubPrId;

    private int number;

    private String title;

    private String description;

    private String author;

    private String state;

    private String url;

    private Integer additions;

    private Integer deletions;

    @ElementCollection
    private List<String> changedFiles;

    @ManyToOne
    @JoinColumn(name = "git_repository_id")
    private GitRepository gitRepository;

    @OneToMany(mappedBy = "pullRequest")
    private List<Review> reviews;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
