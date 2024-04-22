package br.com.cbgomes.service;

import br.com.cbgomes.controllers.authors.request.AuthorRequest;
import br.com.cbgomes.controllers.authors.request.AuthorUpdated;
import br.com.cbgomes.controllers.authors.response.AuthorResponse;
import br.com.cbgomes.mapper.ModelMapperConfiguration;
import br.com.cbgomes.mapper.utils.ConvertUtils;
import br.com.cbgomes.models.Author;
import br.com.cbgomes.repository.AuthorRepository;
import io.micrometer.observation.ObservationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    private final ConvertUtils convertUtils;
    private final ModelMapperConfiguration modelMapper;

    @Override
    public AuthorResponse createAuthor(AuthorRequest request) {
        var entity = (Author) convertUtils.convertToEntity(request, Author.class);
        return (AuthorResponse) convertUtils
                .convertToResponse(this.authorRepository.save(entity), AuthorResponse.class);
    }

    @Override
    public List<AuthorResponse> authors() {
        return convertUtils.convertToListResponse(this.authorRepository.findAll(), AuthorResponse.class);
    }

    @Override
    public AuthorResponse author(Long id) {
        return (AuthorResponse) convertUtils.convertToResponse(this.authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Author not found")), AuthorResponse.class);
    }

    @Override
    public AuthorResponse updateAuthor(AuthorUpdated request) {
        var entity = this.authorRepository
                .findById(request.getId())
                .orElseThrow(() -> new NotFoundException("Author not found"));
        modelMapper.modelMapper().map(request, entity);
        var response = (AuthorResponse) convertUtils.convertToResponse(entity, AuthorResponse.class);
        this.authorRepository.save(entity);
        return response;
    }

    @Override
    public void remove(Long id) {
        this.authorRepository.deleteById(id);
    }
}
