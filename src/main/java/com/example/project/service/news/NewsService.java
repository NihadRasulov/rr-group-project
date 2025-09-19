package com.example.project.service.news;

import com.example.project.dto.news.NewsRequestDto;
import com.example.project.dto.photo.PhotoResponseDto;
import com.example.project.model.content.news.NewsModel;
import com.example.project.repository.content.news.NewsRepository;
import com.example.project.service.image.ImageService;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class NewsService {

    final NewsRepository newsRepository;

    final ImageService imageService;

    public NewsModel create(NewsRequestDto newsRequestDto, List<MultipartFile> files) throws IOException {

        NewsModel newsModel = new NewsModel();
        newsModel.setTitle(newsRequestDto.title());
        newsModel.setDescription(newsRequestDto.description());
        newsModel.setImages(imageService.uploadPhotos(files, "NewsFolder"));

        return newsRepository.save(newsModel);
    }

    public List<NewsModel> getAll() {
        return newsRepository.findAll();
    }


    public Optional<NewsModel> getById(Long id) {
        return newsRepository.findById(id);
    }

    public void delete(Long id) {
        newsRepository.deleteById(id);
    }

    public NewsModel update(Long id, NewsRequestDto dto, @Nullable List<MultipartFile> files) throws IOException {
        NewsModel newsModel = newsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("News not found: " + id));

        newsModel.setTitle(dto.title());
        newsModel.setDescription(dto.description());

        if (files != null && !files.isEmpty()) {
            List<PhotoResponseDto> imageUrl = imageService.uploadPhotos(files, "UpdatedNewsFolder");
            newsModel.setImages(imageUrl);
        }

        return newsRepository.save(newsModel);
    }
}
