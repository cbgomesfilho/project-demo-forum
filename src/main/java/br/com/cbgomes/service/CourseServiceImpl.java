package br.com.cbgomes.service;

import br.com.cbgomes.controllers.courses.request.CourseUpdate;
import br.com.cbgomes.controllers.courses.request.CourseRequest;
import br.com.cbgomes.controllers.courses.response.CourseResponse;
import br.com.cbgomes.mapper.utils.ConvertUtils;
import br.com.cbgomes.models.Course;
import br.com.cbgomes.models.Roles;
import br.com.cbgomes.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final ConvertUtils convertUtils;


    @Override
    public CourseResponse create(CourseRequest request) {
        var entity = (Course) convertUtils.convertToEntity(request, Roles.class);
        return (CourseResponse) convertUtils
                .convertToResponse(this.courseRepository.save(entity), CourseResponse.class);
    }

    @Override
    public List<CourseResponse> courses() {
        return this.convertUtils
                .convertToListResponse(this.courseRepository.findAll(), CourseResponse.class);
    }

    @Override
    public CourseResponse update(CourseUpdate update) {
        var entity = this.courseRepository.findById(update.getId())
                .orElseThrow(() -> new NotFoundException("Course not found"));
        entity.setName(update.getName());
        entity.setCategory(update.getCategory());
        return (CourseResponse) convertUtils
                .convertToResponse( this.courseRepository.save(entity), CourseResponse.class);
    }

    @Override
    public void remove(Long id) {
        this.courseRepository.deleteById(id);
    }

    @Override
    public CourseResponse course(Long id) {
        return (CourseResponse) convertUtils
                .convertToResponse(this.courseRepository.findById(id).orElseThrow(
                        () -> new NotFoundException("Course not found")
                ), CourseResponse.class);

    }
}
