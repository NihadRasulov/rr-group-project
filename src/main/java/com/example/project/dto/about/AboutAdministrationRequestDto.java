package com.example.project.dto.about;

import com.example.project.dto.photo.PhotoResponseDto;
import com.example.project.model.content.about.moreInfo.MoreInfoModel;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AboutAdministrationRequestDto {
    String name;
    String description;

    List<MoreInfoModel> moreInfo;

    List<PhotoResponseDto> images;
}
