package com.example.roco_backend.Dao;

import com.example.roco_backend.Pojo.Entity.GenieEntity;
import com.example.roco_backend.Pojo.Entity.ManaGenieEntity;
import com.example.roco_backend.Pojo.Vo.Genie;
import com.example.roco_backend.Pojo.Vo.GenieSimple;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ManaGenieDao extends CrudRepository<ManaGenieEntity, String> {

    @Query("select new com.example.roco_backend.Pojo.Vo.Genie(attribute, viceAttribute, genieName, grade) from ManaGenieEntity where attribute = :attribute or viceAttribute = :attribute order by grade DESC")
    public List<Genie> findNameByAttribute(@Param("attribute") String attribute);
}
