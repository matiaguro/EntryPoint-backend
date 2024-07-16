package com.techar.EntryPointBackend.core.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String userId;

    private String name;

    private String lastName;

    private String completeName;

    private RoleResponse role;

    private UserStateResponse userState;

    private UserTitlesResponse userTitles;

    private List<AttendanceRecordsResponse> records;

}
