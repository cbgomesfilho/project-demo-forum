package br.com.cbgomes.controllers.answers;

import br.com.cbgomes.controllers.answers.request.AnswerRequest;
import br.com.cbgomes.controllers.answers.request.AnswerUpdate;
import br.com.cbgomes.controllers.answers.response.AnswerResponse;
import br.com.cbgomes.controllers.authors.response.AuthorResponse;
import br.com.cbgomes.models.Answer;
import br.com.cbgomes.models.Author;
import br.com.cbgomes.service.AnswerService;
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
@RequestMapping("/api/v1/answers")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Answer Controlle", description = "Manager all answers on application")
public class AnswerController {

    private final AnswerService answerService;

    @Operation(
            summary = "List Answer ",
            description = "List all answers create on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Answer.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @GetMapping
    public ResponseEntity<List<AnswerResponse>> answere() {
        return ResponseEntity.ok(this.answerService.answers());
    }

    @Operation(
            summary = "Get Answer ",
            description = "Get one answers create on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Answer.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @GetMapping("/{id}")
    public ResponseEntity<AnswerResponse> answer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.answerService.answer(id));
    }

    @Operation(
            summary = "Create Answer ",
            description = "Create one answers create on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Answer.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @PostMapping()
    public ResponseEntity<AnswerResponse> create(@RequestBody AnswerRequest request) {
        return ResponseEntity.ok(this.answerService.create(request));
    }

    @Operation(
            summary = "Update Answer ",
            description = "Update one answers create on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Answer.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @PutMapping()
    public ResponseEntity<AnswerResponse> update(@RequestBody AnswerUpdate request) {
        return ResponseEntity.ok(this.answerService.update(request));
    }

    @Operation(
            summary = "Get Answer ",
            description = "Get one answers create on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Answer.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        this.answerService.remove(id);
        return ResponseEntity.ok().build();
    }
}
