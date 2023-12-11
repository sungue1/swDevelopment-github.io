package com.example.SW_PBL.Controller;

import com.example.SW_PBL.Festival.Fstvl;
import com.example.SW_PBL.Train.Train;
import com.example.SW_PBL.User.User;
import com.example.SW_PBL.Festival.FstvlService;
import com.example.SW_PBL.Train.TrainService;
import com.example.SW_PBL.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@RestController
public class Controller {
    private final FstvlService fstvlService;
    private final UserService userService;
    private final TrainService trainService;

    @Autowired
    public Controller(FstvlService fstvlService, UserService userService, TrainService trainService) {
        this.fstvlService = fstvlService;
        this.userService = userService;
        this.trainService = trainService;
    }
//ok 기본 축제 리스트
    @GetMapping("/main")
    public List<Fstvl>defaultFstvl() throws SQLException, ClassNotFoundException {
        fstvlService.clearfstvl();
        return  fstvlService.findAllFstvl();
    }

//ok 프론트에서 축제 아이디를 주면 상세페이지 정보를 줌
    @PostMapping("/main/{fstvl_id}")
    public Fstvl detailFstvl(@PathVariable("fstvl_id") int fstvl_id) throws SQLException {
        return  fstvlService.findDetailFstvl(fstvl_id);
    }
//---------------------------------------------------------------------------------------------------------------------------
//ok 유저 위치 저장 id 는 자동증가
    @PutMapping("/main/{user_location}")
    public User updateForm(@PathVariable("user_location") String user_location) throws SQLException , ClassNotFoundException {
        return userService.UserInputSave(user_location);
    }

//------------------------------------------------------------------------------------------------------------------
//열차편 정보 주기
    @GetMapping ("/detail/{user_id}/{fstvl_id}")
    public List<Train> TrainView(@PathVariable("user_id") int user_id, @PathVariable("fstvl_id") int fstvl_id) throws SQLException, ClassNotFoundException {
        trainService.cleartrain();
        return trainService.getTrainTable(user_id, fstvl_id);
    }
    //키워드를 입력 안받으면 기간 크롤링만 , 둘다받으면 둘다 크롤링
    @PostMapping("/main/{keywords}/{user_date}")
    public List<Fstvl> wantedFstvl2(@PathVariable("keywords") String keywords,
                                    @PathVariable("user_date") String user_date) throws SQLException , ClassNotFoundException
    {
        fstvlService.clearfstvl();
        List<String> keywordlist = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(keywords,",");
        int num =stringTokenizer.countTokens();
        for(int i=0; i<num;i++){
            keywordlist.add(stringTokenizer.nextToken());
        }

        int keywordSize = keywordlist.size();
        String[] str = new String[keywordSize];

        for(int j=0; j<keywordSize;j++){
            str[j] =keywordlist.get(j);
        }


        if(keywords.equals("없음")){
            return fstvlService.findDateFstvl(user_date);
        }
        else{
            fstvlService.findDateFstvl(user_date);
            return fstvlService.findKeyFstvl(str);
        }
    }

//    @PostMapping("/main")
//    public List<Fstvl> wantedFstvl(@RequestParam(value="keywords",required=true) String[] keywords,
//                                   @RequestParam(value="user_date",required=true) String user_date) throws SQLException , ClassNotFoundException
//    {
//        fstvlService.clearfstvl();
//        if(keywords.equals("없음")){
//            return fstvlService.findDateFstvl(user_date);
//        }
//        else{
//            fstvlService.findDateFstvl(user_date);
//            return fstvlService.findKeyFstvl(keywords);
//        }
//    }
}
