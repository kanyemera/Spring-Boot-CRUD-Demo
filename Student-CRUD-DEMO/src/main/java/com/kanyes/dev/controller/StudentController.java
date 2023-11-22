package com.kanyes.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kanyes.dev.entity.Student;
import com.kanyes.dev.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService theStudentService) {
		
		studentService = theStudentService;
	}
	
	
	// add mapping for "/list"
	@GetMapping("/")
	public String listStudents(Model theModel) {
		
		// get the students from db
		List<Student> theStudents = studentService.findAll();
		
		
		// add to the spring model
		theModel.addAttribute("students", theStudents);
		
		return "list-students";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Student theStudent = new Student();
		
		theModel.addAttribute("student", theStudent);
		
		
		return "student-form";
	}
	
    @PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student theStudent) {
		
		// save the student
		
		studentService.save(theStudent);
		
		
		// use a redirect to prevent duplicate submissions
		
		return "redirect:/";
		
	}
    
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
    	
    	// get the student from the service
    	Student theStudent = studentService.findById(theId);
    	
    	// set student in the model prepopulate the form
    	theModel.addAttribute("student", theStudent);
    	
    	// send over to our form
    	return "student-update-form";
    }
    
    
    @PostMapping("/update")
	public String updateStudent(@ModelAttribute("student") Student theStudent) {
		
		// save the student
		
		studentService.update(theStudent);
		
		
		// use a redirect to prevent duplicate submissions
		
		return "redirect:/";
		
	}
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") int theID) {
    	
    	// delete the student
    	studentService.deleteById(theID);
    	
    	
    	// redirect to the /student list
    	return "redirect:/";
    }
	
	

}
