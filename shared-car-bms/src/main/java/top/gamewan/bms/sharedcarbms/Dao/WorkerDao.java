package top.gamewan.bms.sharedcarbms.Dao;

import top.gamewan.bms.sharedcarbms.Bean.WorkerInfo;

import java.util.List;

public interface WorkerDao {
    boolean insertWorker(WorkerInfo workerInfo);
    boolean deleteWorker(Integer id);
    List<WorkerInfo> getWorkers(int page, int count);
    int getWorkerCount();
}
