package abc.project.CheckInAPI.Controller;

import abc.project.CheckInAPI.Service.CreateClassService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class CreateClassController {
    @Autowired
    CreateClassService service;

    public JSONObject Creatclass(@RequestBody String body){
        JSONObject object = new JSONObject(body);
        // 將資訊中的 cid 取出
        JSONObject data = object.getJSONObject("data");
        int tid = data.getInt("tid");
        String semester = data.getString("semester");
        String name = data.getString("className");
        String code = data.getString("classCode");

        return service.CreateNewClassResult(tid,semester,name,code);
    }
}
