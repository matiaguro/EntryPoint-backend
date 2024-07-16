package com.techar.EntryPointBackend.core.mapper;

import com.techar.EntryPointBackend.core.models.UserTitles;
import com.techar.EntryPointBackend.core.models.response.UserTitlesResponse;
import org.mapstruct.Mapper;

@Mapper
public interface UserTitlesMapper {

    UserTitlesResponse userTitlesToUserTitlesResponse (UserTitles userTitles);
}
