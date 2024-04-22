package br.com.cbgomes.controllers.topics;

import br.com.cbgomes.controllers.roles.response.RolesResponse;
import br.com.cbgomes.controllers.topics.request.TopicRequest;
import br.com.cbgomes.controllers.topics.request.TopicUpdate;
import br.com.cbgomes.controllers.topics.response.TopicResponse;
import br.com.cbgomes.models.Roles;
import br.com.cbgomes.models.Topic;
import br.com.cbgomes.service.TopicService;
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
@RequestMapping("/api/v1/topics")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Topic Controlle", description = "Manger all topic created on application")
public class TopicController {

    private final TopicService topicService;

    @Operation(
            summary = "List Topics",
            description = "List all topics create on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Topic.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @GetMapping
    public ResponseEntity<List<TopicResponse>> topics() {
        return ResponseEntity.ok(this.topicService.listTopics());
    }

    @Operation(
            summary = "Get Topic",
            description = "Get one topic create on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Topic.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @GetMapping("/{id}")
    public ResponseEntity<TopicResponse> topic(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.topicService.topic(id));
    }

    @Operation(
            summary = "Create Topic",
            description = "Create topic on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Topic.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @PostMapping
    public ResponseEntity<TopicResponse> topic(@RequestBody TopicRequest request) {
        return ResponseEntity.ok(this.topicService.create(request));
    }

    @Operation(
            summary = "Update Topic",
            description = "Update topic on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Topic.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @PutMapping
    public ResponseEntity<TopicResponse> update(@RequestBody TopicUpdate request) {
        return ResponseEntity.ok(this.topicService.update(request));
    }

    @Operation(
            summary = "Create Topic",
            description = "Create topic on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Topic.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        this.topicService.remove(id);
        return ResponseEntity.ok().build();
    }
}
