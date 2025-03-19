package com.java.student.student_management_system.service;

import com.java.student.student_management_system.dto.StudentDto;
import jakarta.validation.Valid;

import java.util.List;

public interface StudentServive {

    List<StudentDto> getAllStudents();

    void createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long studentId);

    void updateStudent(@Valid StudentDto studentDto);

    void deleteStudent(Long studentId);
}
