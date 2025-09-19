package com.example.project.dto.projects;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectRequestDto {
    String projectName;
    String customer;
    LocalDate date;
    String description;
}
