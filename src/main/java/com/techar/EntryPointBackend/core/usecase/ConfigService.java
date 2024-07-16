package com.techar.EntryPointBackend.core.usecase;

import com.techar.EntryPointBackend.core.models.ConfigParameters;
import com.techar.EntryPointBackend.core.models.response.ParamResponse;
import com.techar.EntryPointBackend.core.repository.ConfigParametersRepository;
import com.techar.EntryPointBackend.core.repository.RolRepository;
import com.techar.EntryPointBackend.core.repository.UserTitlesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class ConfigService {

    private final RolRepository rolRepository;

    private final UserTitlesRepository userTitlesRepository;

    private final ConfigParametersRepository configParametersRepository;

    public HashMap<String, Object> getAllConfig() {
        var roleList = rolRepository.findAll();
        var titlesList = userTitlesRepository.findAll();

        var output = new HashMap<String, Object> ();

        output.put("ROL", roleList);
        output.put("TITLES", titlesList);
        loadConfigParam(output);

        return output;
    }

    private void loadConfigParam (HashMap<String, Object> param) {
        var configParameters = configParametersRepository.findAll();

        for (ConfigParameters config : configParameters){
            param.put(
                    config.getToken(),

                    ParamResponse.builder()
                    .value(config.getValue())
                    .updateDate(config.getUpdateDate())
                    .build()
            );
        }

    }

    public Object upDateConfig() {
        return null;
    }
}
