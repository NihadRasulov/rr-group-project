package com.example.project.repository.content.project;

import com.example.project.model.content.project.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository extends JpaRepository<ProjectModel,Long> {
}
