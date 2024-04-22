package br.com.cbgomes.auth;

import br.com.cbgomes.auth.request.AuthenticateRequest;
import br.com.cbgomes.auth.request.RegisterRequest;
import br.com.cbgomes.auth.response.AuthenticationResponse;
import br.com.cbgomes.controllers.roles.response.RolesResponse;
import br.com.cbgomes.mapper.utils.ConvertUtils;
import br.com.cbgomes.models.Roles;
import br.com.cbgomes.models.Users;
import br.com.cbgomes.repository.UserRepresentationRepository;
import br.com.cbgomes.auth.service.JWTService;
import br.com.cbgomes.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService  {

    private final RoleService roleService;

    private final ConvertUtils convertUtils;
    private final UserRepresentationRepository userRepresentationRepository;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {

         var list = request.getRoles().stream()
                 .map(this.roleService::getRoles).toList();

        var roles_entity = (List<Roles>) convertUtils.convertToListResponse(list, Roles.class);

         var userRepresentation = Users.builder()
                 .firstname(request.getFirstname())
                 .lastname(request.getLastname())
                 .username(request.getEmail())
                 .email(request.getEmail())
                 .password(passwordEncoder.encode(request.getPassword()))
                 .roles(roles_entity)
                 .build();
          this.userRepresentationRepository.save(userRepresentation);
          var jwtToken = jwtService.generateToken(userRepresentation);
          return AuthenticationResponse.builder()
                  .token(jwtToken)
                  .build();
    }

    public AuthenticationResponse authenticated(AuthenticateRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var userRepresentation = this.userRepresentationRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(userRepresentation);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .email(userRepresentation.getEmail())
                .build();

    }
}
