package com.example.project.repository.content.career;

import com.example.project.model.content.career.VacanciesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacanciesRepository extends JpaRepository<VacanciesModel,Long> {
}
