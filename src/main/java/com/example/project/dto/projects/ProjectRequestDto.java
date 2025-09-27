package com.example.project.dto.projects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequestDto {
    @NotBlank(message = "Project name is required")
    String projectName;
    @NotBlank(message = "Customer name is required")
    String customer;
    @NotNull(message = "Date is required")
    LocalDate date;
    String description;
}
