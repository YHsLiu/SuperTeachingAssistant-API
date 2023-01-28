package abc.project.CheckInAPI.Service;

import abc.project.CheckInAPI.Repository.Dao.ReviseDataDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReviseDataServise implements ReviseDataDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public JSONObject getStdData(int sid) {

        String sql = "select * from 學生資料 where sid=?" ;
        JSONObject object = jdbcTemplate.queryForObject(sql,new Object[]{sid}, JSONObject.class);
        return null;
    }

    @Override
    public JSONObject getTchData(int tid) {
        return null;
    }

    @Override
    public JSONObject updateStdData(String univ, String depart, String name, String acc, String pwd, String email) {
        return null;
    }

    @Override
    public JSONObject updateTchData(String univ, String name, String acc, String pwd, String email) {
        return null;
    }
}
