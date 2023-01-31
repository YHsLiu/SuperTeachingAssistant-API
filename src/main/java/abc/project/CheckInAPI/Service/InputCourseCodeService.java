package abc.project.CheckInAPI.Service;

import abc.project.CheckInAPI.Repository.InputCourseCodeRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputCourseCodeService {
    @Autowired
    InputCourseCodeRepository repository;

    public JSONObject getCodeResult(String code, int sid){

        long c = repository.checkCode(code);
        JSONObject result = new JSONObject();
        result.put("type",2);
        if(c==0){                             //表示沒有該課程代碼
            result.put("status",17);
            result.put("mesg","查無課程名稱");
        }
        else{
            result.put("status",16);          //有該課程代碼，取得課程名稱&CID
            result.put("mesg",repository.getName(code));
            result.put("cid",repository.getCid(code));
            repository.putSidinClass(repository.getCid(code),sid);

        }

        return result;

    }

}
