package ru.nikitina.NauJava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "report")
@Getter
@Setter
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private ReportStatus status;

    @Column(name = "content", columnDefinition = "TEXT", length = 50000)
    private String content;
    public Report() {
        this.status = ReportStatus.CREATED;
    }
}
