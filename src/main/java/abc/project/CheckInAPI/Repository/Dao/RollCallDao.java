package abc.project.CheckInAPI.Repository.Dao;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public interface RollCallDao {
    public long TcheckRollCall(int cid, String dd);
    public void OpenRollCall(int cid, String dd);
    public void OpenRollCallAgain(int cid, String dd);
    public void CloseRollCall(int cid);
    public long ManualCheckRollCall(int cid,int sid,String dd);
    public void ManualRollCall(int cid,int sid,String dd);
    public void ManualCancelRollCall(int cid,int sid,String dd);
    public List<Map<String, Object>> StudentNoRCList(int cid,String dd);
    public JSONObject ScheckRollCall(int cid);
    public JSONObject RollCallForStudent(int sid, int cid, String dd);
}
