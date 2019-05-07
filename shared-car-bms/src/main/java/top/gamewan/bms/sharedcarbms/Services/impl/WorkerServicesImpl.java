package top.gamewan.bms.sharedcarbms.Services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.gamewan.bms.sharedcarbms.Bean.WorkerInfo;
import top.gamewan.bms.sharedcarbms.Dao.WorkerDao;
import top.gamewan.bms.sharedcarbms.Services.WorkServices;

import java.util.List;
@Component
public class WorkerServicesImpl implements WorkServices {
    @Autowired
    private WorkerDao workerDao;
    @Override
    public List<WorkerInfo> getWorkers(int page, int count) {
        return workerDao.getWorkers(page,count);
    }
    @Override
    public boolean insertWorkers(String name, String idcard, String phone, String status, String permission) {
        if(name==null||name.equals("")||permission==null ||permission.equals(""))
            return false;
        WorkerInfo workerInfo=new WorkerInfo();
        workerInfo.setIdcard(idcard);
        workerInfo.setName(name);
        workerInfo.setPermission(permission);
        workerInfo.setPhone(phone);
        workerInfo.setStatus(status);
        return workerDao.insertWorker(workerInfo);
    }
    @Override
    public boolean deleteWorker(Integer id) {
        if(id==null)
            return false;
       return workerDao.deleteWorker(id);
    }

    @Override
    public int getWorkersCount() {
       return workerDao.getWorkerCount();
    }
}
