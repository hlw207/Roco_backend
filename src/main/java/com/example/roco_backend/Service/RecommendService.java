package com.example.roco_backend.Service;

import com.example.roco_backend.Pojo.Vo.RecommendRequest;
import com.example.roco_backend.Pojo.Vo.RecommendVo;

import java.util.List;

public interface RecommendService {

    public void addRecommend(RecommendRequest recommendRequest);

    public List<RecommendVo> getRecommend(String userId, String type, int page);

    public int getTotal(String type);
}
