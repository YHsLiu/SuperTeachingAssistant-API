package abc.project.CheckInAPI.Repository;

import abc.project.CheckInAPI.Repository.Dao.ReviseDataDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReviseDataRepository implements ReviseDataDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public JSONObject getStdData(int sid) {

        String sql = "select * from 學生資料 where sid=?" ;
        JSONObject object = jdbcTemplate.queryForObject(sql,new Object[]{sid}, JSONObject.class);
        return object;
    }

    @Override
    public JSONObject getTchData(int tid) {

        String sql = "select * from 老師資料 where sid=?" ;
        JSONObject object = jdbcTemplate.queryForObject(sql,new Object[]{tid}, JSONObject.class);
        return object;
    }

    @Override
    public void updateStdData(int sid, String depart, String name, String acc, String pwd, String email) {

        String sql ="updata 學生資料 set [科系]=?,[學生姓名]=?,[學號]=?,[密碼]=?,[信箱]=? where sid=?";
        jdbcTemplate.update(sql,depart,name,acc,pwd,email,sid);
        System.out.println("學生資料已儲存");

    }

    @Override
    public void updateTchData(int tid, String name, String acc, String pwd, String email) {

        String sql ="updata 老師資料 set [教師姓名]=?,[教師編號]=?,[密碼]=?,[信箱]=? where tid=?";
        jdbcTemplate.update(sql,name,acc,pwd,email,tid);
        System.out.println("教師資料已儲存");
    }
}

