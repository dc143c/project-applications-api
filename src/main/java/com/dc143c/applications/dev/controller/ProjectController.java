package com.dc143c.applications.dev.controller;

import com.dc143c.applications.dev.dto.request.ProjectDTO;
import com.dc143c.applications.dev.dto.response.MessageResponseDTO;
import com.dc143c.applications.dev.entity.Project;
import com.dc143c.applications.dev.service.ProjectService;
import com.dc143c.applications.dev.service.exception.ProjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    private ProjectService projectService;

    @GetMapping("/status")
    public String getStatus(){
        return "API STATUS: Online";
    }

    @GetMapping
    public List<ProjectDTO> getAll(){
        return projectService.listAll();
    }

    @Autowired
    public void ProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createProject(@RequestBody @Valid ProjectDTO projectDTO){
        return projectService.createProject(projectDTO);
    }

    @GetMapping("/{id}")
    public ProjectDTO findById(@PathVariable Long id) throws ProjectNotFoundException {
        return projectService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ProjectNotFoundException {
        projectService.deleteById(id);
        System.out.println("Project deleted: " + id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid ProjectDTO projectDTO) throws ProjectNotFoundException {
        return projectService.updateById(id, projectDTO);
    }
}
