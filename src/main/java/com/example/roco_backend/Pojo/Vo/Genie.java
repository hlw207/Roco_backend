package com.example.roco_backend.Pojo.Vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Genie {

    private String attribute;

    private String viceAttribute;

    private String genieName;

    private double grade;
}
