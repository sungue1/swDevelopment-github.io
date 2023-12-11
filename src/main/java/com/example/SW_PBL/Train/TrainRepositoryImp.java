package com.example.SW_PBL.Train;

import org.springframework.stereotype.Repository;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainRepositoryImp {
    public Train save(Train trainform) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fstvl_db", "root", "xl5ag63723!"
        );
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO trains(dep, arr, etd, eta, price, duration) values(?, ?, ?, ?, ?, ?)"
        );
        ps.setString(1, trainform.getDep());
        ps.setString(2, trainform.getArr());
        ps.setString(3, trainform.getEtd());
        ps.setString(4, trainform.getEta());
        ps.setString(5, trainform.getPrice());
        ps.setString(6, trainform.getDuration());

        int status = ps.executeUpdate();
        ps.close();
        conn.close();
        return trainform;
    }



    public List<Train> findAll(int length) throws SQLException {
        int leng = length + 1;
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fstvl_db", "root", "xl5ag63723!"
        );
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM trains where train_id = ?");
        ResultSet rs = null;
        List<Train> trainList = new ArrayList<>();
        for (int id = 1; id < leng; id++) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            Train train = new Train(rs.getInt("train_id"), rs.getString("dep"), rs.getString("arr"), rs.getString("etd"), rs.getString("eta"), rs.getString("price"),  rs.getString("duration"));
            trainList.add(train);
        }
        rs.close();
        ps.close();
        conn.close();

        return trainList;
    }


    public Train findById(int train_id) throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fstvl_db", "root", "xl5ag63723!"
        );
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM trains where train_id = ?");
        ps.setInt(1, train_id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Train train = new Train(rs.getInt("train_id"), rs.getString("dep"), rs.getString("arr"), rs.getString("etd"), rs.getString("eta"), rs.getString("price"),  rs.getString("duration"));
        rs.close();
        ps.close();
        conn.close();

        return train;
    }

    public void clearStore() throws SQLException{
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fstvl_db", "root", "xl5ag63723!"
        );
        PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE trains");
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

}
