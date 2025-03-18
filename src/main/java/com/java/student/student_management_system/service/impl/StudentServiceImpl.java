package com.java.student.student_management_system.service.impl;

import com.java.student.student_management_system.dto.StudentDto;
import com.java.student.student_management_system.entity.Student;
import com.java.student.student_management_system.mapper.StudentMapper;
import com.java.student.student_management_system.repository.StudentRepository;
import com.java.student.student_management_system.service.StudentServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentServive {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentsDto = students.stream()
                // can change below line with this
                //.map((student)->StudentMapper.mapToStudentDto(student))
                .map(StudentMapper::mapToStudentDto)
                .collect(Collectors.toList());
        return studentsDto;
    }

}
