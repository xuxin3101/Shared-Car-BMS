package top.gamewan.bms.sharedcarbms.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.gamewan.bms.sharedcarbms.Bean.UserInfo;
import top.gamewan.bms.sharedcarbms.Dao.UserDao;
import top.gamewan.bms.sharedcarbms.Services.UserServices;
@Component
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserDao userDao;
    @Override
    public UserInfo userLogin(String u, String p) {
        UserInfo userInfo=userDao.getUserInfo(u,p);
        String token=userDao.setToken(u);
        if(userInfo!=null && token!=null) {
            userInfo.setToken(token);
            return userInfo;
        }
        else
            return null;
    }
}
