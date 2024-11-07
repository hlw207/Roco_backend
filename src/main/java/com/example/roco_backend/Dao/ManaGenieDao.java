package com.example.roco_backend.Dao;

import com.example.roco_backend.Pojo.Entity.GenieEntity;
import com.example.roco_backend.Pojo.Entity.ManaGenieEntity;
import com.example.roco_backend.Pojo.Id.ManaGenieId;
import com.example.roco_backend.Pojo.Vo.Genie;
import com.example.roco_backend.Pojo.Vo.GenieSimple;
import com.example.roco_backend.Pojo.Vo.ManaGenie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ManaGenieDao extends CrudRepository<ManaGenieEntity, ManaGenieId> {

    @Query("select new com.example.roco_backend.Pojo.Vo.ManaGenie(attribute, viceAttribute, genieName, grade, extra) from ManaGenieEntity where attribute = :attribute or viceAttribute = :attribute order by grade DESC")
    public List<ManaGenie> findNameByAttribute(@Param("attribute") String attribute);

    @Query("select new com.example.roco_backend.Pojo.Vo.ManaGenie(attribute, viceAttribute, genieName, grade, extra) from ManaGenieEntity where grade = :grade")
    public List<ManaGenie> findNameByGrade(@Param("grade") double grade);

    public ManaGenieEntity findByGenieNameAndGrade(String genieName, double grade);
}
