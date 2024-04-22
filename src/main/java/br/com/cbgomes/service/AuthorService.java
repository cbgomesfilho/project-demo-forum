package br.com.cbgomes.service;

import br.com.cbgomes.controllers.authors.request.AuthorRequest;
import br.com.cbgomes.controllers.authors.request.AuthorUpdated;
import br.com.cbgomes.controllers.authors.response.AuthorResponse;

import java.util.List;

public interface AuthorService {

    AuthorResponse createAuthor(AuthorRequest request);

    List<AuthorResponse> authors();

    AuthorResponse author(Long id);

    AuthorResponse updateAuthor(AuthorUpdated request);

    void remove(Long id);
}
