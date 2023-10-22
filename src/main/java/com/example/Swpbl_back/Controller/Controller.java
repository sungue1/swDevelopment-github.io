package com.example.Swpbl_back.Controller;

import com.example.Swpbl_back.crawling.Go;
import com.example.Swpbl_back.domain.Fstvl;
import com.example.Swpbl_back.domain.User;
import com.example.Swpbl_back.service.FstvlService;
import com.example.Swpbl_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    //유저가 축제리스트를 다 달라고할때

    private final FstvlService fstvlService;
    private final UserService userService;

    @Autowired
    public Controller(FstvlService fstvlService , UserService userService) {
        this.fstvlService = fstvlService;
        this.userService = userService;
    }
    @GetMapping("/main")
    public List<Fstvl> FstvlAll(){
        return  fstvlService.findAllFstvl();
    }
    //유저가 정보를 입력할때 출발위치
    @PutMapping("/main")
    public User updateForm(@RequestBody User user){

        return userService.UserInputSave(user);
    }
    @GetMapping("/main2")
    public List<User> UserAll(){
        return  userService.findAllUser();
    }
    //이미지소스 ,fstvl_id  fstvl도착위치   //train table 축제상세정보
    @GetMapping("/detail/{}")
    public List TrainView(){
        Go go = new Go();
        int k = go.k;
        List transfer = new ArrayList();
        switch(k) {
            case 0:
                transfer.add(go.DaTa1);
                break;
            case 1:
                transfer.add(go.DaTa1);
                transfer.add(go.DaTa2);
                break;
            case 2:
                transfer.add(go.DaTa1);
                transfer.add(go.DaTa2);
                break;
        }
        return transfer;
    }
}
