package com.subscriptio.main.controllers;

import com.subscriptio.main.lib.CreateUrl;
import com.subscriptio.main.models.Project;
import com.subscriptio.main.services.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class ProjectsController {

    private ProjectService projectService;

    public ProjectsController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    String getProjects(Model model) {
        model.addAttribute("project", new Project());
        return "projects";
    }

    @GetMapping("/project/{id}")
    String getProjects(Model model, @PathVariable("id") UUID id) {
        Project project = projectService.retriveProject(id);

        return "project";
    }

    @PostMapping("/projects")
    String createProject(@ModelAttribute Project project) {
        project.setProjectUrl(CreateUrl.make());
        Project savedProject = projectService.createProject(project);

        return "redirect:project" + "/" + savedProject.getId();
    }
}
