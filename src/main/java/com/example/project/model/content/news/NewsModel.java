package com.example.project.model.content.news;

import com.example.project.dto.photo.PhotoResponseDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class NewsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String title;

    @Column(columnDefinition = "TEXT")
    String description;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    List<PhotoResponseDto> images;

    Instant createdTime;

    Instant updatedTime;

    @PrePersist
    public void init(){
        createdTime = updatedTime = Instant.now();
    }

    @PreUpdate
    public void update(){
        updatedTime = Instant.now();
    }
}
