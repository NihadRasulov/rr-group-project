package com.example.project.model.content.about;

import com.example.project.model.content.news.NewsModel;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AboutModel {

    List<AboutMissionModel> aboutMissionModels;
    List<AboutValuesModel> aboutValuesModels;
    List<AboutCorporateModel> aboutCorporateModels;
    List<AboutAdministrationModel> aboutAdministrationModels;
    List<AboutAdministrationStructureModel> aboutAdministrationStructureModels;
    List<AboutCertificateModel> aboutCertificateModels;
    List<NewsModel> newsModels;

}
