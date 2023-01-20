package abc.project.CheckInAPI.Repository.Dao;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public interface ListDao {
    public List<Map<String, Object>> AllStudentList(int cid);
}
