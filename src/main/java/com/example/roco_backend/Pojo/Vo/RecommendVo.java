package com.example.roco_backend.Pojo.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendVo {
    private Long id;
    private String type;
    private String user;
    private Date date;
    private List<ManaGenie> manaGenieList;
    private List<Genie> genieList;
    private String comment;
    private Integer praise;
}
