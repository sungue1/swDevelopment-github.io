package com.example.SW_PBL.User;

import com.example.SW_PBL.User.User;
import com.example.SW_PBL.User.UserRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepositoryImp implements UserRepository {
    public User save(User userform) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fstvl_db", "root", "xl5ag63723!"
        );
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users(user_location) values(?)"
        );
        ps.setString(1, userform.getUser_location());

        int status = ps.executeUpdate();
        ps.close();
        conn.close();
        return userform;
    };


    public User findById(int user_id) throws SQLException{
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fstvl_db", "root", "xl5ag63723!"
        );
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users where user_id = ?");
        ps.setInt(1, user_id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User(rs.getInt("user_id"), rs.getString("user_location"));
        rs.close();
        ps.close();
        conn.close();

        return user;
    };


    public List<User> findAll() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fstvl_db", "root", "xl5ag63723!"
        );
        PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT * FROM users");
        ResultSet rsst = pstmt.executeQuery();
        rsst.next();
        int leng = rsst.getInt(1);
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users where user_id = ?");
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();
        for (int id = 1; id < leng; id++) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            User user = new User(rs.getInt("user_id"), rs.getString("user_location"));
            userList.add(user);
        }
        rs.close();
        ps.close();
        conn.close();

        return userList;
    }

    public void clearStore() throws SQLException{
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fstvl_db", "root", "xl5ag63723!"
        );
        PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE users");
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

}
