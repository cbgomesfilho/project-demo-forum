package br.com.cbgomes.service;

import br.com.cbgomes.controllers.roles.request.RolesRequest;
import br.com.cbgomes.controllers.roles.request.RolesUpdate;
import br.com.cbgomes.controllers.roles.response.RolesResponse;

import java.util.List;

public interface RoleService {

    RolesResponse createRole(RolesRequest request);
    List<RolesResponse> listRoles();
    RolesResponse getRoles(Long id);

    RolesResponse updateRoles(RolesUpdate requestRolesUpdate);

    void removeRoles(Long id);
}
