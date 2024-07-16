package com.techar.EntryPointBackend.core.mapper;

import com.techar.EntryPointBackend.core.models.User;
import com.techar.EntryPointBackend.core.models.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(uses = AttendanceRecordsMapper.class)
public interface UserMapper {

    @Mappings({
            @Mapping(target = "completeName", expression = "java(user.getName() + \" \" + user.getLastName())")
    })
    UserResponse userToUserResponse (User user);

    List<UserResponse> userToUserResponse (List<User> user);

}
