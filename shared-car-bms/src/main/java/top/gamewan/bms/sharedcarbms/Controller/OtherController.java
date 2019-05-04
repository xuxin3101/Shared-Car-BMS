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
import java.util.ArrayList;
import java.util.List;
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
            return new IndexInfoReturnMsg("sign验证失败",1001,null,null,null);
        }
        String token=request.getParameter("token");
        String username=request.getParameter("username");
        if(!userServices.userTokenCheck(username,token)){
            return new IndexInfoReturnMsg("token验证失败",1002,null,null,null);
        }
        List<Integer> excepted=new ArrayList<>();
        List<Integer> actual=new ArrayList<>();
        excepted.add(820);
        excepted.add(932);
        excepted.add(901);
        excepted.add(934);
        excepted.add(1690);
        excepted.add(830);
        excepted.add(1120);
        actual.add(620);
        actual.add(532);
        actual.add(901);
        actual.add(1290);
        actual.add(1330);
        actual.add(1320);
        actual.add(820);
        return new IndexInfoReturnMsg("获取成功",1000,indexInfoServices.getIndexInfo(),excepted,actual);
    }
}
