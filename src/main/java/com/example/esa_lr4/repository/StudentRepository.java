package com.example.esa_lr4.repository;

import com.example.esa_lr4.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends BaseEntityRepo<Student, Long> {
}
