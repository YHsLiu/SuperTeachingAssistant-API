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
    public JSONObject GetStdData(@RequestBody String rb){

        JSONObject object = new JSONObject(rb);
        int sid = object.getInt("sid");
        return servise.getStdDataResult(sid);
    }

    @PostMapping("GetData/teacher")
    public JSONObject GetTchData(@RequestBody String rb){

        JSONObject object = new JSONObject(rb);
        int tid = object.getInt("tid");
        return servise.getTchDataResult(tid);
    }

    @PostMapping("UpdataData/student")
    public void UpdataStdData(@RequestBody String rb){

        JSONObject object = new JSONObject(rb);
        int sid = object.getInt("sid");
        String univ = object.getString("univ");
        String depart = object.getString("department");
        String name = object.getString("name");
        String acc = object.getString("acc");
        String pwd = object.getString("pwd");
        String email = object.getString("email");
        servise.updateStdDataResult(sid, univ, depart, name, acc, pwd, email);
    }

    @PostMapping("UpdataData/teacher")
    public void UpdataTchData(@RequestBody String rb){

        JSONObject object = new JSONObject(rb);
        int tid = object.getInt("tid");
        String univ = object.getString("univ");
        String name = object.getString("name");
        String acc = object.getString("acc");
        String pwd = object.getString("pwd");
        String email = object.getString("email");
        servise.updateTchDataResult(tid, univ,  name, acc, pwd, email);
    }




}
