package abc.project.CheckInAPI.Controller;
import abc.project.CheckInAPI.Service.RegService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//處理app註冊需求(1.確認是否重複註冊  2.新資料傳給Service再給DB)
@RestController
@RequestMapping("/api/project")
public class RegController {

    @Autowired
    RegService service;

    @PostMapping("/registration/student")
    public String STDregistration(@RequestBody String rb){

        JSONObject JSONfromAPP = new JSONObject(rb);
        //System.out.println("前端傳來的訊息"+JSONfromAPP.toString(4));
        JSONObject data = JSONfromAPP.getJSONObject("data");
        //System.out.println("其中Data的資料是:"+data.toString(4));
        String univ = data.getString("univ");
        String depart = data.getString("department");
        String name = data.getString("name");
        String acc = data.getString("acc");
        String pwd = data.getString("pwd");
        String email = data.getString("email");

        return service.RegStdResult(univ,depart, name, acc, pwd, email).toString() ;

    }

    @PostMapping("/registration/teacher")
    public String TCHregistration(@RequestBody String rb){

        JSONObject JSONfromAPP = new JSONObject(rb);
        JSONObject data = JSONfromAPP.getJSONObject("data");
        String univ = data.getString("univ");
        String name = data.getString("name");
        String acc = data.getString("acc");
        String pwd = data.getString("pwd");
        String email = data.getString("email");

        return service.RegTchResult(univ, name, acc, pwd, email).toString() ;

    }

}
