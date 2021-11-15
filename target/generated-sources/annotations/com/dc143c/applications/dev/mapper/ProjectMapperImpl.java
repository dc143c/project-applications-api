package com.dc143c.applications.dev.mapper;

import com.dc143c.applications.dev.dto.request.ProjectDTO;
import com.dc143c.applications.dev.entity.Project;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-14T22:36:04-0300",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 11.0.12 (Oracle Corporation)"
)
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public Project toModel(ProjectDTO projectDTO) {
        if ( projectDTO == null ) {
            return null;
        }

        Project project = new Project();

        return project;
    }

    @Override
    public ProjectDTO toDTO(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDTO projectDTO = new ProjectDTO();

        return projectDTO;
    }
}
