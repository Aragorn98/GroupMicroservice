package com.example.groupCRUD.repository;

import com.example.groupCRUD.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{

    @Query(
            value = "SELECT * FROM group u WHERE u.name like CONCAT('%',?1,'%')",
            nativeQuery = true)
    ArrayList<Group> findGroupByName(String name);
}