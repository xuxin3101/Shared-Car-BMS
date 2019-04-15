package top.gamewan.bms.sharedcarbms.Dao.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import top.gamewan.bms.sharedcarbms.Bean.UserInfo;
import top.gamewan.bms.sharedcarbms.Dao.UserDao;
@Component
public class UserDaoImpl implements UserDao
{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public UserInfo getUserInfo(String username,String password) {
        String sql="select username from user where username=? and password=?";
        UserInfo userInfo;
        try{
           userInfo=(UserInfo)jdbcTemplate.queryForObject(sql,new Object[]{username,password},new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
        }catch (Exception e){
            System.out.println( e.getMessage());
            return null;
        }
        return userInfo;
    }
    @Override
    public String setToken(String username) {
        String token= RandomStringUtils.randomAlphabetic(32);
        String sql="update login set token =? where username=?";
        if(jdbcTemplate.update(sql,new Object[]{token,username})==1)
            return token;
        else
            return null;
    }

    @Override
    public int insertUser(String u, String p, String email) {
        //往user表里插
        String sql="insert into user(id,username,password,email)" +
                " values(null,?,?,?)";
        try{
            if(jdbcTemplate.update(sql,new Object[]{u,p,email})!=1)
                throw new Exception();
        }catch (DataAccessException e){
            e.printStackTrace();
            return 2;
        }catch (Exception e){
            e.printStackTrace();
            return 2;
        }
        sql="insert into login(id,username) values(null,?)";
        try{
            if(jdbcTemplate.update(sql,new Object[]{u})!=1)
                throw new Exception();
        }catch (DataAccessException e){
            e.printStackTrace();
            return 3;
        }catch (Exception e){
            e.printStackTrace();
            return 3;
        }
        return 1;
    }
}
