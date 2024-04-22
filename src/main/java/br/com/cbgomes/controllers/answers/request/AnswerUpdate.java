package br.com.cbgomes.controllers.answers.request;


import br.com.cbgomes.models.Author;
import br.com.cbgomes.models.Topic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnswerUpdate {

    private Long id;
    private String message;
    private Author userAuthor;
    private Topic topic;
    private boolean isSortedOut = false;
}
