package com.example.groupCRUD.web;


import com.example.groupCRUD.Group;
import com.example.groupCRUD.repository.GroupRepository;
import com.example.groupCRUD.repository.PaginationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.NameNotFoundException;
import javax.validation.Valid;

//end::baseClass[]
//tag::baseClass[]

@RestController
//@RequestMapping("/group")
public class GroupController {

    private GroupRepository groupRepository;
    private PaginationDao paginationDao;


    @Autowired
    public GroupController(GroupRepository groupRepository, PaginationDao paginationDao) {
        this.groupRepository = groupRepository;
        this.paginationDao = paginationDao;
    }

    @GetMapping("/groupName/{id}")
    public String getGroupNameById(@PathVariable("id") long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid group Id:" + id));
        return group.getName();
    }

    @GetMapping("/ps")
    public Iterable<Group> getAllGroups(@RequestParam String orderBy, @RequestParam String direction,
                                             @RequestParam int page, @RequestParam int size) {
        PaginationService paginationService = new PaginationService(paginationDao);
        return paginationService.findJsonDataByCondition(orderBy, direction, page, size);


    }

    @GetMapping("/psOrderBy")
    public Iterable<Group> getAllGroups(@RequestParam String orderBy) {
        PaginationService paginationService = new PaginationService(paginationDao);
        return paginationService.findJsonDataByCondition(orderBy, "ASC",0,5);
    }

    @GetMapping
    public Iterable<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @GetMapping("/find")
    public Iterable<Group> findGroups(@RequestParam String searchText) {
        return groupRepository.findGroupByName(searchText);
    }

    @PostMapping("/group/add")
    public Group saveGroup(@RequestBody @Valid Group group) {
        return groupRepository.save(group);
    }

    @PutMapping("/group/update/{id}")
    public void updateGroup(@PathVariable long id, @RequestBody Group group) {
        if (group.getId() != id) {
            throw new IllegalStateException("Given group's ID doesn't match the ID in the path.");
        }
        groupRepository.save(group);
    }

    @DeleteMapping("/group/delete/{id}")
    public void deleteGroup(@PathVariable long id) {
        groupRepository.deleteById(id);
    }

}