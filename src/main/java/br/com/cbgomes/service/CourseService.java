package br.com.cbgomes.service;

import br.com.cbgomes.controllers.courses.request.CourseUpdate;
import br.com.cbgomes.controllers.courses.request.CourseRequest;
import br.com.cbgomes.controllers.courses.response.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseResponse create(CourseRequest request);

    List<CourseResponse> courses();

    CourseResponse update(CourseUpdate update);

    void remove(Long id);

    CourseResponse course(Long id);
}
