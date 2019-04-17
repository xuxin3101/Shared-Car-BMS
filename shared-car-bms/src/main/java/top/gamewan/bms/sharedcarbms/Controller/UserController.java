package top.gamewan.bms.sharedcarbms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.gamewan.bms.sharedcarbms.Bean.LoginReturnMsg;
import top.gamewan.bms.sharedcarbms.Bean.ReturnMsg;
import top.gamewan.bms.sharedcarbms.Bean.UserInfo;
import top.gamewan.bms.sharedcarbms.Bean.UsersReturnMsg;
import top.gamewan.bms.sharedcarbms.Services.UserServices;
import top.gamewan.bms.sharedcarbms.utils.VerificationUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@CrossOrigin
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
    @RequestMapping(method = RequestMethod.POST,value = "register")
    public ReturnMsg register(HttpServletRequest request){
        Map<String,String> map=VerificationUtil.requestToMap(request);
        if(!verificationUtil.checkSign(map)){
            return new ReturnMsg("sign验证失败",1001);
        }
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String mail=request.getParameter("email");
        String code=request.getParameter("code");
        if(username==null||username.equals(""))
            return new ReturnMsg("用户名不能为空",1003);
        else if(password==null || password.equals(""))
            return new ReturnMsg("密码不能为空",1003);
        else if(mail==null || mail.equals(""))
            return new ReturnMsg("邮箱不能为空",1003);
        else if(code ==null || code.equals(""))
            return new ReturnMsg("验证码不能为空",1003);
        int result=userServices.userRegister(username,password,mail,code);
        if(result==1){
            return  new ReturnMsg("注册成功",1000);
        }else if(result==2){
            return  new ReturnMsg("验证码错误",1005);
        }else if(result==3){
            return new ReturnMsg("用户名或者邮箱重复",1005);
        }
        else{
            return new ReturnMsg("注册失败",1005);
        }
    }
    @RequestMapping(method = RequestMethod.POST,value = "getusers")
    public UsersReturnMsg getusers(HttpServletRequest request){
        Map<String,String> map=VerificationUtil.requestToMap(request);
        if(!verificationUtil.checkSign(map)){
            return new UsersReturnMsg("sign验证失败",1001,null);
        }
        String username=request.getParameter("username");
        String token=request.getParameter("token");
        if(!userServices.userTokenCheck(username,token)){
            return new UsersReturnMsg("token验证失败",1002,null);
        }
        int page=Integer.parseInt(request.getParameter("page"));
        int count=Integer.parseInt(request.getParameter("count"));
        return new UsersReturnMsg("获取成功",1000, userServices.getUsers(page,count));

    }
}
