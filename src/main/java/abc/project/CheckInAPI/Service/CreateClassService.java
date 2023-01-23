package abc.project.CheckInAPI.Service;

import abc.project.CheckInAPI.Repository.CreateClassRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateClassService {
    @Autowired
    CreateClassRepository repository;

    public JSONObject CreateNewClass(int tid, String name, String code){
        JSONObject thing = new JSONObject();
        long c = repository.checkClassCod(code);
        thing.put("type",2);
        if (c == 0){
            // 檢查課程代碼若無重複則新增課程
            thing.put("status",11);
            repository.createClass(tid,name,code);
        } else {
            thing.put("status",12);
        }
        return thing;
    }
}
