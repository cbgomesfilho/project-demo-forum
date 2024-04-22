package br.com.cbgomes.auth.request;

import br.com.cbgomes.models.Roles;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotEmpty(message = "First name is mandatory")
    private String firstname;
    @NotEmpty(message = "Last name is mandatory")
    private String lastname;
    @NotEmpty(message = "Username name is mandatory")
    private String username;
    @NotEmpty(message = "E-mail is mandatory")
    private String email;
    @NotEmpty(message = "Password  is mandatory")
    private String password;

    private List<Long> roles;
}
