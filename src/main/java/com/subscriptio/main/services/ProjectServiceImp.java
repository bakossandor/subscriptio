package com.subscriptio.main.services;

import com.subscriptio.main.models.Project;
import com.subscriptio.main.repositories.ProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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
        Project project = projectRepository.findByIdAndFetchCampaignsEagerly(id);
        if(project != null) {
            return project;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to project find resource");
        }
    }

    @Override
    public void deleteProject(UUID id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<Project> retriveAllProject() {
        return  (List<Project>) projectRepository.findAll();
    }
}
