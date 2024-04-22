package br.com.cbgomes.controllers.topics.response;

import br.com.cbgomes.models.Answer;
import br.com.cbgomes.models.Author;
import br.com.cbgomes.models.Course;
import br.com.cbgomes.models.StatusTopic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TopicResponse {

    private Long id;
    private String title;
    private String message;
    private Course course;
    private Author author;
    private List<Answer> answers;
    private StatusTopic status;
}
