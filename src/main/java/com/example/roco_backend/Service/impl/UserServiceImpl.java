package com.example.roco_backend.Service.impl;

import com.example.roco_backend.Dao.UserDao;
import com.example.roco_backend.Pojo.Entity.UserEntity;
import com.example.roco_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean login(String account, String password) {
        UserEntity userEntity = userDao.findByAccountAndPassword(account, password);
        if(userEntity == null)
            return false;
        else
            return true;
    }

    @Override
    public boolean register(String account, String password) {
        UserEntity userEntity = userDao.findByAccount(account);
        if(userEntity != null)
            return false;
        else {
            userEntity = new UserEntity(account, "", password);
            userDao.save(userEntity);
            return true;
        }
    }

    @Override
    public boolean isExist(String account) {
        UserEntity userEntity = userDao.findByAccount(account);
        return userEntity != null;
    }

    @Override
    public void changeName(String name, String account) {
        UserEntity userEntity = userDao.findByAccount(account);
        userEntity.setName(name);
        userDao.save(userEntity);
    }

    @Override
    public String getName(String account) {
        UserEntity userEntity = userDao.findByAccount(account);
        return userEntity.getName();
    }

    @Override
    public List<UserEntity> getAll() {
        return (List<UserEntity>) userDao.findAll();
    }
}
