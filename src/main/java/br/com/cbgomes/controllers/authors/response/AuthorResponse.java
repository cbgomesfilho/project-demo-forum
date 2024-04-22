package br.com.cbgomes.controllers.authors.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorResponse {

    private Long id;
    private String name;
    private String email;
}
