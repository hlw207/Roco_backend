package com.example.roco_backend.Dao;


import com.example.roco_backend.Pojo.Entity.GenieEntity;
import com.example.roco_backend.Pojo.Vo.GenieSimple;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenieDao extends CrudRepository<GenieEntity, String> {

    @Query("select new com.example.roco_backend.Pojo.Vo.GenieSimple(genieName, grade) from GenieEntity where attribute = :attribute order by grade DESC")
    public List<GenieSimple> findNameByAttribute(@Param("attribute") String attribute);
}
