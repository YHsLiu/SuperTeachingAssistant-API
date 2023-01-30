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
    public JSONObject lotteryResult(int cid,String date){
        List<Integer> sids;
        // 判斷抽籤名單要從哪個Table抓出
        if( lotteryRepository.CheckRollCallForLottery(cid, date)>0 ){
            sids = lotteryRepository.LotteryByRollCall(cid,date);
            System.out.println("有點名的抽籤名單");
        } else {
            sids = lotteryRepository.LotteryAll(cid);
        }
        JSONObject responseObject = new JSONObject();
        responseObject.put("type",2);
        System.out.println("lotteryResult:");
        System.out.println("lottery:"+lotterySet.size()+"/n"+"sids:"+sids.stream().count());
        if (lotterySet.size() == sids.size()) {
            System.out.println("已走完");
            responseObject.put("status", 13); // 通知使用者名單已抽完
        }else {
            while (lotterySet.size() < sids.size()) {
                int r = (int) (Math.random() * sids.size());
                if (lotterySet.contains(r)) {
                    //已經存在
                    System.out.println("存在，r="+r);
                } else {
                    // set 中無此號碼 因此成功
                    System.out.println("不存在，r="+r);
                    lotterySet.add(r);
                    responseObject.put("status",12);
                    responseObject.put("stuInfo",lotteryRepository.whoIsBingo(sids.get(r)));
                    break;
                }
            }
        }
        return responseObject;
    }

    // 清除抽籤資料
    public JSONObject resetLottery() {
        JSONObject responseObject = new JSONObject();
        responseObject.put("type",2);
        lotterySet.clear();
        System.out.println("已清除");
        responseObject.put("isClear",true);
        return responseObject;
    }
}
