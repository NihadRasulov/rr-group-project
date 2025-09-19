package com.example.project.service.career;

import com.example.project.model.content.career.CareerModel;
import com.example.project.repository.content.career.SendingCVRepository;
import com.example.project.repository.content.career.VacanciesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CareerService {

    final private VacanciesRepository vacanciesRepository;
    final private SendingCVRepository sendingCVRepository;

    public CareerModel getCareerPage() {
        CareerModel careerModel = new CareerModel();
//        careerModel.setCvModel();
        return careerModel;
    }
}
