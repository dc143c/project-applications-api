package com.dc143c.applications.dev.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum ApplicationStatus {
    OPEN("Open"),
    CLOSED("Closed");

    private final String description;
}