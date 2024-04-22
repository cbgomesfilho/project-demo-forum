package br.com.cbgomes.controllers.authors.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorRequest {

    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
}
