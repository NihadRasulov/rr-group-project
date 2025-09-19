package com.example.project.dto.news;

import com.example.project.dto.photo.PhotoResponseDto;
import jakarta.validation.constraints.NotBlank;

public record NewsRequestDto (
        @NotBlank(message = "Title can not be empty or null")
        String title,
        String description,
        PhotoResponseDto image
){
}
