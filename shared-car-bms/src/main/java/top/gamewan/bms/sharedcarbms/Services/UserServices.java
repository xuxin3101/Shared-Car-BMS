package top.gamewan.bms.sharedcarbms.Services;

import top.gamewan.bms.sharedcarbms.Bean.UserInfo;

public interface UserServices {
    UserInfo userLogin(String u, String p);

    /**
     *
     * @param u 用户名
     * @param p 密码
     * @param mail 邮箱
     * @param code 邮箱验证码
     * @return 1为成功 2位验证码验证错误,3代表往user表插入失败,4代表往login插入失败
     */
    int userRegister(String u,String p,String mail,String code);

}
