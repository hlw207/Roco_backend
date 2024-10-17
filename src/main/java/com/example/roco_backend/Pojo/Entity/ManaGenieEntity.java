package com.example.roco_backend.Pojo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManaGenieEntity {

    private String attribute;

    private String viceAttribute;

    @Id
    private String genieName;

    private double grade;
}
