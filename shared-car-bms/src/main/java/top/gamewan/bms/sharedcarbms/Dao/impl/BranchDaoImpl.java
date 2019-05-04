package top.gamewan.bms.sharedcarbms.Dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import top.gamewan.bms.sharedcarbms.Bean.BranchInfo;
import top.gamewan.bms.sharedcarbms.Dao.BranchDao;


import java.util.List;
@Component
public class BranchDaoImpl implements BranchDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<BranchInfo> getBranchs(int page, int count) {
        int start=(page-1)*count;
        String sql="select * from branch limit ?,?";
        List<BranchInfo> branchInfos=null;
        try{
            branchInfos=jdbcTemplate.query(sql,new Object[]{start,count},new BeanPropertyRowMapper<BranchInfo>(BranchInfo.class));
        }catch(Exception e){
            e.printStackTrace();
        }
        return branchInfos;
    }

    @Override
    public boolean insertBranchs(BranchInfo branchInfo) {
       String sql="insert into branch values(null,?,?,?,?,?)";
       int reslut=
       jdbcTemplate.update(sql,new Object[]{branchInfo.getName(),branchInfo.getType(),branchInfo.getPlace()
       ,branchInfo.getCount(),branchInfo.getFlow()});
       return reslut==1?true:false;
    }

    @Override
    public boolean deleteBranch(int id) {
        String sql="delete from branch where id=?";
        int result=
                jdbcTemplate.update(sql,new Object[]{id});
        return result==1?true:false;
    }

    @Override
    public int getBranchCount() {
        String sql="select count(*) c from branch";
        Integer count=
        jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }

    @Override
    public boolean editBranch(int id, String name, String type, String place, int count, int flow) {
        String sql="update branch set name=?,type=?,place=?,count=?,flow=? where id=?";
        return jdbcTemplate.update(sql,new Object[]{name,type,place,count,flow,id})==1?true:false;
    }
}
