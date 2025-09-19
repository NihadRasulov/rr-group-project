package com.example.project.service.home;

import com.example.project.dto.home.HomeProjectRequestDto;
import com.example.project.model.content.home.HomeProjectModel;
import com.example.project.repository.content.home.HomeProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeProjectService {

    private final HomeProjectRepository homeProjectRepository;

    public List<HomeProjectModel> getAll() {
        return homeProjectRepository.findAll();
    }

    public HomeProjectModel getById(Long id) {
        return homeProjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public HomeProjectModel create(HomeProjectRequestDto model) {
        HomeProjectModel homeProjectModel = new HomeProjectModel();
        homeProjectModel.setImages(model.getImages());
        return homeProjectRepository.save(homeProjectModel);
    }

    public HomeProjectModel update(Long id, HomeProjectRequestDto updated) {
        HomeProjectModel existing = getById(id);
        existing.setImages(updated.getImages());
        return homeProjectRepository.save(existing);
    }

    public void delete(Long id) {
        homeProjectRepository.deleteById(id);
    }
}
