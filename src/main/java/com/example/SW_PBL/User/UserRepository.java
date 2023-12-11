package com.example.SW_PBL.User;

import com.example.SW_PBL.User.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    User save(User user) throws ClassNotFoundException, SQLException;


    User findById(int id) throws SQLException;


    List<User> findAll() throws SQLException;


    void clearStore() throws SQLException;


}
