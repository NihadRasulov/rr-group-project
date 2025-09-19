package com.example.project.service.about;

import com.example.project.dto.about.AboutValuesRequestDto;
import com.example.project.model.content.about.AboutValuesModel;
import com.example.project.repository.content.about.AboutValuesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AboutValuesService {

    private final AboutValuesRepository repository;

    public List<AboutValuesModel> getAll() {
        return repository.findAll();
    }

    public Optional<AboutValuesModel> getById(Long id) {
        return repository.findById(id);
    }

    public AboutValuesModel create(AboutValuesRequestDto values) {
        AboutValuesModel aboutValuesModel = new AboutValuesModel();
        aboutValuesModel.setTitle(values.getTitle());
        aboutValuesModel.setDescription(values.getDescription());
        aboutValuesModel.setIcons(values.getIcons());
        return repository.save(aboutValuesModel);
    }

    public AboutValuesModel update(Long id, AboutValuesRequestDto values) {
        return repository.findById(id).map(existing -> {
            existing.setTitle(values.getTitle());
            existing.setDescription(values.getDescription());
            existing.setIcons(values.getIcons());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Values not found with id " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
