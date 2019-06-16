package top.gamewan.bms.sharedcarbms.Services;

import top.gamewan.bms.sharedcarbms.Bean.WorkOrderInfo;

import java.util.List;

public interface WorkOrderServices {
    int getWorkOrderCount();
    boolean deleteWorkOrder(Integer id);
    List<WorkOrderInfo> getWorkOrders(int page,int count,int type);
    boolean inserWorkOrder(String carnumber,String principal,String status,Integer type);
}
