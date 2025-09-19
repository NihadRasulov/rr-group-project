package com.example.project.controller.about;

import com.example.project.dto.about.AboutAdministrationRequestDto;
import com.example.project.model.content.about.AboutAdministrationModel;
import com.example.project.service.about.AboutAdministrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aboutAdministration")
@RequiredArgsConstructor
public class AboutAdministrationController {
    private final AboutAdministrationService service;

    @GetMapping("/getAll")
    public List<AboutAdministrationModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<AboutAdministrationModel> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public AboutAdministrationModel create(@RequestBody AboutAdministrationRequestDto model, List<MultipartFile> files) {
        return service.create(model,files);
    }

    @PutMapping("/update")
    public AboutAdministrationModel update(@RequestPart Long id, @RequestPart AboutAdministrationRequestDto model,@RequestPart List<MultipartFile> files) {
        return service.update(id, model,files);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

