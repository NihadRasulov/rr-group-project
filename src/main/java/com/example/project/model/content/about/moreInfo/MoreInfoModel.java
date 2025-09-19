package com.example.project.model.content.about.moreInfo;

import com.example.project.dto.photo.PhotoResponseDto;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable
public class MoreInfoModel {

    String name;
    String title;
    String description;

    List<PhotoResponseDto> images;
}
