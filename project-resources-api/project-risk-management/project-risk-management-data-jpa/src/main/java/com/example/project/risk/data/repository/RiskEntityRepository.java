package com.example.project.risk.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.project.risk.data.model.RiskEntity;

@Repository
public interface RiskEntityRepository extends PagingAndSortingRepository<RiskEntity,String>{

}
