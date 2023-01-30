package abc.project.CheckInAPI.Controller;

import abc.project.CheckInAPI.Service.RollCallService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rollcall")
public class RollCallController {
    @Autowired
    RollCallService service;

    @PostMapping("/teacher/open")
    public String OpenRollCallForTeacher(@RequestBody String body){
        JSONObject object = new JSONObject(body);
        JSONObject data = object.getJSONObject("data");
        int cid = data.getInt("cid");
        String dd = data.getString("date");
        return service.RollCallOpenByT(cid,dd).toString();
    }

    @PostMapping("/teacher/open/again")
    public String OpenRollCallAgainForTeacher(@RequestBody String body){
        JSONObject object = new JSONObject(body);
        JSONObject data = object.getJSONObject("data");
        int cid = data.getInt("cid");
        String dd = data.getString("date");
        return service.RollCallOpenAgainByT(cid,dd).toString();
    }

    @PostMapping("/teacher/close")
    public String CloseRollCallForTeacher(@RequestBody String body){
        JSONObject object = new JSONObject(body);
        JSONObject data = object.getJSONObject("data");
        int cid = data.getInt("cid");
        // 點名狀態關閉
        service.RollCallCloseByT(cid);
        String dd = data.getString("date");
        JSONObject Info = new JSONObject();
        Info.put("type",2);
        // 回傳未點名之學生資料
        Info.put("list",service.NoRCStudent(cid,dd));
        return Info.toString();
    }

    @PostMapping("/manual/check")
    public String ManualCheckRollCall(@RequestBody String body){
        JSONObject object = new JSONObject(body);
        // 將資訊中的 cid 取出
        int cid = object.getInt("cid");
        int sid = object.getInt("sid");
        String dd = object.getString("date");
        return service.ManualCheckRollCall(cid,sid,dd).toString();
    }
    @PostMapping("/manual/call")
    public void ManualRollCall(@RequestBody String body){
        JSONObject object = new JSONObject(body);
        int cid = object.getInt("cid");
        int sid = object.getInt("sid");
        String dd = object.getString("date");
        service.ManualRollCall(cid,sid,dd);
    }

    @PostMapping("/manual/cancel")
    public void ManualCancelRollCall(@RequestBody String body){
        JSONObject object = new JSONObject(body);
        int cid = object.getInt("cid");
        int sid = object.getInt("sid");
        String dd = object.getString("date");
        service.ManualCancelRollCall(cid,sid,dd);
    }
}
