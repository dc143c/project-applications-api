package com.dc143c.applications.dev.service;

import com.dc143c.applications.dev.dto.request.ProjectDTO;
import com.dc143c.applications.dev.dto.response.MessageResponseDTO;
import com.dc143c.applications.dev.entity.Project;
import com.dc143c.applications.dev.mapper.ProjectMapper;
import com.dc143c.applications.dev.repository.ProjectRepository;
import com.dc143c.applications.dev.service.exception.ProjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    private final ProjectMapper projectMapper = ProjectMapper.INSTANCE;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    Project projectToSave = Project.builder()

            .build();

    public MessageResponseDTO createProject(ProjectDTO projectDTO){
        Project projectToSave = projectMapper.toModel(projectDTO);
        Project savedProject = projectRepository.save(projectToSave);
        return createResponseMessage(savedProject, "Project created on ID: ");
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

    public MessageResponseDTO updateById(Long id, ProjectDTO projectDTO) throws ProjectNotFoundException {
        Project projectFound =  verifyIfExists(id);
        Project newProject = projectMapper.toModel(projectDTO);
        System.out.println(newProject);
        Project updatedProject = projectRepository.save(newProject);
        System.out.println(updatedProject);
        projectRepository.save(updatedProject);
        return createResponseMessage(projectFound, "Project updated on ID: ");
    }

    private MessageResponseDTO createResponseMessage(Project projectFound, String message) {
        return MessageResponseDTO.builder().message(message + projectFound.getId()).build();
    }

    private Project verifyIfExists(Long id) throws ProjectNotFoundException {
        return projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
    }

}
