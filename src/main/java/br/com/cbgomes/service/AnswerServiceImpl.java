package br.com.cbgomes.service;

import br.com.cbgomes.controllers.answers.request.AnswerRequest;
import br.com.cbgomes.controllers.answers.request.AnswerUpdate;
import br.com.cbgomes.controllers.answers.response.AnswerResponse;
import br.com.cbgomes.controllers.authors.response.AuthorResponse;
import br.com.cbgomes.mapper.ModelMapperConfiguration;
import br.com.cbgomes.mapper.utils.ConvertUtils;
import br.com.cbgomes.models.Answer;
import br.com.cbgomes.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService{

    private final AnswerRepository answerRepository;

    private final ConvertUtils convertUtils;

    private final ModelMapperConfiguration modelMapper;

    @Override
    public AnswerResponse create(AnswerRequest request) {
        var entity = (Answer)convertUtils.convertToEntity(request, Answer.class);
        return (AnswerResponse) convertUtils
                .convertToResponse(this.answerRepository.save(entity), AnswerResponse.class);
    }

    @Override
    public List<AnswerResponse> answers() {
        return convertUtils.convertToListResponse(this.answerRepository.findAll(), AnswerResponse.class);
    }

    @Override
    public AnswerResponse answer(Long id) {
        return (AnswerResponse) convertUtils.convertToResponse(this.answerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Author not found")), AnswerResponse.class);
    }

    @Override
    public AnswerResponse update(AnswerUpdate update) {
        var entity = this.answerRepository
                .findById(update.getId())
                .orElseThrow(() -> new NotFoundException("Author not found"));
        modelMapper.modelMapper().map(update, entity);
        var response = (AnswerResponse) convertUtils.convertToResponse(entity, AnswerResponse.class);
        this.answerRepository.save(entity);

        return response;
    }

    @Override
    public void remove(Long id) {
        this.answerRepository.deleteById(id);
    }
}
