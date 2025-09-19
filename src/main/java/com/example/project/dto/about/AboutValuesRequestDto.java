package com.example.project.dto.about;

import com.example.project.dto.photo.PhotoResponseDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.MODULE)
public class AboutValuesRequestDto {
    String title;
    String description;

    List<PhotoResponseDto> icons;
}
