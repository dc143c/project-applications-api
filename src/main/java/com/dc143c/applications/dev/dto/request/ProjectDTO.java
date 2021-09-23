package com.dc143c.applications.dev.dto.request;

import com.dc143c.applications.dev.entity.Application;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.Valid;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private Long id;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String name;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String owner;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String gitURL;

    @Valid
    private List<ApplicationDTO> applicationList;

}