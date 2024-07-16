package com.techar.EntryPointBackend.core.repository;

import com.techar.EntryPointBackend.core.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Long> {
}
