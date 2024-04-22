package br.com.cbgomes.controllers.answers.request;

import br.com.cbgomes.models.Author;
import br.com.cbgomes.models.Topic;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnswerRequest {

    @NotEmpty
    private String message;
    @NotEmpty
    private Author userAuthor;
    @NotEmpty
    private Topic topic;
    @NotEmpty
    private boolean isSortedOut = false;
}
