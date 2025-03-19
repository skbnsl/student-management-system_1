package com.java.student.student_management_system.controller;

import com.java.student.student_management_system.dto.StudentDto;
import com.java.student.student_management_system.service.StudentServive;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/students/new")
    public String newStudent(Model model){
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student",studentDto);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto student,
                              BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("student",student);
            return "create_student";
        }
        studentServive.createStudent(student);
        return "redirect:/students";
    }

    //handler method to handle edit student request
    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long studentId, Model model){
        StudentDto student = studentServive.getStudentById(studentId);
        model.addAttribute("student",student);
        return "edit_student";
    }

    //handler method to handle edit student from submit request
    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,
                                @Valid @ModelAttribute("student") StudentDto studentDto,
                                BindingResult result,
                                Model model){
        if(result.hasErrors()){
            model.addAttribute("student",studentDto);
            return "edit_student";
        }
        studentDto.setId(studentId);
        studentServive.updateStudent(studentDto);
        return "redirect:/students";
    }


    //handler method to handler delete student request
    @GetMapping("/students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long studentId){
        studentServive.deleteStudent(studentId);
        return "redirect:/students";
    }

    //handler method to handle view student request
    @GetMapping("/students/{studentId}/view")
    public String viewStudent(@PathVariable("studentId") Long studentId, Model model){
        StudentDto studentDto = studentServive.getStudentById(studentId);
        model.addAttribute("student",studentDto);
        return "view_student";
    }

}