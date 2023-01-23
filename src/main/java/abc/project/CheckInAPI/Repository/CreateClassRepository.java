package abc.project.CheckInAPI.Repository;

import abc.project.CheckInAPI.Repository.Dao.CreateClassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CreateClassRepository implements CreateClassDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public long checkClassCod(String code) {
        String sql = "select count(*) from 課程 where 代號=?;";
        long c = jdbcTemplate.queryForObject(sql,new String[]{code},Long.class);
        return c;
    }

    @Override
    public void createClass(int tid, String name, String code) {
        String sql = "insert into 課程([課名],[tid],[代號]) values (?,?,?);";
        jdbcTemplate.update(sql,name,tid,code);
        System.out.println("完成新增課程");
    }

    @Override
    public void createRollCallList(String code) {
        String sql1 = "select cid from 課程 where 代號=?;";
        int cid  = jdbcTemplate.queryForObject(sql1,new String[]{code},Integer.class);
        String sql2 = "create table "+cid+"_點名系統 (sid ";
    }
}
