package com.example.rest.resources;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskResourceRepository extends PagingAndSortingRepository<RiskResource, String> {

}
