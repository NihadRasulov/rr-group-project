package com.example.project.service.about;

import com.example.project.dto.about.AboutAdministrationRequestDto;
import com.example.project.model.content.about.AboutAdministrationModel;
import com.example.project.repository.content.about.AboutAdministrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AboutAdministrationService {

    private final AboutAdministrationRepository repository;


    public List<AboutAdministrationModel> getAll() {
        return repository.findAll();
    }

    public Optional<AboutAdministrationModel> getById(Long id) {
        return repository.findById(id);
    }

    public AboutAdministrationModel create(AboutAdministrationRequestDto model, List<MultipartFile> files) {
        AboutAdministrationModel aboutAdministrationModel = new AboutAdministrationModel();
        aboutAdministrationModel.setName(model.getName());
        aboutAdministrationModel.setDescription(model.getDescription());
        aboutAdministrationModel.setImages(files);
        aboutAdministrationModel.setMoreInfo(model.getMoreInfo());
        return repository.save(aboutAdministrationModel);
    }

    public AboutAdministrationModel update(Long id, AboutAdministrationRequestDto model, List<MultipartFile> files) {
        return repository.findById(id).map(existing -> {
            existing.setName(model.getName());
            existing.setDescription(model.getDescription());
            existing.setMoreInfo(model.getMoreInfo());
            existing.setImages(files);
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Administration not found with id " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
