package com.dc143c.applications.dev.mapper;

import com.dc143c.applications.dev.dto.request.ProjectDTO;
import com.dc143c.applications.dev.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    Project toModel(ProjectDTO projectDTO);

    ProjectDTO toDTO(Project project);
}
