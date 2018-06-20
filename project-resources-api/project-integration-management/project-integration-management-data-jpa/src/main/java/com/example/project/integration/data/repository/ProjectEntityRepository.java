package com.example.project.integration.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.project.integration.data.model.ProjectEntity;

@Repository
public interface ProjectEntityRepository extends PagingAndSortingRepository<ProjectEntity,String>{

}
