package com.java.student.student_management_system.controller;

import com.java.student.student_management_system.dto.StudentDto;
import com.java.student.student_management_system.service.StudentServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentServive studentServive;

    @GetMapping("/students")
    public String listStudents(Model model){
        List<StudentDto> students = studentServive.getAllStudents();
        model.addAttribute("students",students);
        return "students";
    }

}
