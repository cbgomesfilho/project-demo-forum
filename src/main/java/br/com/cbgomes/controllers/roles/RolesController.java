package br.com.cbgomes.controllers.roles;

import br.com.cbgomes.controllers.roles.request.RolesRequest;
import br.com.cbgomes.controllers.roles.request.RolesUpdate;
import br.com.cbgomes.controllers.roles.response.RolesResponse;
import br.com.cbgomes.models.Roles;
import br.com.cbgomes.service.RoleService;
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

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Roles Controller", description = "Manager all application roles")
public class RolesController {

    private final RoleService roleService;

    @Operation(
            summary = "List Roles",
            description = "List all roles create on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Roles.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @GetMapping
    public ResponseEntity<List<RolesResponse>> roles() {

        return ResponseEntity.ok(this.roleService.listRoles());
    }
    @Operation(
            summary = "Get Roles",
            description = "Return roles by roles id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Roles.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @GetMapping("/{id}")
    public ResponseEntity<RolesResponse> rolesById(@PathVariable("id") Long id) {
        var response = this.roleService.getRoles(id);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Create Roles",
            description = "Create role on application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Roles.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @PostMapping
    public ResponseEntity<RolesResponse> createRole(@RequestBody RolesRequest request) {
        return ResponseEntity.ok(this.roleService.createRole(request));
    }

    @Operation(
            summary = "Remove Roles",
            description = "Remove role on application by role id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Roles.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRole(@PathVariable("id") Long id) {
        this.roleService.removeRoles(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Edit Roles",
            description = "Edit role on application by RolesUpdate object")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Roles.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }, description = "Resource Not Found"),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }, description = "Not Authorized"),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }, description = "Server error, please contact the administrator ") })
    @PutMapping
    public ResponseEntity<RolesResponse> updatedRole (@RequestBody RolesUpdate request){
        return ResponseEntity.ok(this.roleService.updateRoles(request));
    }
}
