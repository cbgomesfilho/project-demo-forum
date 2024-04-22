package br.com.cbgomes.service;

import br.com.cbgomes.controllers.topics.request.TopicRequest;
import br.com.cbgomes.controllers.topics.request.TopicUpdate;
import br.com.cbgomes.controllers.topics.response.TopicResponse;
import br.com.cbgomes.mapper.ModelMapperConfiguration;
import br.com.cbgomes.mapper.utils.ConvertUtils;
import br.com.cbgomes.models.Topic;
import br.com.cbgomes.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService{

    private final TopicRepository topicRepository;
    private final ConvertUtils convertUtils;

    @Override
    public TopicResponse create(TopicRequest request) {
        return (TopicResponse) convertUtils.convertToResponse(
                this.topicRepository.save((Topic)
                        this.convertUtils.convertToEntity(request, Topic.class)
                ), TopicResponse.class
        );
    }

    @Override
    public List<TopicResponse> listTopics() {
        return this.convertUtils.convertToListResponse(this.topicRepository.findAll(),
                TopicResponse.class);
    }

    @Override
    public TopicResponse topic(Long id) {
        return (TopicResponse) this.convertUtils.convertToResponse(
                this.topicRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Topic not found")),
                TopicResponse.class
        );
    }

    @Override
    public TopicResponse update(TopicUpdate update) {
        var editable = (Topic) this.topicRepository.findById(update.getId())
                .orElseThrow(()-> new NotFoundException("Topic not found"));
        var entity = (Topic) convertUtils.convertToEntity(update, editable.getClass());
        return (TopicResponse) convertUtils
                .convertToResponse(this.topicRepository.save(entity), TopicResponse.class);
    }

    @Override
    public void remove(Long id) {
        this.topicRepository.deleteById(id);
    }
}
