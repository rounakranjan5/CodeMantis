package com.rounakranjan5.CodeMantis.entity;

import com.rounakranjan5.CodeMantis.enums.ReviewStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private ReviewStatus status;

    private Double riskScore;

    private String summary;

    @ManyToOne
    @JoinColumn(name = "pull_request_id")
    private PullRequest pullRequest;

    @OneToMany(mappedBy = "review")
    private List<Finding> findings;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime completedAt;

}
