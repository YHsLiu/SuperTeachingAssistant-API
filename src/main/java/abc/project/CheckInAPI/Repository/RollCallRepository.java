package abc.project.CheckInAPI.Repository;

import abc.project.CheckInAPI.Repository.Dao.RollCallDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RollCallRepository implements RollCallDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public long TcheckRollCall(int cid, String dd) {
        String sql = "select count(*) from 點名紀錄 where cid=? and sid=? and 日期=?;";
        long c = jdbcTemplate.queryForObject(sql,new Object[]{cid,0,dd}, Long.class);
        System.out.println("TeacherCheckRollCall c:"+c);
        return c;
    }

    @Override
    public void OpenRollCall(int cid, String dd) {
        String sql1 = "update 課程 set 點名=1 where cid=?;";
        String sql2 = "insert into 點名紀錄([cid],[sid],[日期]) values (?,?,?);";
        jdbcTemplate.update(sql1,cid);
        jdbcTemplate.update(sql2,cid,0,dd);  // 標記課程今日有點名
    }

    @Override
    public void OpenRollCallAgain(int cid, String dd) {
        String sql = "update 點名紀錄 set 日期=? where cid=? and 日期=?;";
        jdbcTemplate.update(sql,"d",cid,dd);
    }

    @Override
    public void CloseRollCall(int cid) {
        String sql = "update 課程 set 點名=0 where cid=?;";
        jdbcTemplate.update(sql,cid);
    }

    @Override
    public long ManualCheckRollCall(int cid, int sid, String dd) {
        // 手動點名前check For studentlist & rollcall
        String sql = "select count(*) from 點名紀錄 where cid=? and sid=? and 日期=?";
        long c = jdbcTemplate.queryForObject(sql,new Object[]{cid,sid,dd},Long.class);
        System.out.println("Manual c:"+c);
        return c;
    }

    @Override
    public void ManualRollCall(int cid, int sid, String dd) {
        // 手動點名
        String sql = "insert into 點名紀錄([cid],[sid],[日期]) values (?,?,?);";
        jdbcTemplate.update(sql,cid,sid,dd);
    }

    @Override
    public void ManualCancelRollCall(int cid, int sid, String dd) {
        String sql = "update 點名紀錄 set 日期=? where cid=? and sid=? and 日期=?;";
        jdbcTemplate.update(sql,"d",cid,sid,dd);
    }

    @Override
    public List<Map<String, Object>> StudentNoRCList(int cid, String dd) {
        // 未點名之學生資料
        String sql = "select * from 學生資料 where sid in (select sid from 選課 where cid=? and sid not in (select sid from 點名紀錄 where cid=? and 日期=?));";
        List<Map<String, Object>> stuList = jdbcTemplate.queryForList(sql,new Object[]{cid,cid,dd});
        return stuList;
    }

    @Override
    public int SEnterCheckRollCall(int cid) {  //有沒有開點名(0.1)
        String sql = "select 點名 from 課程 where cid=?";
        int c = jdbcTemplate.queryForObject(sql,new Object[]{cid},Integer.class);
        System.out.println("SEnterCheckRollCall c: "+c);
        return c;
    }

    @Override
    public long SCheckIfRollCall(int cid, int sid, String dd) {
        String sql = "select count(*) from 點名紀錄 where cid=? and sid=? and 日期=?";
        long c = jdbcTemplate.queryForObject(sql,new Object[]{cid,sid,dd},Long.class);
        return c;
    }


    @Override
    public void RollCallForStudent(int sid, int cid, String dd) {
        String sql = "insert into 點名紀錄([cid],[sid],[日期]) values (?,?,?);";
        String sql1 = "select count(*) from 點名紀錄 where cid=? and sid=? and 日期=?";
        long c = jdbcTemplate.queryForObject(sql1,new Object[]{cid,sid,dd},Long.class);
        System.out.println("RollCallForStudent check c="+c);
        jdbcTemplate.update(sql,cid,sid,dd);
    }
}
