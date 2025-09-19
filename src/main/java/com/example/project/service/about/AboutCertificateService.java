package com.example.project.service.about;

import com.example.project.model.content.about.AboutCertificateModel;
import com.example.project.repository.content.about.AboutCertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AboutCertificateService {
    private final AboutCertificateRepository repository;


    public List<AboutCertificateModel> getAll() {
        return repository.findAll();
    }

    public Optional<AboutCertificateModel> getById(Long id) {
        return repository.findById(id);
    }

    public AboutCertificateModel create(List<MultipartFile> files) {
        AboutCertificateModel aboutCertificateModel = new AboutCertificateModel();
        aboutCertificateModel.setCertificates(files);
        return repository.save(aboutCertificateModel);
    }

    public AboutCertificateModel update(Long id, List<MultipartFile> files) {
        return repository.findById(id).map(existing -> {
            existing.setCertificates(files);
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Certificate not found with id " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
