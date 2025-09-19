package com.example.project.controller.about;

import com.example.project.dto.about.AboutValuesRequestDto;
import com.example.project.model.content.about.AboutValuesModel;
import com.example.project.service.about.AboutValuesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aboutValues")
@RequiredArgsConstructor
public class AboutValuesController {
    private final AboutValuesService service;


    @GetMapping("/getAll")
    public List<AboutValuesModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<AboutValuesModel> getById(@PathVariable Long id) {
        return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public AboutValuesModel create(@RequestBody AboutValuesRequestDto values) {
        return service.create(values);
    }

    @PutMapping("update")
    public AboutValuesModel update(@RequestPart Long id, @RequestPart AboutValuesRequestDto values) {
        return service.update(id, values);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
