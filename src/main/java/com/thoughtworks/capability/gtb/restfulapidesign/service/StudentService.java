package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo = new StudentRepo();

    public void addStudent(Student student) {
        studentRepo.addStudent(student);
    }

    public void deleteStudent(Integer id) {
        studentRepo.deleteStudent(id);
    }

    public List<Student> getAllStudents() {
        return studentRepo.getStudentList();
    }

    public List<Student> getAllStudentsOrByGender(String gender) {
        if (gender == null) {
            return studentRepo.getStudentList();
        } else {
            return studentRepo.getStudentListByGender(gender);
        }
    }

    public Student getStudentById(Integer id) {
        return studentRepo.getStudentById(id);
    }

    public void updateStudent(Student student) {
        studentRepo.updateStudent(student);
    }
}

