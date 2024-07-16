package com.techar.EntryPointBackend.core.repository;

import com.techar.EntryPointBackend.core.models.UserState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStateRepository extends JpaRepository<UserState,Long> {
}
