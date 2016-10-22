package com.example.workship.repository;

import com.example.workship.entity.BizAlbum;
import com.example.workship.entity.MyTable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface MyTableRepository extends PagingAndSortingRepository<MyTable, Long>, JpaSpecificationExecutor {


}
