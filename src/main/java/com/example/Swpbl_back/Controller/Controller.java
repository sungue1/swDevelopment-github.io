package com.example.Swpbl_back.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/api/fstvl")
    public String FstvlView(){

        return "Hello, World!";
    }

    @GetMapping("/api/train")
    public String TrainView(){

        return "Hello, World!";
    }
}
