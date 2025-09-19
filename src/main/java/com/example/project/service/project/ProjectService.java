package com.example.project.service.project;

import com.example.project.dto.photo.PhotoResponseDto;
import com.example.project.dto.projects.ProjectRequestDto;
import com.example.project.model.content.project.ProjectModel;
import com.example.project.repository.content.project.ProjectRepository;
import com.example.project.service.image.ImageService;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectService {

    final ProjectRepository projectRepository;
    final ImageService imageService;

    public ProjectModel create(ProjectRequestDto projectRequestDto, List<MultipartFile> files) throws IOException {
        ProjectModel projectModel = new ProjectModel();
        projectModel.setProjectName(projectRequestDto.getProjectName());
        projectModel.setCustomer(projectRequestDto.getCustomer());
        projectModel.setDescription(projectRequestDto.getDescription());
        projectModel.setLocalDate(projectRequestDto.getDate());
        projectModel.setImage(imageService.uploadPhotos(files, "NewProjectFolder"));

        return projectRepository.save(projectModel);
    }


    public List<ProjectModel> getAll() {
        return projectRepository.findAll();
    }


    public Optional<ProjectModel> getById(Long id) {
        return projectRepository.findById(id);
    }

    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    public ProjectModel update(Long id, ProjectRequestDto dto, @Nullable List<MultipartFile> file) throws IOException {
        ProjectModel project = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found: " + id));

        project.setProjectName(dto.getProjectName());
        project.setCustomer(dto.getCustomer());
        project.setDescription(dto.getDescription());
        project.setLocalDate(dto.getDate());

        if (file != null && !file.isEmpty()) {
            List<PhotoResponseDto> uploadedImages = imageService.uploadPhotos(file, "UpdatedNewProjectFolder");
            project.setImage(uploadedImages);
        }

        return projectRepository.save(project);
    }
}
