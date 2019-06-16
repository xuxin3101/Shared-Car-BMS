package top.gamewan.bms.sharedcarbms.Services;

import top.gamewan.bms.sharedcarbms.Bean.WorkerInfo;

import java.util.List;

public interface WorkServices {
    List<WorkerInfo> getWorkers(int page,int count);
    boolean insertWorkers(String name,String idcard,String phone,String status,String permission);
    boolean deleteWorker(Integer id);
    int getWorkersCount();
}
