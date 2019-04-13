package top.gamewan.bms.sharedcarbms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.gamewan.bms.sharedcarbms.Bean.LoginReturnMsg;
import top.gamewan.bms.sharedcarbms.Bean.ReturnMsg;
import top.gamewan.bms.sharedcarbms.Bean.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(method = RequestMethod.POST,value = "login")

    public ReturnMsg login(HttpServletRequest request){
        String username=request.getParameter("username");
        if(username!=null && !username.equals(""))
        return new LoginReturnMsg("登录成功",1000,null);
        else
            return new LoginReturnMsg("登录失败",1001,null);
    }
}
