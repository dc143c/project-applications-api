package com.dc143c.applications.dev.controller;

import com.dc143c.applications.dev.dto.MessageResponseDTO;
import com.dc143c.applications.dev.entity.Project;
import com.dc143c.applications.dev.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    private ProjectService projectService;

    @GetMapping
    public String getStatus(){
        return "API Online";
    }

    @Autowired
    public void ProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createProject(@RequestBody Project project){
        return projectService.createProject(project);
    }
}
