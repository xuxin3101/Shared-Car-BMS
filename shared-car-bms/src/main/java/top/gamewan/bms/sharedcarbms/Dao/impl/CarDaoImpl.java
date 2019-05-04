package top.gamewan.bms.sharedcarbms.Dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import top.gamewan.bms.sharedcarbms.Dao.CarDao;
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
}
