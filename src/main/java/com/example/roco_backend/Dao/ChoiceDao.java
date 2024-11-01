package com.example.roco_backend.Dao;

import com.example.roco_backend.Pojo.Entity.ChoiceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChoiceDao extends CrudRepository<ChoiceEntity, Long> {

    public void deleteAllByBpId(Long bpId);

    public List<ChoiceEntity> findAllByBpId(Long bpId);

    public ChoiceEntity findByBpIdAndRoundAndPositionAndGenieNameAndExtra(Long bpId, int round, int position, String genieName, String extra);
}
