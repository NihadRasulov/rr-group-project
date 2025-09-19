package com.example.project.controller.about;

import com.example.project.model.content.about.AboutCertificateModel;
import com.example.project.service.about.AboutCertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aboutCertificates")
@RequiredArgsConstructor
public class AboutCertificateController {
    private final AboutCertificateService service;

    @GetMapping("/getAll")
    public List<AboutCertificateModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<AboutCertificateModel> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public AboutCertificateModel create(@RequestPart List<MultipartFile> files) {
        return service.create(files);
    }

    @PutMapping("/update")
    public AboutCertificateModel update(@RequestPart Long id, @RequestPart List<MultipartFile> files) {
        return service.update(id, files);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
