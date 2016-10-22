package com.example.velocity.repository;

import com.example.velocity.entity.PersistentLogins;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface PersistentLoginsRepository extends PagingAndSortingRepository<PersistentLogins, Long>, JpaSpecificationExecutor {


}
