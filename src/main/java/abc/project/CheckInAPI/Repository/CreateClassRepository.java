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
    public long checkClassCod(String semester,String code) {
        String sql = "select count(*) from 課程 where 代號=? and 學年=?;";
        long c = jdbcTemplate.queryForObject(sql,new String[]{code,semester},Long.class);
        return c;
    }

    @Override
    public void createClass(int tid,String semester, String name, String code) {
        String sql = "insert into 課程([課名],[tid],[學年],[代號],[點名]) values (?,?,?,?,?);";
        jdbcTemplate.update(sql,name,tid,semester,code,0);
        System.out.println("完成新增課程");
    }
}
