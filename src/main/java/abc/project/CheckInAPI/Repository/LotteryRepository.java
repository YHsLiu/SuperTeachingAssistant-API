package abc.project.CheckInAPI.Repository;

import abc.project.CheckInAPI.Repository.Dao.LotteryDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class LotteryRepository implements LotteryDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Integer> LotteryAll(int cid) {
        // 若無則從(Table:選課)篩出有選(column:cid)課程的學生
        String sql = "select sid from 選課 where cid=?;";
        List<Integer> sids = jdbcTemplate.queryForList(sql,new Object[]{cid}, Integer.class);
        System.out.println("LotteryAll:"+sids);
        return sids;
    }

    @Override
    public Map<String, Object> whoIsBingo(int sid) {
        String sql = "select * from 學生資料 where sid=?;";
        System.out.println(sid);
        Map<String, Object> object = jdbcTemplate.queryForMap(sql,new Object[]{sid});
        //System.out.println(object);
        return object;
    }

    @Override
    public List<Integer> LotteryByRollCall(int cid, String date) {
        // 若已點名，則從(Table:"點名紀錄")抓今天有點名的名單(column:cid+日期)來抽
        String sql = "select sid from 點名紀錄 where cid=? and 日期=? and sid not in (0);";
        List<Integer> sids = jdbcTemplate.queryForList(sql,new Object[]{cid,date}, Integer.class);
        System.out.println("LotteryByRollCall:"+sids);
        return sids;
    }

    @Override
    public long CheckRollCallForLottery(int cid, String date) {
        // 判斷今日是否已點名(c=0 -> LotteryAll, c>0 -> LotteryByRollCall
        String sql = "select count(*) from 點名紀錄 where cid=? and 日期=?;";
        long c = jdbcTemplate.queryForObject(sql,new Object[]{cid,date}, Long.class);
        return c;
    }


}
