package com.subscriptio.main.services;

import com.subscriptio.main.models.Project;
import com.subscriptio.main.repositories.ProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectServiceImp implements ProjectService {

    private ProjectRepository projectRepository;

    public ProjectServiceImp(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project retriveProject(UUID id) {
        Optional<Project> project = projectRepository.findById(id);
        if(project.isPresent()) {
            return project.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        }
    }

    @Override
    public void deleteProject() {

    }

    @Override
    public List<Project> retriveAllProject() {
        return null;
    }
}
