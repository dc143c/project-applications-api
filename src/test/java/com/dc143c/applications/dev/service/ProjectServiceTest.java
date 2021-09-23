package com.dc143c.applications.dev.service;

import com.dc143c.applications.dev.dto.request.ProjectDTO;
import com.dc143c.applications.dev.dto.response.MessageResponseDTO;
import com.dc143c.applications.dev.entity.Project;
import com.dc143c.applications.dev.mapper.ProjectMapper;
import com.dc143c.applications.dev.repository.ProjectRepository;
import com.dc143c.applications.dev.utils.ProjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.dc143c.applications.dev.utils.ProjectUtils.createFakeDTO;
import static com.dc143c.applications.dev.utils.ProjectUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@ExtendWith(MockitoExtension.class)

public class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private ProjectMapper projectMapper;

    @InjectMocks
    private ProjectService projectService;

    @Test
    void testGivenProjectDTOThenReturnSucessSavedMessage(){
        ProjectDTO projectDTO = createFakeDTO();
        Project project = createFakeEntity();
        when(projectMapper.toModel(projectDTO)).thenReturn(project);
        when(projectRepository.save(any(Project.class))).thenReturn(project);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(project.getId());

        MessageResponseDTO successMessage = projectService.createProject(projectDTO);

        assertEquals(expectedSuccessMessage, successMessage);

    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedProjectId) {
        return MessageResponseDTO.builder()
                .message("Project created on ID: " + savedProjectId)
                .build();
    }

}
