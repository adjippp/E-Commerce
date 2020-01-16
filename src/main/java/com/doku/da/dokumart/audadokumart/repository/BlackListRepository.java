package com.doku.da.dokumart.audadokumart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.doku.da.dokumart.audadokumart.entity.BlackList;

@Repository
@Component
public interface BlackListRepository extends JpaRepository<BlackList, Integer> {
    //public BlackList findByPembeli(Integer id);
     @Query(value = "SELECT b FROM master_blacklist b WHERE b.pembeli.id = :id ")
    BlackList findByPembeli(@Param("id") Integer id);
}