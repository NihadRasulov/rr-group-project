package com.example.project.controller.about;

import com.example.project.dto.about.AboutMissionRequestDto;
import com.example.project.model.content.about.AboutMissionModel;
import com.example.project.service.about.AboutMissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aboutMission")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AboutMissionController {

     final AboutMissionService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<AboutMissionModel>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<AboutMissionModel> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<AboutMissionModel> create(@RequestPart AboutMissionRequestDto mission, @RequestPart List<MultipartFile> files) {
        return ResponseEntity.ok(service.create(mission, files));
    }

    @PutMapping("/update")
    public ResponseEntity<AboutMissionModel> update(@RequestPart Long id, @RequestPart AboutMissionRequestDto mission, @RequestPart List<MultipartFile> files) {
        return ResponseEntity.ok(service.update(id, mission,files));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
