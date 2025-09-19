package com.example.project.service.about;

import com.example.project.dto.about.AboutAdministrationStructureRequestDto;
import com.example.project.model.content.about.AboutAdministrationStructureModel;
import com.example.project.repository.content.about.AboutAdministrationStructureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AboutAdministrationStructureService {
    private final AboutAdministrationStructureRepository repository;


    public List<AboutAdministrationStructureModel> getAll() {
        return repository.findAll();
    }

    public Optional<AboutAdministrationStructureModel> getById(Long id) {
        return repository.findById(id);
    }

    public AboutAdministrationStructureModel create(AboutAdministrationStructureRequestDto model) {
        AboutAdministrationStructureModel aboutAdministrationStructureModel = new AboutAdministrationStructureModel();
        aboutAdministrationStructureModel.setTitle(model.getTitle());
        aboutAdministrationStructureModel.setDescription(model.getDescription());
        return repository.save(aboutAdministrationStructureModel);
    }

    public AboutAdministrationStructureModel update(Long id, AboutAdministrationStructureRequestDto model) {
        return repository.findById(id).map(existing -> {
            existing.setTitle(model.getTitle());
            existing.setDescription(model.getDescription());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Structure not found with id " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

