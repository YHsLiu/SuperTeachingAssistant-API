package abc.project.CheckInAPI.Controller;

import abc.project.CheckInAPI.Service.RecordService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/record")
public class RecordController {
    @Autowired
    RecordService recordService;

    @PostMapping("/semester")
    public JSONObject SemesterRecord(@RequestBody String body){
        JSONObject data = new JSONObject(body);
        int cid = data.getInt("cid");
        JSONObject Info = new JSONObject();
        Info.put("type",2);
        Info.put("list",recordService.SemesterRecord(cid));
        return Info;
    }

    @PostMapping("/today")
    public JSONObject TodayRecord(@RequestBody String body){
        JSONObject data = new JSONObject(body);
        int cid = data.getInt("cid");
        String dd = data.getString("date");
        JSONObject Info = new JSONObject();
        Info.put("type",3);
        Info.put("list",recordService.TodayRecord(cid,dd));
        return Info;
    }
}
