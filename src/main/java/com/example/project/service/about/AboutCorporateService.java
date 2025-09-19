package com.example.project.service.about;

import com.example.project.dto.about.AboutCorporateRequestDto;
import com.example.project.model.content.about.AboutCorporateModel;
import com.example.project.repository.content.about.AboutCorporateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AboutCorporateService {

    private final AboutCorporateRepository repository;


    public List<AboutCorporateModel> getAll() {
        return repository.findAll();
    }

    public Optional<AboutCorporateModel> getById(Long id) {
        return repository.findById(id);
    }

    public AboutCorporateModel create(AboutCorporateRequestDto corporate) {
        AboutCorporateModel aboutCorporateModel = new AboutCorporateModel();
        aboutCorporateModel.setTitle(corporate.getTitle());
        aboutCorporateModel.setDescription(corporate.getDescription());
        return repository.save(aboutCorporateModel);
    }

    public AboutCorporateModel update(Long id, AboutCorporateRequestDto corporate) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setTitle(corporate.getTitle());
                    existing.setDescription(corporate.getDescription());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Corporate not found with id " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
