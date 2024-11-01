package com.example.roco_backend.Controller;

import com.example.roco_backend.Pojo.Entity.BanEntity;
import com.example.roco_backend.Pojo.Entity.BpEntity;
import com.example.roco_backend.Pojo.Entity.ChoiceEntity;
import com.example.roco_backend.Pojo.Vo.GameRequest;
import com.example.roco_backend.Pojo.Vo.GenieChoose;
import com.example.roco_backend.Pojo.Vo.ManaGenie;
import com.example.roco_backend.Service.GameService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/start")
    private void startGame(@RequestBody GameRequest gameRequest){
        gameService.startGame(gameRequest.description, gameRequest.round, gameRequest.bans, gameRequest.userId);
    }

    @PostMapping("/delete")
    private void deleteGame(@RequestParam Long id){
        gameService.deleteGame(id);
    }

    @GetMapping("/bp")
    private List<BpEntity> getBpInfo(@RequestParam String userId){
        return gameService.getGame(userId);
    }

    @GetMapping("/getBans")
    private List<BanEntity> getBans(@RequestParam Long id){
        return gameService.getBans(id);
    }

    @GetMapping("/getChoice")
    private List<ChoiceEntity> getChoice(@RequestParam Long id){
        return gameService.getChoice(id);
    }

    // 添加禁选
    @PostMapping("/addBan")
    public void addBan(@RequestParam Long id, @RequestBody GenieChoose genieChoose) {
        gameService.addBan(id, genieChoose);
    }

    // 添加选择
    @PostMapping("/addChoice")
    public void addChoice(@RequestParam Long id, @RequestParam int round, @RequestParam int position, @RequestBody ManaGenie manaGenie) {
        gameService.addChoice(id, round, position, manaGenie);
    }

    // 删除禁选
    @DeleteMapping("/deleteBan")
    public void deleteBan(@RequestParam Long id, @RequestBody GenieChoose genieChoose) {
        gameService.deleteBan(id, genieChoose);
    }

    // 删除选择
    @DeleteMapping("/deleteChoice")
    public void deleteChoice(@RequestParam Long id, @RequestParam int round, @RequestParam int position, @RequestBody ManaGenie manaGenie) {
        gameService.deleteChoice(id, round, position, manaGenie);
    }
}
