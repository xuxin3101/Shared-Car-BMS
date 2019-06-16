package top.gamewan.bms.sharedcarbms.Bean;

import java.util.List;

public class WorkOrderInfoReturnMsg extends ReturnMsg {
    public WorkOrderInfoReturnMsg(String msg, int code) {
        super(msg, code);
    }
    private Integer workOrderCount;

    public Integer getWorkOrderCount() {
        return workOrderCount;
    }

    public void setWorkOrderCount(Integer workOrderCount) {
        this.workOrderCount = workOrderCount;
    }

    public List<WorkOrderInfo> getWorkOrderInfos() {
        return workOrderInfos;
    }

    public WorkOrderInfoReturnMsg(String msg, int code, Integer workOrderCount, List<WorkOrderInfo> workOrderInfos) {
        super(msg, code);
        this.workOrderCount = workOrderCount;
        this.workOrderInfos = workOrderInfos;
    }

    public void setWorkOrderInfos(List<WorkOrderInfo> workOrderInfos) {
        this.workOrderInfos = workOrderInfos;
    }

    private List<WorkOrderInfo> workOrderInfos;

}
