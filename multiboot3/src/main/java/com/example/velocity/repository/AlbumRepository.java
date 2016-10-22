package com.example.velocity.repository;

import com.example.velocity.entity.Album;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface AlbumRepository extends PagingAndSortingRepository<Album, Long>, JpaSpecificationExecutor {


}
