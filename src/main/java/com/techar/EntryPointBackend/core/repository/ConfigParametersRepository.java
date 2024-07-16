package com.techar.EntryPointBackend.core.repository;

import com.techar.EntryPointBackend.core.models.ConfigParameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigParametersRepository extends JpaRepository<ConfigParameters,Long> {
}
