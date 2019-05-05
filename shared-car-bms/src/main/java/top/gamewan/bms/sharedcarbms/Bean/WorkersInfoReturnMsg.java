package top.gamewan.bms.sharedcarbms.Bean;

import java.util.List;

public class WorkersInfoReturnMsg extends ReturnMsg {
    public WorkersInfoReturnMsg(String msg, int code) {
        super(msg, code);
    }
    private List<WorkerInfo> workerInfos;

    public WorkersInfoReturnMsg(String msg, int code, List<WorkerInfo> workerInfos, int workerscount) {
        super(msg, code);
        this.workerInfos = workerInfos;
        this.workerscount = workerscount;
    }

    private int workerscount;

    public List<WorkerInfo> getWorkerInfos() {
        return workerInfos;
    }

    public void setWorkerInfos(List<WorkerInfo> workerInfos) {
        this.workerInfos = workerInfos;
    }

    public int getWorkerscount() {
        return workerscount;
    }

    public void setWorkerscount(int workerscount) {
        this.workerscount = workerscount;
    }
}
