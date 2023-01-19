package abc.project.CheckInAPI.Service;

import abc.project.CheckInAPI.Repository.LotteryRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
@Service
public class LotteryService {
    @Autowired
    LotteryRepository lotteryRepository;

    static Set lotterySet  = new HashSet();
    public JSONObject lotteryResult(int cid,Boolean rollCall,int date){
        int r = 0;
        int i =0;
        List<Integer> sids;
        // 判斷抽籤名單要從哪個Table抓出
        if(rollCall){
            sids = lotteryRepository.LotteryByRollCall(cid,date);
        } else {
            sids = lotteryRepository.LotteryAll(cid);
        }

        while( i == sids.size() ) {
            r = (int) Math.random() * (sids.size());
            i++;
            if (lotterySet.contains(r)) {
                //已經存在
            } else {
                // set 中無此號碼 因此成功
                lotterySet.add(r);
                break;
            }
        }
        JSONObject responseObject = new JSONObject();
        responseObject.put("type",2);
        if (i == sids.size()){
            responseObject.put("status",12); // 通知使用者名單已抽完
        }else {
            responseObject.put("status",11);
            responseObject.put("stuInfo",lotteryRepository.whoIsBingo(sids.get(r)));
        }
        return responseObject;
    }

    // 清除抽籤資料
    public JSONObject resetLottery() {
        JSONObject responseObject = new JSONObject();
        responseObject.put("type",2);
        lotterySet.clear();
        return responseObject;
    }
}
