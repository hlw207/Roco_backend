package com.example.roco_backend.Service;

import com.example.roco_backend.Pojo.Entity.BanEntity;
import com.example.roco_backend.Pojo.Entity.BpEntity;
import com.example.roco_backend.Pojo.Entity.ChoiceEntity;
import com.example.roco_backend.Pojo.Vo.GenieChoose;
import com.example.roco_backend.Pojo.Vo.ManaGenie;

import java.util.List;

public interface GameService {
    public void startGame(String description, int round, List<Integer> bans, String userId);

    public List<BpEntity> getGame(String userId);

    public void deleteGame(Long id);

    public List<BanEntity> getBans(Long id);

    public List<ChoiceEntity> getChoice(Long id);

    public void addBan(Long id, GenieChoose genieChoose);

    public void addChoice(Long id, int round, int position, ManaGenie manaGenie);

    public void deleteBan(Long id, GenieChoose genieChoose);

    public void deleteChoice(Long id, int round, int position, ManaGenie manaGenie);
}
