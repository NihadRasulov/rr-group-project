package com.example.project.controller.news;

import com.example.project.dto.news.NewsRequestDto;
import com.example.project.model.content.news.NewsModel;
import com.example.project.service.news.NewsService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("api/v1/news")
public class NewsController {

    final NewsService newsService;

    @PostMapping("/create")
    public ResponseEntity<NewsModel> createAbout(@RequestPart @Valid NewsRequestDto newsRequestDto, @RequestPart List<MultipartFile> files) throws IOException {
        NewsModel newsModel = newsService.create(newsRequestDto, files);
        return ResponseEntity.ok(newsModel);
    }

    @GetMapping("/getnews")
    public List<NewsModel> getModel() {
        return newsService.getAll();
    }

    @GetMapping("/getById/{id}")
    public NewsModel getById(@PathVariable Long id) {
        return newsService.getById(id).get();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAbout(@PathVariable Long id) {
        newsService.delete(id);
    }

    @PutMapping("/update")
    public NewsModel updateModel(@RequestPart Long id, @RequestPart NewsRequestDto newsRequestDto, @RequestPart List<MultipartFile> file) throws IOException {
        return newsService.update(id, newsRequestDto,file);
    }
}
