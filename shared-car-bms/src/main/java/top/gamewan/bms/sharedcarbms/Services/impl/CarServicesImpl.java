package top.gamewan.bms.sharedcarbms.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.gamewan.bms.sharedcarbms.Bean.CarInfo;
import top.gamewan.bms.sharedcarbms.Dao.CarDao;
import top.gamewan.bms.sharedcarbms.Services.CarServices;

import java.util.List;

@Component
public class CarServicesImpl implements CarServices {
    @Autowired
    private CarDao carDao;
    @Override
    public List<CarInfo> getLeaseCar(int page, int count) {
        return carDao.getLeaseCars(page, count);
    }

    @Override
    public List<CarInfo> getUnLeaseCar(int page, int count) {
        return carDao.getUnLeaseCars(page,count);
    }

    @Override
    public boolean insertCar(String numberplate, String model, String color, String status, Integer endurancemail, Integer statustime, String parkplace, Integer parkmoney, Integer lease) {
        if(numberplate==null||numberplate.equals("")||model==null||model.equals("")||color==null||
        color.equals("")||status==null||status.equals("")||endurancemail==null||statustime==null)
            return false;
        CarInfo carInfo=new CarInfo();
        carInfo.setStatustime(statustime);
        carInfo.setParkplace(parkplace);
        carInfo.setParkmoney(parkmoney);
        carInfo.setNumberplate(numberplate);
        carInfo.setModel(model);
        carInfo.setLease(lease);
        carInfo.setEndurancemail(endurancemail);
        carInfo.setColor(color);
        carInfo.setStatus(status);
        return
        carDao.insertCar(carInfo);
    }
    @Override
    public boolean deleteCar(Integer id) {
        return carDao.deleteCar(id);
    }

    @Override
    public int getLeaseCarCount() {
       return carDao.getLeaseCarCount();
    }

    @Override
    public int getUnLeaseCarCount() {
        return carDao.getUnLeaseCarCount();
    }
}
