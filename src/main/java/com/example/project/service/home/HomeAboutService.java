package com.example.project.service.home;

import com.example.project.dto.home.HomeAboutRequestDto;
import com.example.project.model.content.home.HomeAboutModel;
import com.example.project.repository.content.home.HomeAboutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeAboutService {

    private final HomeAboutRepository homeAboutRepository;

    public List<HomeAboutModel> getAll() {
        return homeAboutRepository.findAll();
    }

    public HomeAboutModel getById(Long id) {
        return homeAboutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("About item not found"));
    }

    public HomeAboutModel create(HomeAboutRequestDto model) {
        HomeAboutModel homeAboutModel = new HomeAboutModel();
        homeAboutModel.setNumber(model.getNumber());
        homeAboutModel.setText(model.getText());
        return homeAboutRepository.save(homeAboutModel);
    }

    public HomeAboutModel update(Long id, HomeAboutRequestDto updated) {
        HomeAboutModel existing = getById(id);
        existing.setNumber(updated.getNumber());
        existing.setText(updated.getText());
        return homeAboutRepository.save(existing);
    }

    public void delete(Long id) {
        homeAboutRepository.deleteById(id);
    }
}
