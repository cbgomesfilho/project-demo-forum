package br.com.cbgomes.controllers.authors.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorUpdated {

    private Long id;
    private String name;
    private String email;
}
