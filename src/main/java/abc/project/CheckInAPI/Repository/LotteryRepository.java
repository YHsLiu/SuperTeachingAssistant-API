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


}
