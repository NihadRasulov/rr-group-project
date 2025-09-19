package com.example.project.dto.home;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomeWhyChooseWeRequestDto {
    String icon;
    String title;
    String description;
}
