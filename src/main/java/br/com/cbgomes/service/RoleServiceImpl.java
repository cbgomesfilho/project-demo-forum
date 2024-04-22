package br.com.cbgomes.service;

import br.com.cbgomes.controllers.roles.request.RolesRequest;
import br.com.cbgomes.controllers.roles.request.RolesUpdate;
import br.com.cbgomes.controllers.roles.response.RolesResponse;
import br.com.cbgomes.mapper.utils.ConvertUtils;
import br.com.cbgomes.models.Roles;
import br.com.cbgomes.models.Topic;
import br.com.cbgomes.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ConvertUtils convertUtils;

    @Override
    public RolesResponse createRole(RolesRequest request) {
        log.info("Start process create to entity {}", request);
        var entity = (Roles) convertUtils.convertToEntity(request, Roles.class);
        this.roleRepository.save(entity);
        log.info("End process create to entity {}", request);
        return (RolesResponse) convertUtils
                .convertToResponse(entity, RolesResponse.class);
    }

    @Override
    public List<RolesResponse> listRoles() {
        return  convertUtils
                .convertToListResponse(this.roleRepository.findAll(), RolesResponse.class);
    }

    @Override
    public RolesResponse getRoles(Long id) {

        return (RolesResponse) convertUtils
                .convertToResponse(this.roleRepository.findById(id).orElseThrow(
                        () -> new NotFoundException("Roles not found")
                ), RolesResponse.class);
    }

    @Override
    public RolesResponse updateRoles(RolesUpdate requestRolesUpdate) {
        log.info("Start update process to entity {}", requestRolesUpdate);
        var editable = this.roleRepository.findById(requestRolesUpdate.getId())
                .orElseThrow(() -> new NotFoundException("Role not found"));
        var entity = (Roles) convertUtils.convertToEntity(requestRolesUpdate, editable.getClass());
        this.roleRepository.save(entity);
        log.info("End processo to update entity {}", requestRolesUpdate);
        return (RolesResponse) convertUtils.convertToResponse(entity, RolesResponse.class);


    }

    @Override
    public void removeRoles(Long id) {
        log.info("Start process delete roles with id {}", id);
        this.roleRepository.deleteById(id);
        log.info("End process delete roles with id {}", id);
    }
}
