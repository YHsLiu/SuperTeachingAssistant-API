package abc.project.CheckInAPI.Controller;

import abc.project.CheckInAPI.Service.LoginService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/member")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login/teacher")
    public String LoginTec(@RequestBody String body){
        // 接收 app 的登入資訊
        JSONObject object = new JSONObject(body);
        // 將資訊中的 data(帳密資料) 取出
        JSONObject data = object.getJSONObject("data");

        return loginService.loginTecResult(data.getString("acc"), data.getString("pwd"), data.getString("univ")).toString();
    }

    @PostMapping("/login/student")
    public String LoginStu(@RequestBody String body){
        // 接收 app 的登入資訊
        JSONObject object = new JSONObject(body);
        // 將資訊中的 data(帳密資料) 取出
        JSONObject data = object.getJSONObject("data");

        return loginService.loginStuResult(data.getString("acc"), data.getString("pwd"), data.getString("univ")).toString();
    }

}
