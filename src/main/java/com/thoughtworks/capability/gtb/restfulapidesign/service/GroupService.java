package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {

    private final GroupRepo groupRepo = new GroupRepo();
    private final StudentService studentService = new StudentService();

    public List<Group> getGroupList() {
        return groupRepo.getGroupList();
    }

    public void updateGroup(Group group) {
        groupRepo.updateGroup(group);
    }

    public List<Group> randomlyAllocate() {
        List<Group> groupList = groupRepo.getGroupList();
        groupList.forEach(group -> group.setStudentList((new ArrayList<>())));
        List<Student> studentList = studentService.getAllStudents();
        Collections.shuffle(studentList);
        for (int i = 0; i < studentList.size(); i++) {
            groupList.get(i % groupList.size()).getStudentList().add(studentList.get(i));
        }
        for (Group group : groupList) {
            groupRepo.updateGroup(group);
        }
        return groupRepo.getGroupList();
    }

    public Group getGroupById(Integer id) {
        return groupRepo.getGroupById(id);
    }
}
