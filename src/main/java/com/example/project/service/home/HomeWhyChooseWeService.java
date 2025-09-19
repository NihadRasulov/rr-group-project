package com.example.project.service.home;

import com.example.project.dto.home.HomeWhyChooseWeRequestDto;
import com.example.project.model.content.home.HomeWhyChooseWeModel;
import com.example.project.repository.content.home.HomeWhyChooseWeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeWhyChooseWeService {

    private final HomeWhyChooseWeRepository repository;

    public List<HomeWhyChooseWeModel> getAll() {
        return repository.findAll();
    }

    public HomeWhyChooseWeModel getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("WhyChooseUs item not found"));
    }

    public HomeWhyChooseWeModel create(HomeWhyChooseWeRequestDto model) {
        HomeWhyChooseWeModel homeWhyChooseWeModel = new HomeWhyChooseWeModel();
        homeWhyChooseWeModel.setTitle(model.getTitle());
        homeWhyChooseWeModel.setDescription(model.getDescription());
        homeWhyChooseWeModel.setIcon(model.getIcon());
        return repository.save(homeWhyChooseWeModel);
    }

    public HomeWhyChooseWeModel update(Long id, HomeWhyChooseWeRequestDto updated) {
        HomeWhyChooseWeModel existing = getById(id);
        existing.setIcon(updated.getIcon());
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
