package com.example.roco_backend.Dao;


import com.example.roco_backend.Pojo.Entity.GenieEntity;
import com.example.roco_backend.Pojo.Vo.Genie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenieDao extends CrudRepository<GenieEntity, String> {

    @Query("select new com.example.roco_backend.Pojo.Vo.Genie(attribute, viceAttribute ,genieName, grade) from GenieEntity where attribute = :attribute or viceAttribute = :attribute order by grade DESC")
    public List<Genie> findNameByAttribute(@Param("attribute") String attribute);
}
