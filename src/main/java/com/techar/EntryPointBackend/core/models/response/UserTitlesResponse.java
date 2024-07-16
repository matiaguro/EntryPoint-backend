package com.techar.EntryPointBackend.core.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserTitlesResponse {

    private Long idUserState;

    private String keyTitles;

    private String description;
}
