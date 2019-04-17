package top.gamewan.bms.sharedcarbms.Bean;


import java.util.List;

public class UsersReturnMsg extends ReturnMsg {
    private List<UserInfo> userInfos;
    public UsersReturnMsg(String msg, int code) {
        super(msg, code);
    }
    public UsersReturnMsg(String msg,int code,List<UserInfo> userInfos){
        super(msg, code);
        this.userInfos=userInfos;
    }

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }
}
