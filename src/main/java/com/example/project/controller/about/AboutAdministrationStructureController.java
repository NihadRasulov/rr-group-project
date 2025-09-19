package com.example.project.controller.about;

import com.example.project.dto.about.AboutAdministrationStructureRequestDto;
import com.example.project.model.content.about.AboutAdministrationStructureModel;
import com.example.project.service.about.AboutAdministrationStructureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aboutStructure")
@RequiredArgsConstructor
public class AboutAdministrationStructureController {
    private final AboutAdministrationStructureService service;


    @GetMapping("/getAll")
    public List<AboutAdministrationStructureModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<AboutAdministrationStructureModel> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public AboutAdministrationStructureModel create(@RequestBody AboutAdministrationStructureRequestDto model) {
        return service.create(model);
    }

    @PutMapping("/update")
    public AboutAdministrationStructureModel update(@RequestPart Long id, @RequestPart AboutAdministrationStructureRequestDto model) {
        return service.update(id, model);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
