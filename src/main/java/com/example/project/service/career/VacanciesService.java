package com.example.project.service.career;

import com.example.project.repository.content.career.VacanciesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VacanciesService {
    final VacanciesRepository vacanciesRepository;


}
