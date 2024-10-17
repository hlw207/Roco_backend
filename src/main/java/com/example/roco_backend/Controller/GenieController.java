package com.example.roco_backend.Controller;

import com.example.roco_backend.Pojo.Vo.Genie;
import com.example.roco_backend.Pojo.Vo.GenieSimple;
import com.example.roco_backend.Service.GenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/genie")
public class GenieController {

    @Autowired
    private GenieService genieService;

    @GetMapping("/attribute")
    public List<GenieSimple> getGeniesByAttribute(@RequestParam String attribute){
        return genieService.getGeniesByAttribute(attribute);
    }

    @GetMapping("/mana/attribute")
    public List<Genie> getManaGeniesByAttribute(@RequestParam String attribute){
        return genieService.getManaGeniesByAttribute(attribute);
    }
}
