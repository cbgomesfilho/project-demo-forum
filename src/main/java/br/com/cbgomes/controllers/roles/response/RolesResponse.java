package br.com.cbgomes.controllers.roles.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RolesResponse {
    private Long id;
    private String name;
}
