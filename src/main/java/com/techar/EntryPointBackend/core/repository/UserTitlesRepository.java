package com.techar.EntryPointBackend.core.repository;

import com.techar.EntryPointBackend.core.models.UserState;
import com.techar.EntryPointBackend.core.models.UserTitles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTitlesRepository extends JpaRepository<UserTitles,Long> {
}
