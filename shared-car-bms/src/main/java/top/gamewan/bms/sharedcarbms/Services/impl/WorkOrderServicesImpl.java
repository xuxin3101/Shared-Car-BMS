package top.gamewan.bms.sharedcarbms.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.gamewan.bms.sharedcarbms.Bean.WorkOrderInfo;
import top.gamewan.bms.sharedcarbms.Dao.WorkOrderDao;
import top.gamewan.bms.sharedcarbms.Services.WorkOrderServices;

import java.util.List;

@Component
public class WorkOrderServicesImpl implements WorkOrderServices {
    @Autowired
    private WorkOrderDao workOrderDao;
    @Override
    public int getWorkOrderCount() {
        return workOrderDao.getWorkOrderCount();
    }

    @Override
    public boolean deleteWorkOrder(Integer id) {
        if(id==null)
            return false;
        return workOrderDao.deleteWorkOrder(id);
    }

    @Override
    public List<WorkOrderInfo> getWorkOrders(int page, int count, int type) {
        return workOrderDao.getWorkOrders(page, count, type);
    }

    @Override
    public boolean inserWorkOrder(String carnumber, String principal, String status, Integer type) {
        if(carnumber==null||carnumber.equals("")||
        status==null||status.equals("")||type==null||type.equals("")){
            return false;
        }
        WorkOrderInfo workOrderInfo=new WorkOrderInfo();
        workOrderInfo.setType(type);
        workOrderInfo.setStatus(status);
        workOrderInfo.setPrincipal(principal);
        workOrderInfo.setCarnumber(carnumber);
        return
        workOrderDao.insertWorkOrder(workOrderInfo);
    }
}
