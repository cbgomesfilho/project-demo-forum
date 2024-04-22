package br.com.cbgomes.auth;

import br.com.cbgomes.auth.request.AuthenticateRequest;
import br.com.cbgomes.auth.request.RegisterRequest;
import br.com.cbgomes.auth.response.AuthenticationResponse;
import br.com.cbgomes.models.Users;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Authentication Controller", description = "Authenticate and register user on application  ")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(
            summary = "Register a new user to application",
            description = "Description create a new user")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Users.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:3001", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @Operation(
            summary = "Generate a new token to user created",
            description = "Generate toke to user application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Users.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticateRequest request){
        return ResponseEntity.ok(authenticationService.authenticated(request));
    }

}
