package top.gamewan.bms.sharedcarbms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.gamewan.bms.sharedcarbms.Bean.ReturnMsg;
import top.gamewan.bms.sharedcarbms.Bean.WorkersInfoReturnMsg;
import top.gamewan.bms.sharedcarbms.Services.WorkServices;
import top.gamewan.bms.sharedcarbms.utils.VerificationUtil;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("api")
public class WorkController {
    @Autowired
    VerificationUtil verificationUtil;
    @Autowired
    private WorkServices workServices;
    @RequestMapping(value = "getworkers",method = RequestMethod.POST)
    public ReturnMsg getworkers(HttpServletRequest request){
        int resultcode=
        verificationUtil.checkSignAndToken(request);
        if (resultcode == 1001) {
            return new ReturnMsg("sign验证失败", 1001);
        } else if (resultcode == 1002) {
            return new ReturnMsg("token验证失败", 1002);
        } else {
            int page=Integer.parseInt(request.getParameter("page"));
            int count=Integer.parseInt(request.getParameter("count"));
            return new WorkersInfoReturnMsg("获取成功",1000, workServices.
                    getWorkers(page,count),workServices.getWorkersCount());
        }
    }
    @RequestMapping(value = "insertworker",method = RequestMethod.POST)
    public  ReturnMsg insertWork(HttpServletRequest request){
        int resultcode=
                verificationUtil.checkSignAndToken(request);
        if (resultcode == 1001) {
            return new ReturnMsg("sign验证失败", 1001);
        } else if (resultcode == 1002) {
            return new ReturnMsg("token验证失败", 1002);
        } else {
            String name=request.getParameter("name");
            String idcard=request.getParameter("idcard");
            String phone=request.getParameter("phone");
            String status=request.getParameter("status");
            String permission=request.getParameter("permission");
            if(workServices.insertWorkers(name,idcard,phone,status,permission))
                return new ReturnMsg("插入成功",1000);
            else{
                return new ReturnMsg("插入失败",1005);
            }

        }
    }
    @RequestMapping(value = "deleteworker",method = RequestMethod.POST)
    public ReturnMsg deleteWork(HttpServletRequest request){
        int resultcode=
                verificationUtil.checkSignAndToken(request);
        if (resultcode == 1001) {
            return new ReturnMsg("sign验证失败", 1001);
        } else if (resultcode == 1002) {
            return new ReturnMsg("token验证失败", 1002);
        } else {
            if(  workServices.deleteWorker(Integer.parseInt(request.getParameter("id"))))
                return new ReturnMsg("删除成功",1000);
            else
                return new ReturnMsg("删除失败",1005);
        }
    }

}
