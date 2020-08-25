package com.subscriptio.main.services;

import com.subscriptio.main.models.Project;

import java.util.List;
import java.util.UUID;

public interface ProjectService {
    Project createProject(Project project);
    Project retriveProject(UUID id);
    void deleteProject();
    List<Project> retriveAllProject();
}
