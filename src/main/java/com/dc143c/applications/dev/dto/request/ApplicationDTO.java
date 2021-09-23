package com.dc143c.applications.dev.dto.request;

import com.dc143c.applications.dev.enums.ApplicationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO {

    @NotEmpty
    @Size(min = 3, max = 20)
    private String name;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String applicationURL;

    @Enumerated(EnumType.STRING)
    private ApplicationType type;
}
