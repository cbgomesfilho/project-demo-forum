package br.com.cbgomes.controllers.courses;

import br.com.cbgomes.controllers.courses.request.CourseRequest;
import br.com.cbgomes.controllers.courses.request.CourseUpdate;
import br.com.cbgomes.controllers.courses.response.CourseResponse;
import br.com.cbgomes.controllers.roles.request.RolesRequest;
import br.com.cbgomes.controllers.roles.request.RolesUpdate;
import br.com.cbgomes.controllers.roles.response.RolesResponse;
import br.com.cbgomes.models.Course;
import br.com.cbgomes.models.Roles;
import br.com.cbgomes.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Course Controller", description = "Manager all application courses")
public class CourseController {

    private final CourseService courseService;

    @Operation(
            summary = "List Courses",
            description = "List all courses create on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Course.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @GetMapping
    public ResponseEntity<List<CourseResponse>> courses() {
        return ResponseEntity.ok(this.courseService.courses());
    }

    @Operation(
            summary = "Get Course",
            description = "Return course by roles id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Course.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> courseById(@PathVariable("id") Long id) {
        var response = this.courseService.course(id);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Create Course",
            description = "Create course on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Course.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @PostMapping
    public ResponseEntity<CourseResponse> createCourse(@RequestBody CourseRequest request) {
        return ResponseEntity.ok(this.courseService.create(request));
    }

    @Operation(
            summary = "Remove Course",
            description = "Remove course on application by role id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Course.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @DeleteMapping("/{id}")
    public ResponseEntity delteCourse(@PathVariable("id") Long id) {
        this.courseService.remove(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Edit Course",
            description = "Edit course on application by RolesUpdate object")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Course.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @PutMapping
    public ResponseEntity<CourseResponse> updatedCourse(@RequestBody CourseUpdate request){
        return ResponseEntity.ok(this.courseService.update(request));
    }
}
