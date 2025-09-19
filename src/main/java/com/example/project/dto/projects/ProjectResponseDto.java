package com.example.project.dto.projects;

import com.example.project.dto.photo.PhotoResponseDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectResponseDto {
    String projectName;
    LocalDate localDate;
    String customer;
    String description;
    PhotoResponseDto image;
}
