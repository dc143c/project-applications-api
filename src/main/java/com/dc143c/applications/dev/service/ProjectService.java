package com.dc143c.applications.dev.service;

import com.dc143c.applications.dev.dto.MessageResponseDTO;
import com.dc143c.applications.dev.entity.Project;
import com.dc143c.applications.dev.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public MessageResponseDTO createProject(Project project){
        Project savedProject = projectRepository.save(project);
        return MessageResponseDTO
                .builder()
                .message("Project generated successfully on ID: " + savedProject.getId())
                .build();
    }
}
