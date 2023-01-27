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
    @PostMapping("StdRollCall")
    public String checkRollCall(@RequestBody RequestBody rb){

        JSONObject json = new JSONObject(rb);
        JSONObject data = json.getJSONObject("data");
        int cid = data.getInt("cid");
        int sid = data.getInt("sid");
        String dd = data.getString("date");
        return service.stdRollCallResult(cid,sid,dd).toString();
    }



}
