package abc.project.CheckInAPI.Repository;

import abc.project.CheckInAPI.Repository.Dao.LotteryDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class LotteryRepository implements LotteryDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Integer> LotteryAll(int cid) {
        // 若無則從(Table:選課)篩出有選(column:cid)課程的學生
        String sql = "select `sid` from 選課 where cid=?";
        List<Integer> sids = jdbcTemplate.queryForList(sql,new Object[]{cid}, Integer.class);
        return sids;
    }

    @Override
    public JSONObject whoIsBingo(int sid) {
        String sql = "select * from 學生資料 where sid=?";
        JSONObject object = jdbcTemplate.queryForObject(sql,new Object[]{sid}, JSONObject.class);
        return object;
    }

    @Override
    public List<Integer> LotteryByRollCall(int cid, int date) {
        // 若已點名，則從(Table:cid+"點名紀錄")抓今天有點名的名單(column:(int)date)來抽
        String sql = "select `sid` from "+cid+"點名紀錄 where "+date+"=?";
        List<Integer> sids = jdbcTemplate.queryForList(sql,new Object[]{1}, Integer.class); // 1有到，0沒到
        return sids;
    }


}
