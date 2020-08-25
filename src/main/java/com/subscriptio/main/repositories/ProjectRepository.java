package com.subscriptio.main.repositories;

import com.subscriptio.main.models.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProjectRepository extends CrudRepository<Project, UUID> {
}
