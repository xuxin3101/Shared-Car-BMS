package top.gamewan.bms.sharedcarbms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.gamewan.bms.sharedcarbms.Bean.CarInfoReturnMsg;
import top.gamewan.bms.sharedcarbms.Bean.ReturnMsg;
import top.gamewan.bms.sharedcarbms.Services.CarServices;
import top.gamewan.bms.sharedcarbms.utils.VerificationUtil;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("api")
public class CarController {
    @Autowired
    VerificationUtil verificationUtil;
    @Autowired
    private CarServices carServices;
    @RequestMapping(value="getcars",method = RequestMethod.POST)
    public ReturnMsg getcars(HttpServletRequest request){
        int resultcode=
                verificationUtil.checkSignAndToken(request);
        if (resultcode == 1001) {
            return new ReturnMsg("sign验证失败", 1001);
        } else if (resultcode == 1002) {
            return new ReturnMsg("token验证失败", 1002);
        } else {
            String type=request.getParameter("type");
            int page=Integer.parseInt(request.getParameter("page"));
            int count =Integer.parseInt(request.getParameter("count"));
            if (type.equals("1")){
                return  new CarInfoReturnMsg("获取成功",1000,carServices.getLeaseCarCount()
                ,carServices.getLeaseCar(page,count));

            }else if(type.equals("2")){
                return  new CarInfoReturnMsg("获取成功",1000,carServices.getUnLeaseCarCount()
                        ,carServices.getUnLeaseCar(page,count));
            }else{
                return new ReturnMsg("非法输入", 1004);
            }
        }

    }
    @RequestMapping(value = "insertcar",method = RequestMethod.POST)
    public ReturnMsg inserCar(HttpServletRequest request){
        int resultcode=
                verificationUtil.checkSignAndToken(request);
        if (resultcode == 1001) {
            return new ReturnMsg("sign验证失败", 1001);
        } else if (resultcode == 1002) {
            return new ReturnMsg("token验证失败", 1002);
        } else {
            String numberplate=request.getParameter("numberplate");
            String model=request.getParameter("model");
            String color=request.getParameter("color");
            String status=request.getParameter("status");
            int endurancemail=Integer.parseInt(request.getParameter("endurancemail"));
            int statustime=Integer.parseInt(request.getParameter("statustime"));
            String parkplace=request.getParameter("parkplace");
            int parkmoney=Integer.parseInt(request.getParameter("parkmoney"));
            int lease=Integer.parseInt(request.getParameter("lease"));
            if(carServices.insertCar(numberplate,model,color,status,endurancemail,statustime,parkplace,parkmoney,lease)){
                return new ReturnMsg("插入成功",1000);
            }else{
                return new ReturnMsg("插入失败",1005);
            }

        }
    }
    @RequestMapping(value = "deletecar",method = RequestMethod.POST)
    public ReturnMsg delete(HttpServletRequest request){
        int resultcode=
                verificationUtil.checkSignAndToken(request);
        if (resultcode == 1001) {
            return new ReturnMsg("sign验证失败", 1001);
        } else if (resultcode == 1002) {
            return new ReturnMsg("token验证失败", 1002);
        } else {
            int id=Integer.parseInt(request.getParameter("id"));
            if(carServices.deleteCar(id)){
                return new ReturnMsg("删除成功",1000);
            }else{
                return new ReturnMsg("删除失败",1005);
            }
        }
    }
}
