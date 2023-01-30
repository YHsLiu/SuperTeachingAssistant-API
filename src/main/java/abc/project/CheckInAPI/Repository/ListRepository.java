package abc.project.CheckInAPI.Repository;

import abc.project.CheckInAPI.Repository.Dao.ListDao;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ListRepository implements ListDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> AllStudentList(int cid) {
        String sql = "select b.sid b.學生姓名, b.科系, b.學號 from 選課 a, 學生資料 b where a.sid=b.sid and a.cid=? order by b.學號";
        List<Map<String, Object>> stuList = jdbcTemplate.queryForList(sql,new int[] {cid},null);
        return stuList;
    }

    @Override
    public List<Map<String, Object>> ClassRoomList(int tid) {
        String sql = "select * from 課程 where tid=?;";
        System.out.println("教室選擇的tid="+tid);
        List<Map<String, Object>> roomList = jdbcTemplate.queryForList(sql,new Object[] {tid});

        System.out.println(roomList);
        return roomList;
    }

    @Override
    public List<Map<String, Object>> studentEnterClassroomList(int sid) {
        String sql = "select * from 課程 where cid in (select cid from 選課 where sid=? order by cid);";
        List<Map<String, Object>> roomList = jdbcTemplate.queryForList(sql,new Object[] {sid});
        return roomList;
    }
}
