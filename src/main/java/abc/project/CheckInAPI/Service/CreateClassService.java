package abc.project.CheckInAPI.Service;

import abc.project.CheckInAPI.Repository.CreateClassRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateClassService {
    @Autowired
    CreateClassRepository repository;

    public JSONObject CreateNewClassResult(int tid,String semester, String name, String code){
        JSONObject thing = new JSONObject();
        long c = repository.checkClassCod(semester,code);
        thing.put("type",2);
        if (c == 0){
            // 檢查課程代碼若無重複則新增課程
            thing.put("status",11);
            int cid = repository.createClass(tid,semester,name,code);
            thing.put("cid",cid);
        } else {
            thing.put("status",12);
            thing.put("cid",0);
        }
        return thing;
    }
}
