package top.gamewan.bms.sharedcarbms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.gamewan.bms.sharedcarbms.Bean.LoginReturnMsg;
import top.gamewan.bms.sharedcarbms.Bean.ReturnMsg;
import top.gamewan.bms.sharedcarbms.Bean.UserInfo;
import top.gamewan.bms.sharedcarbms.Services.UserServices;
import top.gamewan.bms.sharedcarbms.utils.VerificationUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    VerificationUtil verificationUtil;
    @Autowired
    UserServices userServices;
    @RequestMapping(method = RequestMethod.POST,value = "login")
    public ReturnMsg login(HttpServletRequest request){
       Map<String,String> map=VerificationUtil.requestToMap(request);
       if(!verificationUtil.checkSign(map)){
           return new LoginReturnMsg("sign验证失败",1001,null);
       }
      UserInfo userInfo= userServices.userLogin(map.get("username"),map.get("password"));
       if(userInfo!=null)
       return new LoginReturnMsg("登录成功",1000,userInfo);
       else
           return new LoginReturnMsg("账号或密码错误",1002,null);
    }
}
