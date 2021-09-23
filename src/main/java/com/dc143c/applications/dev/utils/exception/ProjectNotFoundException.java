package com.dc143c.applications.dev.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjectNotFoundException extends Exception {
    public ProjectNotFoundException(Long id) {
        super("Project not found on ID: " + id);
    }
}
