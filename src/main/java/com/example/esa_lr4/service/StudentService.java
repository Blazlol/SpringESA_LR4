package com.example.esa_lr4.service;

import com.example.esa_lr4.jms.EventType;
import com.example.esa_lr4.model.Student;
import com.example.esa_lr4.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.esa_lr4.jms.Producer;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final Producer producer;

    @Autowired
    public StudentService(StudentRepository studentRepository, Producer producer) {
        this.studentRepository = studentRepository;
        this.producer = producer;
    }

    public Student findById(Long id){
        return studentRepository.getOne(id);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteById(Long id){
        studentRepository.deleteById(id);
        producer.sendMessage(studentRepository.findOneByUniqueId(id), EventType.delete);
    }
}
