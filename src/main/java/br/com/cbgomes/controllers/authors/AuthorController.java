package br.com.cbgomes.controllers.authors;

import br.com.cbgomes.controllers.authors.request.AuthorRequest;
import br.com.cbgomes.controllers.authors.request.AuthorUpdated;
import br.com.cbgomes.controllers.authors.response.AuthorResponse;
import br.com.cbgomes.controllers.roles.response.RolesResponse;
import br.com.cbgomes.models.Author;
import br.com.cbgomes.models.Roles;
import br.com.cbgomes.service.AuthorService;
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
@RequestMapping("/api/v1/autors")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Author Controlle", description = "Manager all authors on application")
public class AuthorController {

    private final AuthorService authorService;

    @Operation(
            summary = "List Authors",
            description = "List all authors create on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Author.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @GetMapping
    public ResponseEntity<List<AuthorResponse>> roles() {
        return ResponseEntity.ok(this.authorService.authors());
    }

    @Operation(
            summary = "Create Authors",
            description = "Create author on application")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Author.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @PostMapping
    public ResponseEntity<AuthorResponse> create(@RequestBody AuthorRequest request) {
        return ResponseEntity.ok(this.authorService.createAuthor(request));
    }

    @Operation(
            summary = "Get Authors",
            description = "Get author on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Author.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> author(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.authorService.author(id));
    }

    @Operation(
            summary = "Delete Authors",
            description = "Delete author on application")
    @ApiResponses({
            @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema(implementation = Author.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @DeleteMapping
    public ResponseEntity delete(@PathVariable("id") Long id) {
        this.authorService.remove(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Update Authors",
            description = "Update author on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Author.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @PutMapping
    public ResponseEntity<AuthorResponse> update(@RequestBody AuthorUpdated updated) {
        return ResponseEntity.ok(this.authorService.updateAuthor(updated));
    }
}
