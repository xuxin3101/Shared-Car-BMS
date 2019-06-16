package top.gamewan.bms.sharedcarbms.Dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import top.gamewan.bms.sharedcarbms.Bean.WorkOrderInfo;
import top.gamewan.bms.sharedcarbms.Dao.WorkOrderDao;

import java.util.List;
@Component
public class WorkOrderDaoImpl implements WorkOrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int getWorkOrderCount() {
        String sql="select count(*) from workorder";
        return
        jdbcTemplate.queryForObject(sql,Integer.class);
    }

    @Override
    public boolean insertWorkOrder(WorkOrderInfo workOrderInfo) {
        String sql="insert into workorder values(null,?,?,now(),?,?)";
        return
        jdbcTemplate.update(sql,new Object[]{workOrderInfo.getCarnumber(),
        workOrderInfo.getPrincipal(),
        workOrderInfo.getStatus(),workOrderInfo.getType()})==1?true:false;

    }

    @Override
    public boolean deleteWorkOrder(Integer id) {
        String sql="delete from workorder where id=?";
        return
        jdbcTemplate.update(sql,new Object[]{id})==1?true:false;
    }

    @Override
    public List<WorkOrderInfo> getWorkOrders(int page, int count,int type) {
        int start=(page-1)*count;
        String sql="select * from workorder where type=? limit ?,?";
        return
        jdbcTemplate.query(sql,new Object[]{type,start,count},new BeanPropertyRowMapper<WorkOrderInfo>(WorkOrderInfo.class));
    }
}
