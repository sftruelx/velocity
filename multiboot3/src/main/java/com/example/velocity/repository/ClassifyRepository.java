package com.example.velocity.repository;

import com.example.velocity.entity.Classify;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface ClassifyRepository extends PagingAndSortingRepository<Classify, Long>, JpaSpecificationExecutor {


}
