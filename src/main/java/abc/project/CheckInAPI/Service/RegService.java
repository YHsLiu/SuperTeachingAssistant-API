package abc.project.CheckInAPI.Service;

import abc.project.CheckInAPI.Repository.RegRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegService {

@Autowired
RegRepository repository;

public JSONObject RegStdResult(String univ, String depart, String name, String acc,  String pwd, String email){

    long result = repository.checkStd(acc, pwd);
    // 準備一個回傳用的 JSON物件
    JSONObject responseObject = new JSONObject();
    responseObject.put("type",2);
    if(result == 0)  {                    //表示帳號密碼不存在
        responseObject.put("status",11);
        responseObject.put("mesg","帳號已建立");

        //呼叫storeData請Repository存資料至DB
        repository.saveStd(univ,depart, name, acc, pwd, email);
    }
    else {
        responseObject.put("status",12);
        responseObject.put("mesg","帳號已存在, 請直接登入");
    }
    return responseObject;
}


    public JSONObject RegTchResult(String univ, String name, String acc,  String pwd, String email){

        long result = repository.checkTch(acc, pwd);
        JSONObject responseObject = new JSONObject();
        responseObject.put("type",2);
        if(result == 0)  {                            //表示帳號密碼不存在
            responseObject.put("status",11);
            responseObject.put("mesg","帳號已建立");
            repository.saveTch(univ, name, acc, pwd,email);
        }
        else {
            responseObject.put("status",12);
            responseObject.put("mesg","帳號已存在, 請直接登入");
        }
        return responseObject;
    }


/*class storeData{

    String univ, depart, name, acc, pwd, email, identity;

    public storeData(String univ, String depart, String name, String acc,  String pwd, String email, String identity) {
        this.univ = univ;
        this.depart = depart;
        this.name = name;
        this.acc = acc;
        this.pwd = pwd;
        this.email = email;
        this.identity = identity;
    }

    public void savetoDB(){

    }

    }*/
}
