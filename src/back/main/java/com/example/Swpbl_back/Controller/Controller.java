package com.example.Swpbl_back.Controller;

import com.example.Swpbl_back.domain.Fstvl;
import com.example.Swpbl_back.domain.User;
import com.example.Swpbl_back.service.FstvlService;
import com.example.Swpbl_back.service.TrainService;
import com.example.Swpbl_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    //유저가 축제리스트를 다 달라고할때

    private final FstvlService fstvlService;
    private final UserService userService;
    private final TrainService trainService;

    @Autowired
    public Controller(FstvlService fstvlService, UserService userService, TrainService trainService) {
        this.fstvlService = fstvlService;
        this.userService = userService;
        this.trainService = trainService;
    }

    //모든 축제 리스트 받기
    @GetMapping("/main")
    public List<Fstvl> defaultFstvl() {
        return  fstvlService.findDefaultFstvl();
    }

    @GetMapping("/main1")
    public String wantedFstvl() {
        return  "리스트";
    }

    @GetMapping("/main1/{photo}")
    public Fstvl detailFstvl(@PathVariable("photo") String photo) {
        return  fstvlService.findDetailFstvl(photo);
    }
    @GetMapping("/main/{id}")
    public Fstvl detailFstvl(@PathVariable("id") Long id) {
        return  fstvlService.findDetailFstvl2(id);
    }


    //----------------------------------------------------------------------------------------------------------

    //유저가 정보를 입력
    @PutMapping("/main")
    public User userUpdate(@RequestBody User user) {
        return userService.UserInputSave(user);
    }

    //유저 리스트 확인
    @GetMapping("/main2")
    public List<User> userAll() {
        return userService.findAllUser();
    }

    //이미지소스 ,fstvl_id  fstvl도착위치   //train table 축제상세정보



//----------------------------------------------------------------------------------------------------------
    // 열차편 요청
    @GetMapping ("/detail/{user_id}/{fstvl_id}")
    public List TrainView(@PathVariable("user_id") Long user_id, @PathVariable("fstvl_id") Long fstvl_id) {
        return trainService.getTrainTable(user_id, fstvl_id);
    }



    @GetMapping ("/detail1/{user_id}/{fstvl_id}")
    public Long TestTrainView(@PathVariable("user_id") Long user_id, @PathVariable("fstvl_id") Long fstvl_id) {
        return user_id;
    }

}
