package br.com.cbgomes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "answer_id_sequence")
    @SequenceGenerator(name = "answer_id_sequence", sequenceName = "answer_id_sequence")
    private Long id;
    private String message;
    @ManyToOne
    private Author userAuthor;
    @ManyToOne
    private Topic topic;
    private boolean isSortedOut = false;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}

