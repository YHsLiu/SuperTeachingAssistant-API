package abc.project.CheckInAPI.Controller;

import abc.project.CheckInAPI.Service.InputCourseCodeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class InputCourseCodeController {

    @Autowired
    InputCourseCodeService service ;

    @PostMapping("/InputClassCode")
    public String inputCode(@RequestBody RequestBody rb){
        JSONObject packet = new JSONObject(rb);
        System.out.println("前端傳來的:"+packet);
        JSONObject data = packet.getJSONObject("data");
        String code = data.getString("code");


        return service.getCodeResult(code).toString();
    }
}
