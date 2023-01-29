package abc.project.CheckInAPI.Controller;

import abc.project.CheckInAPI.Repository.ListRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/list")
public class ListController {
    @Autowired
    ListRepository listRepository;

    @PostMapping("/allStu")
    public JSONObject ListAllStu(@RequestBody String body){
        JSONObject data = new JSONObject(body);
        int cid = data.getInt("cid");
        JSONObject Info = new JSONObject();
        Info.put("type",2);
        Info.put("list",listRepository.AllStudentList(cid));
        return Info;
    }

    @PostMapping("/classroom")
    public JSONObject ListClassroom(@RequestBody String body){
        JSONObject data = new JSONObject(body);
        int tid = data.getInt("tid");
        JSONObject Info = new JSONObject();
        Info.put("type",2);
        Info.put("list",listRepository.ClassRoomList(tid));
        System.out.println(12+"");
        return Info;
    }

    @PostMapping("/student/classroom")
    public JSONObject studentListClassroom(@RequestBody String body){
        JSONObject data = new JSONObject(body);
        int sid = data.getInt("sid");
        JSONObject Info = new JSONObject();
        Info.put("type",2);
        Info.put("list",listRepository.studentEnterClassroomList(sid));
        return Info;
    }
}
