package br.com.cbgomes.service;

import br.com.cbgomes.controllers.answers.request.AnswerRequest;
import br.com.cbgomes.controllers.answers.request.AnswerUpdate;
import br.com.cbgomes.controllers.answers.response.AnswerResponse;

import java.util.List;

public interface AnswerService {

    AnswerResponse create(AnswerRequest request);

    List<AnswerResponse> answers();

    AnswerResponse answer(Long id);

    AnswerResponse update(AnswerUpdate update);

    void remove(Long id);
}
