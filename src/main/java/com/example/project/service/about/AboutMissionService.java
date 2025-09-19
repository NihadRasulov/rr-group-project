package com.example.project.service.about;

import com.example.project.dto.about.AboutMissionRequestDto;
import com.example.project.model.content.about.AboutMissionModel;
import com.example.project.repository.content.about.AboutMissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AboutMissionService {
    final AboutMissionRepository repository;


    public List<AboutMissionModel> getAll() {
        return repository.findAll();
    }

    public Optional<AboutMissionModel> getById(Long id) {
        return repository.findById(id);
    }

    public AboutMissionModel create(AboutMissionRequestDto mission, List<MultipartFile> file) {
        AboutMissionModel aboutMissionModel = new AboutMissionModel();
        aboutMissionModel.setTitle(mission.getTitle());
        aboutMissionModel.setDescription(mission.getDescription());
        aboutMissionModel.setIcons(file);
        return repository.save(aboutMissionModel);
    }

public AboutMissionModel update(Long id, AboutMissionRequestDto mission, List<MultipartFile> files) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setTitle(mission.getTitle());
                    existing.setDescription(mission.getDescription());
                    existing.setIcons(files);
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Mission not found with id " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
