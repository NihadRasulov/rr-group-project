package com.example.project.controller.about;

import com.example.project.dto.about.AboutCorporateRequestDto;
import com.example.project.model.content.about.AboutCorporateModel;
import com.example.project.service.about.AboutCorporateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aboutCorporate")
@RequiredArgsConstructor
public class AboutCorporateController {

    private final AboutCorporateService service;


    @GetMapping("/getAll")
    public List<AboutCorporateModel> getAll() {
        return service.getAll();
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<AboutCorporateModel> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public AboutCorporateModel create(@RequestBody AboutCorporateRequestDto corporate) {
        return service.create(corporate);
    }

    @PutMapping("update")
    public AboutCorporateModel update(@RequestPart Long id, @RequestPart AboutCorporateRequestDto corporate) {
        return service.update(id, corporate);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
