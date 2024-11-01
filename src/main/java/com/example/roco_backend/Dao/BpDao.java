package com.example.roco_backend.Dao;

import com.example.roco_backend.Pojo.Entity.BpEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BpDao extends CrudRepository<BpEntity, Long> {

    public List<BpEntity> findAllByUserId(String userId);

}
