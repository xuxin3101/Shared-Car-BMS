package top.gamewan.bms.sharedcarbms.Dao;

import org.springframework.transaction.annotation.Transactional;
import top.gamewan.bms.sharedcarbms.Bean.UserInfo;

public interface UserDao {
   UserInfo getUserInfo(String username,String password);
   String setToken(String username);

   /**
    *
    * @param u
    * @param p
    * @param email
    * @return 1代表成功,3代表往user表插入失败,4代表往login插入失败
    */
   @Transactional
   int insertUser(String u,String p,String email);
}
