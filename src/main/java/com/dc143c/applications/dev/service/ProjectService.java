package com.dc143c.applications.dev.service;

import com.dc143c.applications.dev.dto.request.ProjectDTO;
import com.dc143c.applications.dev.dto.response.MessageResponseDTO;
import com.dc143c.applications.dev.entity.Project;
import com.dc143c.applications.dev.mapper.ProjectMapper;
import com.dc143c.applications.dev.repository.ProjectRepository;
import com.dc143c.applications.dev.service.exception.ProjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    private final ProjectMapper projectMapper = ProjectMapper.INSTANCE;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    Project projectToSave = Project.builder()

            .build();

    public MessageResponseDTO createProject(ProjectDTO projectDTO){
        Project projectToSave = projectMapper.toModel(projectDTO);
        Project savedProject = projectRepository.save(projectToSave);
        return MessageResponseDTO
                .builder()
                .message("Project generated successfully on ID: " + savedProject.getId())
                .build();
    }

    public List<ProjectDTO> listAll() {
        List<Project> allProjects = projectRepository.findAll();
        return allProjects.stream().map(projectMapper::toDTO).collect(Collectors.toList());
    }

    public ProjectDTO findById(Long id) throws ProjectNotFoundException {
        Project projectFound = verifyIfExists(id);
        return projectMapper.toDTO(projectFound);
    }

    public void deleteById(Long id) throws ProjectNotFoundException {
        Project projectFound = verifyIfExists(id);
        projectRepository.deleteById(id);
    }

    private Project verifyIfExists(Long id) throws ProjectNotFoundException {
        return projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
    }
}
