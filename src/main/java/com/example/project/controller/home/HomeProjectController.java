package com.example.project.controller.home;

import com.example.project.dto.home.HomeProjectRequestDto;
import com.example.project.model.content.home.HomeProjectModel;
import com.example.project.service.home.HomeProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/homeProject")
@RequiredArgsConstructor
public class HomeProjectController {

    private final HomeProjectService homeProjectService;

    @GetMapping
    public List<HomeProjectModel> getAll() {
        return homeProjectService.getAll();
    }

    @GetMapping("/{id}")
    public HomeProjectModel getById(@PathVariable Long id) {
        return homeProjectService.getById(id);
    }

    @PostMapping
    public HomeProjectModel create(@RequestBody HomeProjectRequestDto model) {
        return homeProjectService.create(model);
    }

    @PutMapping("/{id}")
    public HomeProjectModel update(@PathVariable Long id, @RequestBody HomeProjectRequestDto updated) {
        return homeProjectService.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        homeProjectService.delete(id);
    }
}
