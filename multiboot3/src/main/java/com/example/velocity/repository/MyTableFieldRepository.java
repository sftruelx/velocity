package com.example.velocity.repository;

import com.example.velocity.entity.MyTableField;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface MyTableFieldRepository extends PagingAndSortingRepository<MyTableField, Long>, JpaSpecificationExecutor {


}
