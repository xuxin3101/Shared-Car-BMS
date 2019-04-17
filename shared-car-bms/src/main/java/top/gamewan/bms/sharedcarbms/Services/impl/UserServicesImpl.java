package top.gamewan.bms.sharedcarbms.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.gamewan.bms.sharedcarbms.Bean.UserInfo;
import top.gamewan.bms.sharedcarbms.Dao.MailDao;
import top.gamewan.bms.sharedcarbms.Dao.UserDao;
import top.gamewan.bms.sharedcarbms.Services.UserServices;

import java.util.List;

@Component
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserDao userDao;
    @Autowired
    private MailDao mailDao;
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

    @Override
    public int userRegister(String u, String p, String mail, String code) {
        if(!mailDao.checkCode(mail,code))
            return 2;
        //邮箱验证成功
        return userDao.insertUser(u,p,mail);
    }

    @Override
    public boolean userTokenCheck(String username, String token) {
        String realtoken=userDao.getToken(username);
        if(realtoken!=null && realtoken.equals(token))
            return true;
        else
            return false;

    }

    @Override
    public List<UserInfo> getUsers(int page, int count) {
        return userDao.getUsers(page,count);
    }
}
