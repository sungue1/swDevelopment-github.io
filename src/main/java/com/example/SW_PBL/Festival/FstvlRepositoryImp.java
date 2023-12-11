package com.example.SW_PBL.Festival;

import org.springframework.stereotype.Repository;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FstvlRepositoryImp  {
    public Fstvl save(Fstvl fstvlform) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fstvl_db", "root", "xl5ag63723!"
        );
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO fstvls(title, date, location, photo, price, phone, text) values(?, ?, ?, ?, ?, ?, ?)"
        );
        ps.setString(1, fstvlform.getTitle());
        ps.setString(2, fstvlform.getDate());
        ps.setString(3, fstvlform.getLocation());
        ps.setString(4, fstvlform.getPhoto());
        ps.setString(5, fstvlform.getPrice());
        ps.setString(6, fstvlform.getPhone());
        ps.setString(7, fstvlform.getText());

        int status = ps.executeUpdate();
        ps.close();
        conn.close();
        return fstvlform;
    }



    public List<Fstvl> findAll(int length) throws SQLException {
        int leng = length + 1;
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fstvl_db", "root", "xl5ag63723!"
        );
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM fstvls where fstvl_id = ?");
        ResultSet rs = null;
        List<Fstvl> fstvlList = new ArrayList<>();
        for (int id = 1; id < leng; id++) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            Fstvl fstvl = new Fstvl(rs.getInt("fstvl_id"), rs.getString("title"), rs.getString("date"), rs.getString("location"),  rs.getString("photo"),  rs.getString("price"), rs.getString("phone"), rs.getString("text"));
            fstvlList.add(fstvl);
        }
        rs.close();
        ps.close();
        conn.close();

        return fstvlList;
    }


    public Fstvl findById(int fstvl_id) throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fstvl_db", "root", "xl5ag63723!"
        );
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM fstvls where fstvl_id = ?");
        ps.setInt(1, fstvl_id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Fstvl fstvl = new Fstvl(rs.getInt("fstvl_id"), rs.getString("title"), rs.getString("date"), rs.getString("location"),  rs.getString("photo"),  rs.getString("price"), rs.getString("phone"), rs.getString("text"));
        rs.close();
        ps.close();
        conn.close();

        return fstvl;
    }


    public Fstvl findByTitle(String title) throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fstvl_db", "root", "xl5ag63723!"
        );
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM fstvls where title = ?");
        ps.setString(1, title);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Fstvl fstvl = new Fstvl(rs.getInt("fstvl_id"), rs.getString("title"), rs.getString("date"), rs.getString("location"),  rs.getString("photo"),  rs.getString("price"), rs.getString("phone"), rs.getString("text"));
        rs.close();
        ps.close();
        conn.close();

        return fstvl;
    }

    public void clearStore() throws SQLException{
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/fstvl_db", "root", "xl5ag63723!"
        );
        PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE fstvls");
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

}
