package top.gamewan.bms.sharedcarbms.Dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import top.gamewan.bms.sharedcarbms.Bean.WorkerInfo;
import top.gamewan.bms.sharedcarbms.Dao.WorkerDao;

import java.util.List;

@Component
public class WorkerDaoImpl implements WorkerDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public boolean insertWorker(WorkerInfo workerInfo) {
        String sql="insert into worker values(null,?,?,?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{workerInfo.getName(),workerInfo.getIdcard()
        ,workerInfo.getPhone(),workerInfo.getStatus(),workerInfo.getPermission()})==1?true:false;
    }

    @Override
    public boolean deleteWorker(Integer id) {
        String sql="delete from worker where id=?";
        return jdbcTemplate.update(sql,new Object[]{id})==1?true:false;
    }

    @Override
    public List<WorkerInfo> getWorkers(int page, int count) {
        int start=(page-1)*count;
        String sql="select * from worker limit ?,?";
        List<WorkerInfo> workerInfos=null;
        try{
            jdbcTemplate.query(sql,new Object[]{start,count},new BeanPropertyRowMapper<WorkerInfo>(WorkerInfo.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return workerInfos;
    }

    @Override
    public int getWorkerCount() {
        String sql="select count(*) c from works";
        Integer count=
                jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }
}
