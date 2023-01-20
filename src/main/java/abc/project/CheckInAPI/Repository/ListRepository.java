package abc.project.CheckInAPI.Repository;

import abc.project.CheckInAPI.Repository.Dao.ListDao;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ListRepository implements ListDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public JSONObject AllStudentList(int cid) {
        String sql = "select sid from 選課 where cid=?";

        return null;
    }
}
