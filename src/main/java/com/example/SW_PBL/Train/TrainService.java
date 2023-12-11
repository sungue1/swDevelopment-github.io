package com.example.SW_PBL.Train;
import com.example.SW_PBL.Festival.FstvlRepositoryImp;
import com.example.SW_PBL.Festival.Fstvl;
import com.example.SW_PBL.User.User;
import com.example.SW_PBL.User.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TrainService {
    public int length = 0;
    private final TrainRepositoryImp trainRepositoryImp;
    private static UserRepository userRepository;
    private final FstvlRepositoryImp fstvlRepositoryImp;

    public TrainService(TrainRepositoryImp trainRepositoryImp, UserRepository userRepository, FstvlRepositoryImp fstvlRepositoryImp) {
        this.trainRepositoryImp = trainRepositoryImp;
        this.fstvlRepositoryImp = fstvlRepositoryImp;
        this.userRepository = userRepository;
    }


    //유저가 입력한값.저장
    public List<Train> getTrainTable(int user_id, int fstvl_id) throws SQLException, ClassNotFoundException {
        User user = userRepository.findById(user_id);
        String userlocation = user.getUser_location();

        Fstvl fstvl = fstvlRepositoryImp.findById(fstvl_id);
        String fstvlocation = fstvl.getLocation();
        Go go = new Go();
        List<Train> trainList = go.Save(userlocation, fstvlocation);
        for (Train train:trainList){
            trainRepositoryImp.save(train);
        }
        length = go.length;
        return trainRepositoryImp.findAll(length);
    }

    public Train getTrainObj(int train_id) throws SQLException {
        return trainRepositoryImp.findById(train_id);
    }

    public void cleartrain() throws SQLException {
        trainRepositoryImp.clearStore();
    }
}
