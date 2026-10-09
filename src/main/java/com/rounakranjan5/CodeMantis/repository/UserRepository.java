package com.rounakranjan5.CodeMantis.repository;

import com.rounakranjan5.CodeMantis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByGithubUserId(Integer githubUserId);

}
