package top.gamewan.bms.sharedcarbms.Dao;

import top.gamewan.bms.sharedcarbms.Bean.WorkOrderInfo;

import java.util.List;

public interface WorkOrderDao {
    int getWorkOrderCount();
    boolean insertWorkOrder(WorkOrderInfo workOrderInfo);
    boolean deleteWorkOrder(Integer id);
    List<WorkOrderInfo> getWorkOrders(int page,int count,int type);

}
