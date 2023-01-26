package abc.project.CheckInAPI.Service;

import abc.project.CheckInAPI.Repository.InputCourseCodeRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputCourseCodeService {
    @Autowired
    InputCourseCodeRepository repository;

    public JSONObject getCodeResult(String code){

        long c = repository.checkCode(code);
        JSONObject result = new JSONObject();
        result.put("type",2);
        if(c==0){                             //表示沒有該課程代碼
            result.put("status",17);
            result.put("mesg","課程代碼不存在");
        }
        else{
            result.put("status",16);
            result.put("mesg","查詢成功可進入教室");
        }

        return result;

    }

}
