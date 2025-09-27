package com.example.project.controllerView;

import com.example.project.model.content.home.HomeModel;
import com.example.project.service.home.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomePageController {

    private final HomeService homeService;

    @GetMapping
    public String homePage(Model model) {
        HomeModel homeModel = homeService.getHomePageData();

        model.addAttribute("homeModel", homeModel);
        return "home";
    }
}
