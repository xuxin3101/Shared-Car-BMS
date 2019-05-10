package top.gamewan.bms.sharedcarbms.Dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import top.gamewan.bms.sharedcarbms.Bean.CarInfo;
import top.gamewan.bms.sharedcarbms.Dao.CarDao;

import java.util.List;

@Component
public class CarDaoImpl implements CarDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int getCarCount() {
        String sql="select count(*) from car";
        int result=0;
        try{
            result=jdbcTemplate.queryForObject(sql,Integer.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<CarInfo> getLeaseCars(int page, int count) {
        int start=(page-1)*count;
       String sql="select * from car where lease=1 limit ?,?";
       List<CarInfo> carInfos=null;
       try {
           carInfos=jdbcTemplate.query(sql, new Object[]{start, count}, new BeanPropertyRowMapper<CarInfo>(CarInfo.class));
       }catch (Exception e){
           e.printStackTrace();
       }
       return carInfos;
    }

    @Override
    public List<CarInfo> getUnLeaseCars(int page, int count) {
        int start=(page-1)*count;
        String sql="select * from car where lease=2 limit ?,?";
        List<CarInfo> carInfos=null;
        try {
            carInfos=jdbcTemplate.query(sql, new Object[]{start, count}, new BeanPropertyRowMapper<CarInfo>(CarInfo.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return carInfos;
    }

    @Override
    public boolean insertCar(CarInfo carInfo) {
        String sql="insert into car values(null,?,?,?,?,?,?,?,?,?)";
        return
        jdbcTemplate.update(sql,new Object[]{carInfo.getNumberplate(),
        carInfo.getModel(),carInfo.getColor(),carInfo.getStatus(),
        carInfo.getEndurancemail(),carInfo.getStatustime(),
        carInfo.getParkplace(),carInfo.getParkmoney(),carInfo.getLease()})==1?true:false;
    }

    @Override
    public boolean deleteCar(Integer id) {
        String sql="delete from car where id =?";
        return
        jdbcTemplate.update(sql,new Object[]{id})==1?true:false;
    }

    @Override
    public int getLeaseCarCount() {
        String sql="select count(*) from car where lease=1";
        int result=0;
        try{
            result=jdbcTemplate.queryForObject(sql,Integer.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getUnLeaseCarCount() {
        String sql="select count(*) from car where lease=0";
        int result=0;
        try{
            result=jdbcTemplate.queryForObject(sql,Integer.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
