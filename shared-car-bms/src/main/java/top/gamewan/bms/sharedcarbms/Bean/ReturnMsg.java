package top.gamewan.bms.sharedcarbms.Bean;

public class ReturnMsg {
    private String msg;
    private int code;
    public ReturnMsg(String msg,int code){
        this.msg=msg;
        this.code=code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
