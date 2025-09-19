package com.example.project.dto.home;

import com.example.project.dto.photo.PhotoResponseDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomeProjectRequestDto {
    List<PhotoResponseDto> images;
}
