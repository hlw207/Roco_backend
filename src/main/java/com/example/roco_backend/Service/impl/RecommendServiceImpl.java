package com.example.roco_backend.Service.impl;

import com.example.roco_backend.Dao.RecommendDao;
import com.example.roco_backend.Pojo.Entity.RecommendEntity;
import com.example.roco_backend.Pojo.Vo.Genie;
import com.example.roco_backend.Pojo.Vo.ManaGenie;
import com.example.roco_backend.Pojo.Vo.RecommendRequest;
import com.example.roco_backend.Pojo.Vo.RecommendVo;
import com.example.roco_backend.Service.GenieService;
import com.example.roco_backend.Service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {

    @Autowired
    private RecommendDao recommendDao;

    @Autowired
    private GenieService genieService;

    @Override
    public void addRecommend(RecommendRequest recommendRequest) {
        RecommendEntity recommendEntity = new RecommendEntity();
        recommendEntity.setUserId(recommendRequest.getUserId());
        recommendEntity.setType(recommendRequest.getType());
        recommendEntity.setComment(recommendRequest.getComment());
        recommendEntity.setDate(new Date());
        recommendEntity.setPraise(0);
        List<String> genieNames = new ArrayList<>();
        List<Double> genieGrades = new ArrayList<>();
        if(recommendRequest.getType().equals("魔力值")) {
            List<ManaGenie> manaGenieList = recommendRequest.getManaGenieList();
            for (int i = 0; i < manaGenieList.size(); i++){
                genieNames.add(manaGenieList.get(i).getGenieName());
                genieGrades.add(manaGenieList.get(i).getGrade());
            }
        }else {
            List<Genie> genieList = recommendRequest.getGenieList();
            for (int i = 0; i < recommendRequest.getGenieList().size(); i++){
                genieNames.add(genieList.get(i).getGenieName());
                genieGrades.add(genieList.get(i).getGrade());
            }
        }
        recommendEntity.setGenieNames(genieNames);
        recommendEntity.setGenieGrades(genieGrades);
        recommendDao.save(recommendEntity);
    }

    @Override
    public List<RecommendVo> getRecommend(String userId, String type, int page) {
        Page<RecommendEntity> listPage = recommendDao.findRecommendationsByUserId(userId, type, PageRequest.of(page, 10));
        List<RecommendEntity> recommendEntityList = listPage.getContent();
        List<RecommendVo> recommendVoList = new ArrayList<>();
        for (RecommendEntity recommendEntity: recommendEntityList){
            RecommendVo recommendVo = new RecommendVo();
            recommendVo.setId(recommendEntity.getId());
            recommendVo.setType(recommendEntity.getType());
            recommendVo.setDate(recommendEntity.getDate());
            recommendVo.setPraise(recommendEntity.getPraise());
            recommendVo.setComment(recommendEntity.getComment());
            recommendVo.setUser(recommendEntity.getUserId());
            List<String> genieNames = recommendEntity.getGenieNames();
            List<Double> genieGrades = recommendEntity.getGenieGrades();
            if(recommendVo.getType().equals("魔力值")){
                List<ManaGenie> manaGenieList = new ArrayList<>();
                for (int i = 0;i < genieNames.size();i++){
                    if(genieNames.get(i).equals(""))
                        continue;
                    ManaGenie manaGenie = genieService.getManaGenieByName(genieNames.get(i), genieGrades.get(i));
                    manaGenieList.add(manaGenie);
                }
                recommendVo.setManaGenieList(manaGenieList);
            }else {
                List<Genie> genieList = new ArrayList<>();
                for (int i = 0;i < genieNames.size();i++){
                    if(genieNames.get(i).equals(""))
                        continue;
                    Genie genie = genieService.getGenieByName(genieNames.get(i));
                    genieList.add(genie);
                }
                recommendVo.setGenieList(genieList);
            }
            recommendVoList.add(recommendVo);
        }
        return recommendVoList;
    }

    @Override
    public int getTotal(String type) {
        return recommendDao.countByType(type);
    }

}
