package com.example.project.controller.about;

import com.example.project.model.content.about.AboutModel;
import com.example.project.service.about.*;
import com.example.project.service.news.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/about")
@RequiredArgsConstructor
public class AboutController {

    private final AboutMissionService missionService;
    private final AboutValuesService valuesService;
    private final AboutCorporateService corporateService;
    private final AboutAdministrationService administrationService;
    private final AboutAdministrationStructureService administrationStructureService;
    private final AboutCertificateService certificateService;
    private final NewsService newsService;

    @GetMapping("/get")
    public AboutModel getAbout() {
        AboutModel about = new AboutModel();
        about.setAboutMissionModels(missionService.getAll());
        about.setAboutValuesModels(valuesService.getAll());
        about.setAboutCorporateModels(corporateService.getAll());
        about.setAboutAdministrationModels(administrationService.getAll());
        about.setAboutAdministrationStructureModels(administrationStructureService.getAll());
        about.setAboutCertificateModels(certificateService.getAll());
        about.setNewsModels(newsService.getAll());
        return about;
    }
}
