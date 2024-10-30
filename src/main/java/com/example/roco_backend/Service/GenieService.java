package com.example.roco_backend.Service;

import com.example.roco_backend.Dao.GenieDao;
import com.example.roco_backend.Pojo.Vo.Genie;
import com.example.roco_backend.Pojo.Vo.GenieSimple;
import com.example.roco_backend.Pojo.Vo.ManaGenie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface GenieService {

    public List<Genie> getGeniesByAttribute(String attribute);

    public List<ManaGenie> getManaGeniesByAttribute(String attribute);

}
