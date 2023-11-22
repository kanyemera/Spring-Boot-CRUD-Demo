package com.kanyes.dev.service;

import com.kanyes.dev.dao.StudentDAO;
import com.kanyes.dev.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO theStudentDAO) {
        studentDAO = theStudentDAO;
    }

    @Override
    public List<Student> findAll() {
        //return employeeRepository.findAll();
    	// make use of our new method in the repository to sort by last name
        return studentDAO.findAll();
    }

	@Override
	public Student findById(int theId) {
		
		return studentDAO.findById(theId);
	}

	

	@Override
	public void deleteById(int theId) {
	
		studentDAO.delete(theId);
		
	}

	@Override
	public void save(Student theStudent) {
		
		studentDAO.save(theStudent);

	}

	@Override
	public void update(Student theStudent) {
		studentDAO.update(theStudent);
		
	}

   

}






