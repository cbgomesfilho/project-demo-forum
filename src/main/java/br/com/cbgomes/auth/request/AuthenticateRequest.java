package br.com.cbgomes.auth.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticateRequest {

    @NotEmpty(message = "Email is mandatory")
    private String email;
    @NotEmpty(message = "Password is mandatory")
    private String password;
}
