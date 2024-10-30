package com.example.roco_backend.Pojo.Entity;

import com.example.roco_backend.Pojo.Id.ManaGenieId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ManaGenieId.class)
public class ManaGenieEntity {

    private String attribute;

    private String viceAttribute;

    @Id
    private String genieName;

    @Id
    private double grade;

    private String extra;
}
