package com.thoughtworks.capability.gtb.restfulapidesign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Team {
    private int id;
    private String name;
    private String note;

    private List<Student> studentList = new ArrayList<>();
}
