package com.example.project.dto.about;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AboutAdministrationStructureRequestDto {
    String title;
    String description;
}
