package com.example.roco_backend.Dao;

import com.example.roco_backend.Pojo.Entity.BanEntity;
import com.example.roco_backend.Pojo.Entity.ChoiceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BanDao extends CrudRepository<BanEntity, Long> {

    public void deleteAllByBpId(Long bpId);

    public List<BanEntity> findAllByBpId(Long bpId);

    public BanEntity findByBpIdAndAndAttributeAndGenieName(Long bpId, String attribute, String genieName);
}
