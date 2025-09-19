package com.example.project.controller.home;

import com.example.project.dto.home.HomeWhyChooseWeRequestDto;
import com.example.project.model.content.home.HomeWhyChooseWeModel;
import com.example.project.service.home.HomeWhyChooseWeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/homeWhyChooseWe")
@RequiredArgsConstructor
public class HomeWhyChooseWeController {

    private final HomeWhyChooseWeService service;

    @GetMapping
    public List<HomeWhyChooseWeModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public HomeWhyChooseWeModel getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public HomeWhyChooseWeModel create(@RequestBody HomeWhyChooseWeRequestDto model) {
        return service.create(model);
    }

    @PutMapping("/{id}")
    public HomeWhyChooseWeModel update(@PathVariable Long id, @RequestBody HomeWhyChooseWeRequestDto updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
