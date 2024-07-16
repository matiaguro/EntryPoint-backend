package com.techar.EntryPointBackend.core.repository;

import com.techar.EntryPointBackend.core.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserId (String usename);
}
