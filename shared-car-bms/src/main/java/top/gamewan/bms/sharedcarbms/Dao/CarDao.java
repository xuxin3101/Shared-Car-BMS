package top.gamewan.bms.sharedcarbms.Dao;

import top.gamewan.bms.sharedcarbms.Bean.CarInfo;

import java.util.List;

public interface CarDao {
    int getCarCount();
    List<CarInfo> getLeaseCars(int page,int count);
    List<CarInfo> getUnLeaseCars(int page,int count);
    boolean insertCar(CarInfo carInfo);
    boolean deleteCar(Integer id);
    int getLeaseCarCount();
    int getUnLeaseCarCount();

}
