package com.example.project.repository.content.news;

import com.example.project.model.content.news.NewsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsModel,Long> {
}
