package com.rounakranjan5.CodeMantis.repository;

import com.rounakranjan5.CodeMantis.entity.GitRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GitRepositoryRepository extends JpaRepository<GitRepository, UUID> {

}
