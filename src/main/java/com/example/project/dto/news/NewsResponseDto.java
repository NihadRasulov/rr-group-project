package com.example.project.dto.news;

import com.example.project.dto.photo.PhotoResponseDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewsResponseDto {

    String title;
    String description;
    PhotoResponseDto image;
}
