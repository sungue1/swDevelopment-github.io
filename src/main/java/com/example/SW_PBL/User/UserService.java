package com.example.SW_PBL.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    public int length = 0;
    private final UserRepositoryImp userRepositoryImp;

    public UserService(UserRepositoryImp userRepositoryImp) {
        this.userRepositoryImp = userRepositoryImp;
    }
    //유저가 입력한값.저장
    public User UserInputSave(String user_location) throws SQLException, ClassNotFoundException {
        User newuser = new User();
        newuser.setUser_location(user_location);
        userRepositoryImp.save(newuser);
        return newuser;
    }

    public List<User> findAllUser() throws SQLException {

        return userRepositoryImp.findAll();
    }

    public void clearuser() throws SQLException {
        userRepositoryImp.clearStore();
    }
}
