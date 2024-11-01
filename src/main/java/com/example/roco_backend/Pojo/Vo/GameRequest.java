package com.example.roco_backend.Pojo.Vo;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Data
public class GameRequest {

    public String description;

    public int round;

    public List<Integer> bans;

    public String userId;
}
