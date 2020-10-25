package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentRepo {

    private final static Map<Integer, Student> studentList = new HashMap<>();

    public List<Student> getStudentList() {
        return new ArrayList<>(studentList.values());
    }

    public void addStudent(Student student) {
        studentList.put(student.getId(), student);
    }

    public void deleteStudent(Integer id) {
        studentList.remove(id);
    }

    public List<Student> getStudentListByGender(String gender) {
        return studentList.values().stream()
                .filter(student -> student.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public void updateStudent(Student student) {
        Student studentToUpdate = studentList.get(student.getId());
        studentToUpdate.setGender(student.getGender());
        studentToUpdate.setName(student.getName());
        studentToUpdate.setNote(student.getNote());
    }

    public Student getStudentById(Integer id) {
        return studentList.get(id);
    }
}
