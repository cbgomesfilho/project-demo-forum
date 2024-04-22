package br.com.cbgomes.controllers.topics.request;

import br.com.cbgomes.models.Answer;
import br.com.cbgomes.models.Author;
import br.com.cbgomes.models.Course;
import br.com.cbgomes.models.StatusTopic;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TopicRequest {
    @NotEmpty
    private String title;
    @NotEmpty
    private String message;
    @NotEmpty
    private Course course;
    @NotEmpty
    private Author author;
    @NotEmpty
    private List<Answer> answers = new ArrayList<>();
    @NotEmpty
    private StatusTopic status = StatusTopic.NOT_ANSWERED;
}
