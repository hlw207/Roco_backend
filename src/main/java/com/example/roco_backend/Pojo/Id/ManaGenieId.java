package com.example.roco_backend.Pojo.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class ManaGenieId implements Serializable {
    private String genieName;

    private double grade;

    // 构造函数、getter和setter方法
    public ManaGenieId() {}

    public ManaGenieId(String genieName, double grade) {
        this.genieName = genieName;
        this.grade = grade;
    }

    // equals和hashCode方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManaGenieId that = (ManaGenieId) o;
        return Double.compare(that.grade, grade) == 0 &&
                Objects.equals(genieName, that.genieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genieName, grade);
    }
}