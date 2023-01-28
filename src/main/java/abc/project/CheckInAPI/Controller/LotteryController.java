package abc.project.CheckInAPI.Controller;

import abc.project.CheckInAPI.Service.LotteryService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/lottery")
public class LotteryController {
    @Autowired
    LotteryService lotteryService;

    @PostMapping("/bingo")
    public JSONObject LotteryGo(@RequestBody String body){
        // 接收 app 的課程資訊
        JSONObject object = new JSONObject(body);
        // 將資訊中的 cid 取出
        int cid = object.getInt("cid");
        Boolean rollCall = object.getBoolean("rollCall");
        int date = object.getInt("date");

        return lotteryService.lotteryResult(cid,rollCall,date);
    }

    @PostMapping("/clear")
    public JSONObject LotteryEnd(){
       return lotteryService.resetLottery();
    }
}
