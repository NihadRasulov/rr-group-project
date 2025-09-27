package com.example.project.controller.project;

import com.example.project.dto.projects.ProjectRequestDto;
import com.example.project.model.content.project.ProjectModel;
import com.example.project.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/create")
    public ProjectModel createModel(
            @RequestPart ProjectRequestDto projectRequestDto,
            @RequestPart List<MultipartFile> files
    ) throws IOException {
        return projectService.create(projectRequestDto, files);
    }

    @GetMapping("/getModel")
    public List<ProjectModel> getModel() {
        return projectService.getAll();
    }

    @GetMapping("/getById/{id}")
    public ProjectModel getById(@PathVariable Long id) {
        return projectService.getById(id).orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteModel(@PathVariable Long id) {
        projectService.delete(id);
    }

    @PutMapping("/update")
    public ProjectModel updateModel(
            @RequestPart Long id,
            @RequestPart ProjectRequestDto projectRequestDto,
            @RequestPart List<MultipartFile> files
    ) throws IOException {
        return projectService.update(id, projectRequestDto, files);
    }
}
