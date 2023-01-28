package abc.project.CheckInAPI.Repository.Dao;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public interface RecordDao {
    public List<Map<String, Object>> RollCallRecordForSemester(int cid);
    public List<Map<String, Object>> RollCallRecordForToday(int cid, String dd);
    public List<Map<String, Object>> RollCallRecordForStudent(int cid,int sid);
}
