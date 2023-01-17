package abc.project.CheckInAPI.Service;

import abc.project.CheckInAPI.Repository.LoginRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRep;

    public JSONObject loginTecReesult( String acc, String pwd ){
        long c = loginRep.checkTeacher( acc , pwd );

        JSONObject responseObject = new JSONObject();
        responseObject.put("type",2);
        if (c == 0){
            responseObject.put("status",12);
            responseObject.put("mes","驗證失敗");
        } else if (c == 1){
            responseObject.put("status",11);
            responseObject.put("mes","驗證成功");
        } else {
            responseObject.put("status",13);
            responseObject.put("mes","會員資料有重複，請檢察資料庫");
        }
        return responseObject;
    }

    public JSONObject loginStuReesult( String acc, String pwd ){
        long c = loginRep.checkStudent( acc , pwd );

        JSONObject responseObject = new JSONObject();
        responseObject.put("type",2);
        if (c == 0){
            responseObject.put("status",12);
            responseObject.put("mes","驗證失敗");
        } else if (c == 1){
            responseObject.put("status",11);
            responseObject.put("mes","驗證成功");
        } else {
            responseObject.put("status",13);
            responseObject.put("mes","會員資料有重複，請檢察資料庫");
        }
        return responseObject;
    }
}
