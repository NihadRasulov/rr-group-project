package com.example.project.controller.home;

import com.example.project.dto.home.HomeAboutRequestDto;
import com.example.project.model.content.home.HomeAboutModel;
import com.example.project.service.home.HomeAboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/homeAbout")
@RequiredArgsConstructor
public class HomeAboutController {

    private final HomeAboutService homeAboutService;

    @GetMapping
    public List<HomeAboutModel> getAll() {
        return homeAboutService.getAll();
    }

    @GetMapping("/{id}")
    public HomeAboutModel getById(@PathVariable Long id) {
        return homeAboutService.getById(id);
    }

    @PostMapping
    public HomeAboutModel create(@RequestBody HomeAboutRequestDto model) {
        return homeAboutService.create(model);
    }

    @PutMapping("/{id}")
    public HomeAboutModel update(@PathVariable Long id, @RequestBody HomeAboutRequestDto updated) {
        return homeAboutService.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        homeAboutService.delete(id);
    }
}
