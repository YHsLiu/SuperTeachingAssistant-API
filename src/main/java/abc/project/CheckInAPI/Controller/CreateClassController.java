package abc.project.CheckInAPI.Controller;

import abc.project.CheckInAPI.Service.CreateClassService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class CreateClassController {
    @Autowired
    CreateClassService service;

    @PostMapping("/createclass")
    public String Creatclass(@RequestBody String body){
        JSONObject object = new JSONObject(body);
        JSONObject data = object.getJSONObject("classInfo");
        int tid = data.getInt("tid");
        int semester = data.getInt("semester");
        String name = data.getString("className");
        String code = data.getString("classCode");
        System.out.println(tid+" "+semester+" "+name+" "+ code);
        return service.CreateNewClassResult(tid,semester,name,code).toString();
    }
}
