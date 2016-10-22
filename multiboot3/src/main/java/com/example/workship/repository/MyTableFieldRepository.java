package com.example.workship.repository;

import com.example.workship.entity.MyTable;
import com.example.workship.entity.MyTableField;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface MyTableFieldRepository extends PagingAndSortingRepository<MyTableField, Long>, JpaSpecificationExecutor {

    List<MyTableField> findByTableName(String tableName);

}
