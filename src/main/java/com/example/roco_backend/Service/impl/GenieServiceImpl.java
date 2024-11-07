package com.example.roco_backend.Service.impl;

import com.example.roco_backend.Dao.GenieDao;
import com.example.roco_backend.Dao.ManaGenieDao;
import com.example.roco_backend.Pojo.Entity.GenieEntity;
import com.example.roco_backend.Pojo.Entity.ManaGenieEntity;
import com.example.roco_backend.Pojo.Vo.Genie;
import com.example.roco_backend.Pojo.Vo.GenieSimple;
import com.example.roco_backend.Pojo.Vo.ManaGenie;
import com.example.roco_backend.Service.GenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenieServiceImpl implements GenieService {

    @Autowired
    private GenieDao genieDao;

    @Autowired
    private ManaGenieDao manaGenieDao;

    @Override
    public List<Genie> getGeniesByAttribute(String attribute) {
        System.out.println(attribute);
        return genieDao.findNameByAttribute(attribute);
    }

    @Override
    public List<ManaGenie> getManaGeniesByAttribute(String attribute) {
        System.out.println("mana " + attribute);
        return manaGenieDao.findNameByAttribute(attribute);
    }

    @Override
    public List<ManaGenie> getManaGeniesByGrade(double grade) {
        System.out.println(grade);
        return manaGenieDao.findNameByGrade(grade);
    }

    @Override
    public Genie getGenieByName(String genieName) {
        GenieEntity genieEntity = genieDao.findByGenieName(genieName);
        return new Genie(genieEntity.getAttribute(), genieEntity.getViceAttribute(), genieEntity.getGenieName(), genieEntity.getGrade());
    }

    @Override
    public ManaGenie getManaGenieByName(String genieName, double grade) {
        ManaGenieEntity manaGenieEntity = manaGenieDao.findByGenieNameAndGrade(genieName, grade);
        return new ManaGenie(manaGenieEntity.getAttribute(), manaGenieEntity.getViceAttribute(), manaGenieEntity.getGenieName(), manaGenieEntity.getGrade(), manaGenieEntity.getExtra());
    }
}
