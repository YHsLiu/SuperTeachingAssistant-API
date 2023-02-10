package abc.project.CheckInAPI.Controller;

import abc.project.CheckInAPI.Service.StdRollCallService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class StdRollCallController {

    @Autowired
    StdRollCallService service;
    @PostMapping("/StdRollCall")  //第二步 btn後
    public String checkRollCall(@RequestBody String rb){

        JSONObject json = new JSONObject(rb);
        JSONObject data = json.getJSONObject("data");
        int cid = data.getInt("cid");
        int sid = data.getInt("sid");
        String dd = data.getString("date");
        System.out.println("data after clicking button and sending from api:"+data);
        return service.stdRollCallResult(cid,sid,dd); // 回傳String 若為2即為成功
    }

    @PostMapping("/StdEnterRollCall") //第一步 oncreate
    public String EnterCheckRollCall(@RequestBody String rb){

        JSONObject json = new JSONObject(rb);
        JSONObject data = json.getJSONObject("data");
        int cid = data.getInt("cid");
        int sid = data.getInt("sid");
        String dd = data.getString("date");
        System.out.println("EnterCheckRollCall from front:"+data);
        return service.stdEnterRollCallCheck(cid,sid,dd); // 回傳String 若為2即為成功
    }
}
