package br.com.cbgomes.controllers.courses.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseResponse {
    private Long id;
    private String name;
    private String category;
}
