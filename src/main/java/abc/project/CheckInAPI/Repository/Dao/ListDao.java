package abc.project.CheckInAPI.Repository.Dao;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public interface ListDao {
    public List<Map<String, Object>> AllStudentList(int cid);
    public List<Map<String, Object>> ClassRoomList(int tid);
    public List<Map<String, Object>> studentEnterClassroomList(int sid);
}
