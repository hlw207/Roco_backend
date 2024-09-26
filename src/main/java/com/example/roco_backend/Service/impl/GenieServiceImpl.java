package com.example.roco_backend.Service.impl;

import com.example.roco_backend.Dao.GenieDao;
import com.example.roco_backend.Pojo.Vo.GenieSimple;
import com.example.roco_backend.Service.GenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenieServiceImpl implements GenieService {

    @Autowired
    private GenieDao genieDao;

    @Override
    public List<GenieSimple> getGeniesByAttribute(String attribute) {
        System.out.println(attribute);
        return genieDao.findNameByAttribute(attribute);
    }
}
