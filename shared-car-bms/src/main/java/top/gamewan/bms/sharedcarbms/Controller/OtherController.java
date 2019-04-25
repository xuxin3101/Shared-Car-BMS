package top.gamewan.bms.sharedcarbms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.gamewan.bms.sharedcarbms.Bean.IndexInfoReturnMsg;
import top.gamewan.bms.sharedcarbms.Services.IndexInfoServices;
import top.gamewan.bms.sharedcarbms.Services.UserServices;
import top.gamewan.bms.sharedcarbms.utils.VerificationUtil;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api")
public class OtherController {
    @Autowired
    VerificationUtil verificationUtil;
    @Autowired
    private IndexInfoServices indexInfoServices;
    @Autowired
    private UserServices userServices;
    @RequestMapping(method = RequestMethod.POST,value="getindexinfo")
    public IndexInfoReturnMsg getIndexInfo(HttpServletRequest request){
        Map<String,String> map=VerificationUtil.requestToMap(request);
        if(!verificationUtil.checkSign(map)){
            return new IndexInfoReturnMsg("sign验证失败",1001,null);
        }
        String token=request.getParameter("token");
        String username=request.getParameter("username");
        if(!userServices.userTokenCheck(username,token)){
            return new IndexInfoReturnMsg("token验证失败",1002,null);
        }
        return new IndexInfoReturnMsg("获取成功",1000,indexInfoServices.getIndexInfo());
    }
}
