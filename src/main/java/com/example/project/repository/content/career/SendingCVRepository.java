package com.example.project.repository.content.career;

import com.example.project.model.content.career.SendingCVModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SendingCVRepository extends JpaRepository<SendingCVModel,Long> {
}
