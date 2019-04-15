package top.gamewan.bms.sharedcarbms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.gamewan.bms.sharedcarbms.Bean.ReturnMsg;
import top.gamewan.bms.sharedcarbms.Services.MailServices;
import top.gamewan.bms.sharedcarbms.utils.VerificationUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api")
public class MailController {
    @Autowired
    private VerificationUtil verificationUtil;
    @Autowired
    private MailServices mailServices;
    @RequestMapping(method = RequestMethod.POST,value = "sendregistermail")
    public ReturnMsg sendRegisterMail(HttpServletRequest request){
        Map<String,String> map=VerificationUtil.requestToMap(request);
        if(!verificationUtil.checkSign(map)){
            return new ReturnMsg("sign验证失败",1001);
        }
        String toAddress=request.getParameter("toAddress");
        if(mailServices.sendRegisterMail(toAddress))
            return new ReturnMsg("发送成功",1000);
        else
            return new ReturnMsg("发送失败",1005);

    }

}
