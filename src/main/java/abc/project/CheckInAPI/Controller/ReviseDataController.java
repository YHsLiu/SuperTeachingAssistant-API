package abc.project.CheckInAPI.Controller;

import abc.project.CheckInAPI.Service.ReviseDataServise;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ReviseDataController {

    @Autowired
    ReviseDataServise servise;

    @PostMapping("GetData/student")
    public String GetStdData(@RequestBody String rb){

        JSONObject object = new JSONObject(rb);
        int sid = object.getJSONObject("data").getInt("sid");
        System.out.println(sid);
        return servise.getStdDataResult(sid).toString();
    }

    @PostMapping("GetData/teacher")
    public String GetTchData(@RequestBody String rb){

        JSONObject object = new JSONObject(rb);
        int tid = object.getJSONObject("data").getInt("tid");
        return servise.getTchDataResult(tid).toString();
    }

    @PostMapping("UpdataData/student")
    public void UpdataStdData(@RequestBody String rb){

        JSONObject object = new JSONObject(rb);
        JSONObject dataForApp = object.getJSONObject("data");
        int sid = dataForApp.getInt("sid");
        String depart = dataForApp.getString("department");
        String name = dataForApp.getString("name");
        String acc = dataForApp.getString("acc");
        String pwd = dataForApp.getString("pwd");
        String email = dataForApp.getString("email");
        servise.updateStdDataResult(sid, depart, name, acc, pwd, email);
    }

    @PostMapping("UpdataData/teacher")
    public void UpdataTchData(@RequestBody String rb){

        JSONObject object = new JSONObject(rb);
        JSONObject dataForApp = object.getJSONObject("data");
        int tid = dataForApp.getInt("tid");
        String name = dataForApp.getString("name");
        String acc = dataForApp.getString("acc");
        String pwd = dataForApp.getString("pwd");
        String email = dataForApp.getString("email");
        servise.updateTchDataResult(tid, name, acc, pwd, email);
    }




}
