package com.example.project.model.content.home;

import com.example.project.model.content.news.NewsModel;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomeModel {

    List<HomeAboutModel> homeAboutModels;
    List<HomeProjectModel> homeProjectModels;
    List<HomeWhyChooseWeModel> homeWhyChooseWeModels;
    List<NewsModel> newsModels;


}
