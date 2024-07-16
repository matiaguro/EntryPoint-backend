package com.techar.EntryPointBackend.core.mapper;

import com.techar.EntryPointBackend.core.models.UserState;
import com.techar.EntryPointBackend.core.models.response.UserStateResponse;
import org.mapstruct.Mapper;

@Mapper
public interface UserStateMapper {

    UserStateResponse userStateToUserStateResponse (UserState userState);

}
