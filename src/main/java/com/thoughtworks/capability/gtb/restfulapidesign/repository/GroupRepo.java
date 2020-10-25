package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupRepo {

    private final Map<Integer, Group> groupList = new HashMap<>();

    public GroupRepo() {
        for (int i = 0; i <= 5; i++) {
            groupList.put(i + 1, new Group((i + 1), String.valueOf(i + 1), "", new ArrayList<>()));
        }
    }

    public List<Group> getGroupList() {
        return new ArrayList<>(groupList.values());
    }

    public void updateGroup(Group group) {
        Group groupToUpdate = groupList.get(group.getId());
        groupToUpdate.setName(group.getName());
        groupList.put(group.getId(), groupToUpdate);
    }

    public Group getGroupById(Integer id) {
        return groupList.get(id);
    }
}
