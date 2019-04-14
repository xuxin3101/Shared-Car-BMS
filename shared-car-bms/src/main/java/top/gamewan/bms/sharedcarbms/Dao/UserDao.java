package top.gamewan.bms.sharedcarbms.Dao;

import top.gamewan.bms.sharedcarbms.Bean.UserInfo;

public interface UserDao {
   UserInfo getUserInfo(String username,String password);
   String setToken(String username);
}
