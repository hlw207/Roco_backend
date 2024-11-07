package com.example.roco_backend.Dao;

import com.example.roco_backend.Pojo.Entity.RecommendEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecommendDao extends CrudRepository<RecommendEntity, Long> {

    @Query("SELECT r FROM RecommendEntity r WHERE ((:userId != '' AND r.userId = :userId) OR :userId = '') AND r.type = :type ORDER BY r.date DESC, r.praise DESC")
    Page<RecommendEntity> findRecommendationsByUserId(@Param("userId") String userId, @Param("type") String type, Pageable pageable);

    @Query("select count(m) from RecommendEntity m where m.type = :type")
    public int countByType(@Param("type") String type);
}
