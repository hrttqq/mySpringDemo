package com.hrf.demo.jdbc.dao;

import com.hrf.demo.damain.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class UserInfoDao {
    private static final Logger log = LoggerFactory.getLogger(UserInfoDao.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 写入数据库操作
     * @param userInfo
     */

    @Transactional
    public void insertUserInfo(UserInfo userInfo) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("insert into user_info (id,user_name,user_id,age,phone) values(?,?,?,?,?)");
            List<Object> parms = new LinkedList<>();
            parms.add(userInfo.getId());
            parms.add(userInfo.getUserName());
            parms.add(userInfo.getUserId());
            parms.add(userInfo.getAge());
            parms.add(userInfo.getPhone());
            jdbcTemplate.update(sb.toString(), parms.toArray());
        } catch (Exception e) {
            log.error("UserInfoDaoImpl insert error!", e);
        }
    }

    /**
     * 读取数据库操作
     * @param userId
     * @return
     */
    public UserInfo queryUserInfo(String userId) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from user_info where user_id = ?");
        LinkedList<Object> parms = new LinkedList<>();
        parms.add(userId);
        UserInfo userInfo = null;
        try {
            userInfo = jdbcTemplate.queryForObject(sb.toString(), parms.toArray(), new RowMapper<UserInfo>() {
                @Override
                public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return process(rs, rowNum);
                }
            });
        } catch (Exception e) {
            log.error("UserInfoDaoImpl queryUserInfo error", e);
        }
        return userInfo;
    }

    public UserInfo process(ResultSet rs, int rowNum) throws SQLException {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(rs.getInt("id"));
        userInfo.setUserName(rs.getString("user_id"));
        userInfo.setAge(rs.getInt("age"));
        userInfo.setPhone(rs.getLong("phone"));
        userInfo.setUserId(rs.getString("user_id"));
        return userInfo;
    }
}
