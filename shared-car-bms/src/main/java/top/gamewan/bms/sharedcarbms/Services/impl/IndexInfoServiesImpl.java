package top.gamewan.bms.sharedcarbms.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.gamewan.bms.sharedcarbms.Bean.IndexInfo;
import top.gamewan.bms.sharedcarbms.Dao.CarDao;
import top.gamewan.bms.sharedcarbms.Dao.UserDao;
import top.gamewan.bms.sharedcarbms.Services.IndexInfoServices;
@Component
public class IndexInfoServiesImpl implements IndexInfoServices {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CarDao carDao;
    @Override
    public IndexInfo getIndexInfo() {
        IndexInfo indexInfo=new IndexInfo();
        indexInfo.setCarCount(carDao.getCarCount());
        indexInfo.setUserCount(userDao.getUserCount());
        return indexInfo;
    }
}
