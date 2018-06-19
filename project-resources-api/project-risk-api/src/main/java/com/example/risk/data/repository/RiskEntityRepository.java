package com.example.risk.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.risk.data.model.RiskEntity;

@Repository
public interface RiskEntityRepository extends PagingAndSortingRepository<RiskEntity,String> {

}
