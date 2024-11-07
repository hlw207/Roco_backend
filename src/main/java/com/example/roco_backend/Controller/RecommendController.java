package com.example.roco_backend.Controller;

import com.example.roco_backend.Pojo.Vo.RecommendRequest;
import com.example.roco_backend.Pojo.Vo.RecommendVo;
import com.example.roco_backend.Service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/recommend")
public class RecommendController {

    @Autowired
    private RecommendService recommendService;

    @PostMapping("/add")
    public void addRecommend(@RequestBody RecommendRequest recommendRequest){
        recommendService.addRecommend(recommendRequest);
    }

    @GetMapping("/lineUp")
    public List<RecommendVo> getRecommend(@RequestParam String userId, @RequestParam String type ,@RequestParam int page){
        return recommendService.getRecommend(userId, type, page);
    }

    @GetMapping("/lineUpTotal")
    public int getTotal(@RequestParam String type){
        return recommendService.getTotal(type);
    }
}
