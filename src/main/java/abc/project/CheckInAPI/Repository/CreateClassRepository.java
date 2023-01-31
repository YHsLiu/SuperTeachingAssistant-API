package abc.project.CheckInAPI.Repository;

import abc.project.CheckInAPI.Repository.Dao.CreateClassDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CreateClassRepository implements CreateClassDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public long checkClassCod(int semester,String code) {
        String sql = "select count(*) from 課程 where 課程代碼=? and 學年度=?;";
        long c = jdbcTemplate.queryForObject(sql,new Object[]{code,semester},Long.class);
        System.out.println("check 課程是否有重複，0沒重複，1重複"+c+" ");
        return c;
    }

    @Override
    public int createClass(int tid,int semester, String name, String code) {
        String sql = "insert into 課程([課程名稱],[課程代碼],[學年度],[tid],[點名]) values (?,?,?,?,?);";
        jdbcTemplate.update(sql,name,code,semester,tid,0);
        System.out.println("完成新增課程");
        String sql1 = "select cid from 課程 where 課程代碼=? and 學年度=?;";
        Map<String,Object> result = jdbcTemplate.queryForMap(sql1,new Object[]{code,semester});
        int cid = (int) result.get("cid");
        return cid;
    }
}
