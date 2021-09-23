package com.dc143c.applications.dev.repository;

import com.dc143c.applications.dev.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
