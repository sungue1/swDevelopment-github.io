package com.example.Swpbl_back.service;
import com.example.Swpbl_back.crawling.Go;
import com.example.Swpbl_back.domain.Fstvl;
import com.example.Swpbl_back.domain.Train;
import com.example.Swpbl_back.domain.User;
import com.example.Swpbl_back.repository.FstvlRepository;
import com.example.Swpbl_back.repository.TrainRepository;
import com.example.Swpbl_back.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainService {
    private static TrainRepository trainRepository;
    private static UserRepository userRepository;
    private static FstvlRepository fstvlRepository;

    public TrainService(TrainRepository trainRepository, UserRepository userRepository, FstvlRepository fstvlRepository) {
        this.trainRepository = trainRepository;
        this.fstvlRepository = fstvlRepository;
        this.userRepository = userRepository;
    }

    //유저가 입력한값.저장
    public static List<Train> getTrainTable(Long user_id, Long fstvl_id) {
        Optional<User> user = userRepository.findById(user_id);
        User newUser = user.get();
        String userlocation = newUser.getUser_location();
        System.out.println(userlocation);

        Fstvl fstvl = fstvlRepository.findById(fstvl_id);
        Fstvl newFstvl = fstvl;
        String fstvlocation = newFstvl.getLocation();
        System.out.println(fstvlocation);

        Go go = new Go();
        List<Train> trainList = go.Save(userlocation, fstvlocation);
        for (Train train:trainList){
            trainRepository.save(train);
        }
        return trainRepository.findAll();
    }
}
