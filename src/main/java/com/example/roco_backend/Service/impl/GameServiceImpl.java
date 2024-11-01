package com.example.roco_backend.Service.impl;

import com.example.roco_backend.Dao.BanDao;
import com.example.roco_backend.Dao.BpDao;
import com.example.roco_backend.Dao.ChoiceDao;
import com.example.roco_backend.Pojo.Entity.BanEntity;
import com.example.roco_backend.Pojo.Entity.BpEntity;
import com.example.roco_backend.Pojo.Entity.ChoiceEntity;
import com.example.roco_backend.Pojo.Vo.GenieChoose;
import com.example.roco_backend.Pojo.Vo.ManaGenie;
import com.example.roco_backend.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private BpDao bpDao;

    @Autowired
    private BanDao banDao;

    @Autowired
    private ChoiceDao choiceDao;

    @Override
    public void startGame(String description, int round, List<Integer> bans, String userId) {
        BpEntity bpEntity = new BpEntity();
        bpEntity.setDescription(description);
        bpEntity.setRound(round);
        bpEntity.setBanNums(bans);
        bpEntity.setUserId(userId);
        bpDao.save(bpEntity);
    }

    @Override
    public List<BpEntity> getGame(String userId) {
        return bpDao.findAllByUserId(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteGame(Long id) {
        banDao.deleteAllByBpId(id);
        choiceDao.deleteAllByBpId(id);
        bpDao.deleteById(id);
        return;
    }

    @Override
    public List<BanEntity> getBans(Long id) {
        return banDao.findAllByBpId(id);
    }

    @Override
    public List<ChoiceEntity> getChoice(Long id) {
        return choiceDao.findAllByBpId(id);
    }

    @Override
    public void addBan(Long id, GenieChoose genieChoose) {
        BanEntity banEntity = banDao.findByBpIdAndAndAttributeAndGenieName(id, genieChoose.getAttribute(), genieChoose.getGenieName());
        if(banEntity == null)
            banEntity = new BanEntity();
        banEntity.setAttribute(genieChoose.getAttribute());
        banEntity.setGenieName(genieChoose.getGenieName());
        banEntity.setBpId(id);
        banDao.save(banEntity);
    }

    @Override
    public void addChoice(Long id, int round, int position, ManaGenie manaGenie) {
        ChoiceEntity choiceEntity = choiceDao.findByBpIdAndRoundAndPositionAndGenieNameAndExtra(id, round, position, manaGenie.getGenieName(), manaGenie.getExtra());
        if(choiceEntity == null)
            choiceEntity = new ChoiceEntity();
        choiceEntity.setBpId(id);
        choiceEntity.setAttribute(manaGenie.getAttribute());
        choiceEntity.setViceAttribute(manaGenie.getViceAttribute());
        choiceEntity.setGenieName(manaGenie.getGenieName());
        choiceEntity.setExtra(manaGenie.getExtra());
        choiceEntity.setGrade(manaGenie.getGrade());
        choiceEntity.setRound(round);
        choiceEntity.setPosition(position);
        choiceDao.save(choiceEntity);
    }

    @Override
    public void deleteBan(Long id, GenieChoose genieChoose) {
        BanEntity banEntity = banDao.findByBpIdAndAndAttributeAndGenieName(id, genieChoose.getAttribute(), genieChoose.getGenieName());
        if(banEntity != null)
            banDao.delete(banEntity);
    }

    @Override
    public void deleteChoice(Long id, int round, int position ,ManaGenie manaGenie) {
        ChoiceEntity choiceEntity = choiceDao.findByBpIdAndRoundAndPositionAndGenieNameAndExtra(id, round, position, manaGenie.getGenieName(), manaGenie.getExtra());
        if(choiceEntity != null)
            choiceDao.delete(choiceEntity);
    }
}
