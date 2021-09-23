package com.dc143c.applications.dev.utils;

import com.dc143c.applications.dev.dto.request.ProjectDTO;
import com.dc143c.applications.dev.entity.Project;

import java.util.Collections;

public class ProjectUtils {
    private static final String PROJECT_NAME = "14-bis";
    private static final Long PROJECT_ID = 1L;
    private static final String PROJECT_OWNER = "Alberto Santos Dummond";
    private static final String PROJECT_URL = "https://github.com/asdummond/14-bis";

    public static ProjectDTO createFakeDTO() {
        return ProjectDTO.builder()
                .id(PROJECT_ID)
                .name(PROJECT_NAME)
                .owner(PROJECT_OWNER)
                .gitURL(PROJECT_URL)
                .applicationList(Collections.singletonList(ApplicationUtils.createFake()))
                .build();
    }

    public static Project createFakeEntity() {
        return Project.builder()
                .id(PROJECT_ID)
                .name(PROJECT_NAME)
                .owner(PROJECT_OWNER)
                .gitURL(PROJECT_URL)
                .applicationList(Collections.singletonList(ApplicationUtils.createFakeEntity()))
                .build();
    }
}
