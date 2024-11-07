package com.example.roco_backend.Pojo.Vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RecommendRequest {
    private String userId;

    private String type;

    private List<Genie> genieList;

    private List<ManaGenie> manaGenieList;

    private String comment;
}
