package abc.project.CheckInAPI.Service;

import abc.project.CheckInAPI.Repository.RollCallRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StdRollCallService {

    @Autowired
    RollCallRepository repository;

    public String stdRollCallResult(int cid, int sid, String dd){
        repository.RollCallForStudent(cid, sid, dd);
        String type = "2";
     return type;
    }

    public String stdEnterRollCallCheck(int cid, int sid, String dd){
        JSONObject data = new JSONObject();
        if (repository.SEnterCheckRollCall(cid) == 1){
            // 開放點名
            data.put("type",2);
            if (repository.SCheckIfRollCall(cid,sid,dd) == 0){
                // 未點名->點名按鈕設定可點選
                data.put("status",12);
            } else {
                // 已點名->UI顯示已點名
                data.put("status",13);
            }
        } else {
            // 未開放點名
            data.put("type",3);
        }
        return data.toString();
    }

}
