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
    public String SemesterRecord(@RequestBody String body){
        JSONObject data = new JSONObject(body);
        int cid = data.getInt("cid");
        JSONObject Info = new JSONObject();
        Info.put("type",2);
        Info.put("list",recordService.SemesterRecord(cid));
        return Info.toString();
    }

    @PostMapping("/today")
    public String TodayRecord(@RequestBody String body){
        JSONObject data = new JSONObject(body);
        int cid = data.getInt("cid");
        String dd = data.getString("date");
        JSONObject Info = new JSONObject();
        Info.put("type",3);
        Info.put("list",recordService.TodayRecord(cid,dd));
        return Info.toString();
    }

    @PostMapping("/student")
    public String StudentRecord(@RequestBody String body){
        JSONObject data = new JSONObject(body);
        int cid = data.getInt("cid");
        int sid = data.getInt("sid");
        JSONObject Info = new JSONObject();
        Info.put("type",4);
        Info.put("list",recordService.StudentRecord(cid,sid));
        return Info.toString();
    }
}
