package com.techar.EntryPointBackend.core.mapper;

import com.techar.EntryPointBackend.core.models.Rol;
import com.techar.EntryPointBackend.core.models.response.RoleResponse;
import org.mapstruct.Mapper;

@Mapper
public interface RolMapper {

    RoleResponse rolToRoleResponse (Rol rol);

}
