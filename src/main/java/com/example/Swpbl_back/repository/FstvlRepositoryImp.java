package com.example.Swpbl_back.repository;
import com.example.Swpbl_back.domain.Fstvl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.text.SimpleDateFormat;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
public class FstvlRepositoryImp  {
    private final JdbcTemplate jdbcTemplate;


    public FstvlRepositoryImp(DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //create

    public Fstvl save(Fstvl fstvlform) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("fstvl").usingGeneratedKeyColumns("fstvl_id");
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("title", fstvlform.getTitle());
        parameters.put("date", fstvlform.getDate());
        parameters.put("location", fstvlform.getLocation());
        parameters.put("photo", fstvlform.getPhoto());
       // parameters.put("price", fstvlform.getPrice());
        //parameters.put("phone", fstvlform.getPhone());
        //parameters.put("text", fstvlform.getText());
        //parameters.put("fstvl_keyword", fstvlform.getFstvl_keyword());
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        //fstvlform.setFstvl_id(key.intValue());

        return fstvlform;
    }



    public List<Fstvl> findAll() {

        return jdbcTemplate.query("select * from Fstvl", fstvlRowMapper());
    }


    public Fstvl findById(Long id){
        return jdbcTemplate.queryForObject("select * from Fstvl where fstvl_id=?", fstvlRowMapper(), id);
    }

    //데이터베이스의 값을 객체로 만들어 주는것
    private RowMapper<Fstvl> fstvlRowMapper() {
        return (rs, rowNum) -> {
            Fstvl fstvl = new Fstvl();
            //fstvl.setFstvl_id(rs.getInt("fstvl_id"));
            fstvl.setTitle(rs.getString("title"));
            fstvl.setDate(rs.getString("date"));
            fstvl.setLocation(rs.getString("location"));
            fstvl.setPhoto(rs.getString("photo"));
           // fstvl.setPrice(rs.getString("price"));
            //fstvl.setPhone(rs.getString("phone"));
            //fstvl.setText(rs.getString("text"));
            //fstvl.setText(rs.getString("fstvl_keyword"));

            return fstvl;
        };

    }
}
