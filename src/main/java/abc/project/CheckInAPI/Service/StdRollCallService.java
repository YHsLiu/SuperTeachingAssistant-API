package abc.project.CheckInAPI.Service;

import abc.project.CheckInAPI.Repository.RollCallRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StdRollCallService {

    @Autowired
    RollCallRepository repository;

    public JSONObject stdRollCallResult(int cid, int sid, String dd){
        long c = repository.ManualCheckRollCall(cid, sid, dd);
        JSONObject result = new JSONObject();
        result.put("type",2);
        if(c==0){
            //第一次點名, 資料寫入DB
            repository.ManualRollCall(cid, sid, dd);
            result.put("status",21);
        }else{
            result.put("status",22);
        }

     return result;
    }

}
