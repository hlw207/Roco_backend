package com.example.roco_backend.Controller;

import com.example.roco_backend.Pojo.Vo.GenieSimple;
import com.example.roco_backend.Service.GenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://106.14.91.142:5174", allowCredentials = "true")
@RequestMapping("/genie")
public class GenieController {

    @Autowired
    private GenieService genieService;

    @GetMapping("/attribute")
    public List<GenieSimple> getGeniesByAttribute(@RequestParam String attribute){
        return genieService.getGeniesByAttribute(attribute);
    }
}
