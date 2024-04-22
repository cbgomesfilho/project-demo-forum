package br.com.cbgomes.controllers.roles.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RolesUpdate {
    private Long id;
    private String name;
}
