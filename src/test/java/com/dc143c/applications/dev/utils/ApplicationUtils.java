package com.dc143c.applications.dev.utils;

import com.dc143c.applications.dev.dto.request.ApplicationDTO;
import com.dc143c.applications.dev.entity.Application;
import com.dc143c.applications.dev.enums.ApplicationStatus;
import com.dc143c.applications.dev.enums.ApplicationType;

public class ApplicationUtils {
    private static final String APPLICATION_NAME = "Aerodinamycs Especialist";
    private static final Long APPLICATION_ID = 1L;
    private static final String APPLICATION_URL = "https://linkedin.com/applications/14-bis";
    private static final ApplicationType APPLICATION_TYPE = ApplicationType.FULLTIME;
    private static final ApplicationStatus APPLICATION_STATUS = ApplicationStatus.OPEN;

    public static ApplicationDTO createFake(){
        return ApplicationDTO
                .builder()
                .id(APPLICATION_ID)
                .name(APPLICATION_NAME)
                .applicationURL(APPLICATION_URL)
                .type(APPLICATION_TYPE)
                .status(APPLICATION_STATUS)
                .build();
    }

    public static Application createFakeEntity(){
        return Application
                .builder()
                .id(APPLICATION_ID)
                .name(APPLICATION_NAME)
                .applicationURL(APPLICATION_URL)
                .type(APPLICATION_TYPE)
                .status(APPLICATION_STATUS)
                .build();
    }
}
