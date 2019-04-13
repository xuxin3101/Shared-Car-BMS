package top.gamewan.bms.sharedcarbms.Bean;



public class LoginReturnMsg extends ReturnMsg {
    UserInfo userInfo;

    public LoginReturnMsg(String msg, int code) {
        super(msg, code);
    }
    public LoginReturnMsg(String msg, int code, UserInfo userInfo){
        super(msg,code);
        this.userInfo=userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}
