package com.example.roco_backend.Dao;

import com.example.roco_backend.Pojo.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserEntity, String> {

    public UserEntity findByAccountAndPassword(String account, String password);

    public UserEntity findByAccount(String account);
}
