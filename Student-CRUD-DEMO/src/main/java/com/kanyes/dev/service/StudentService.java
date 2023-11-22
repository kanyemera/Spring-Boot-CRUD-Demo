package com.kanyes.dev.service;

import com.kanyes.dev.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(int theId);

    void save(Student theStudent);

    void deleteById(int theId);
    
    void update(Student theStudent);

}
