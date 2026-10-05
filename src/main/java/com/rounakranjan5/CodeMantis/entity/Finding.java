package com.rounakranjan5.CodeMantis.entity;

import com.rounakranjan5.CodeMantis.enums.FindingCategory;
import com.rounakranjan5.CodeMantis.enums.SeverityStates;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Finding {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private SeverityStates severity;

    @Enumerated(EnumType.STRING)
    private FindingCategory category;

    private String file;

    private Integer line;

    private String problem;

    private String explanation;

    private String suggestion;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

}
