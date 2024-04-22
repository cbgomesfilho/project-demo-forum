package br.com.cbgomes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Topic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "topic_id_sequence")
    @SequenceGenerator(name = "topic_id_sequence", sequenceName = "topic_id_sequence")
    private Long id;

    private String title;
    private String message;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    @ManyToOne
    private Course course;
    @ManyToOne
    private Author author;
    @OneToMany(mappedBy = "topic")
    private List<Answer> answers = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private StatusTopic status = StatusTopic.NOT_ANSWERED;

}
