package com.example.groupCRUD.repository;

import com.example.groupCRUD.Group;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface PaginationDao extends PagingAndSortingRepository<Group, Integer> {

}