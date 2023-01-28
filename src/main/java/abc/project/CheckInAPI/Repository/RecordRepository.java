package abc.project.CheckInAPI.Repository;

import abc.project.CheckInAPI.Repository.Dao.RecordDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class RecordRepository implements RecordDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> RollCallRecordForSemester(int cid) {
        String sql = "select b.日期,a.學號,a.姓名 from 學生資料 a,(select sid,日期 from 點名紀錄 where cid=?) b where a.sid=b.sid order by b.日期,a.學號;";
        List<Map<String, Object>> recordForSemester = jdbcTemplate.queryForList(sql,new Object[]{cid});
        return recordForSemester;
    }

    @Override
    public List<Map<String, Object>> RollCallRecordForToday(int cid, String dd) {
        String sql = "select 學號,姓名 from 學生資料 where sid in (select sid from 點名紀錄 where cid=? and 日期=?);";
        List<Map<String, Object>> recordForToday = jdbcTemplate.queryForList(sql,new Object[]{cid,dd});
        return recordForToday;
    }
}
