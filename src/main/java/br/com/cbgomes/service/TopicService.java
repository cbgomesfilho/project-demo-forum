package br.com.cbgomes.service;

import br.com.cbgomes.controllers.topics.request.TopicRequest;
import br.com.cbgomes.controllers.topics.request.TopicUpdate;
import br.com.cbgomes.controllers.topics.response.TopicResponse;
import br.com.cbgomes.models.Topic;

import java.util.List;

public interface TopicService {

    TopicResponse create(TopicRequest request);
    List<TopicResponse> listTopics();
    TopicResponse topic(Long id);
    TopicResponse update(TopicUpdate update);
    void remove(Long id);
}
