package abc.project.CheckInAPI.Service;

import abc.project.CheckInAPI.Repository.RollCallRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RollCallService {
    @Autowired
    RollCallRepository repository;

    public JSONObject RollCallOpenByT(int cid, String dd){
        JSONObject result = new JSONObject();
        result.put("type",2);
        if (repository.TcheckRollCall(cid, dd)>0){
            result.put("status",13); // 今日已點名紀錄
        } else {
            repository.OpenRollCall(cid, dd);
            result.put("status",12); // 已打開點名開關
        }
        return result;
    }

    public JSONObject RollCallOpenAgainByT(int cid, String dd){
        JSONObject result = new JSONObject();
        result.put("type",2);
        // 將原點名紀錄的日期標示為d(可刪)
        repository.OpenRollCallAgain(cid, dd);
        // 而後再開點名
        repository.OpenRollCall(cid, dd);
        result.put("status",12);
        return result;
    }

    public void RollCallCloseByT(int cid){
        repository.CloseRollCall(cid);
    }

    public List<Map<String, Object>> NoRCStudent(int cid,String dd){
        return repository.StudentNoRCList(cid, dd);
    }

    public JSONObject ManualCheckRollCall(int cid,int sid,String dd){
        JSONObject result = new JSONObject();
        result.put("type",2);
        if (repository.ManualCheckRollCall(cid, sid, dd)==0){
            result.put("status",12);
        } else {
            result.put("status",13); // 今日已點名
        }
        result.put("cid",cid);
        result.put("sid",sid);
        result.put("date",dd);
        return result;
    }

    public void ManualRollCall(int cid,int sid,String dd){
        repository.ManualRollCall(cid, sid, dd);
    }

    public void ManualCancelRollCall(int cid,int sid,String dd){
        repository.ManualCancelRollCall(cid, sid, dd);
    }
}
