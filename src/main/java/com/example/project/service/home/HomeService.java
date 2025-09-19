package com.example.project.service.home;

import com.example.project.model.content.home.HomeModel;
import com.example.project.repository.content.home.HomeAboutRepository;
import com.example.project.repository.content.home.HomeProjectRepository;
import com.example.project.repository.content.home.HomeWhyChooseWeRepository;
import com.example.project.repository.content.news.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final HomeAboutRepository homeAboutRepository;
    private final HomeProjectRepository homeProjectRepository;
    private final HomeWhyChooseWeRepository homeWhyChooseWeRepository;
    private final NewsRepository newsRepository;

    public HomeModel getHomePageData() {
        HomeModel homeModel = new HomeModel();

        homeModel.setHomeAboutModels(homeAboutRepository.findAll());
        homeModel.setHomeProjectModels(homeProjectRepository.findAll());
        homeModel.setHomeWhyChooseWeModels(homeWhyChooseWeRepository.findAll());
        homeModel.setNewsModels(newsRepository.findAll());

        return homeModel;
    }
}
