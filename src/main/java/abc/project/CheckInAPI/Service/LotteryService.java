package abc.project.CheckInAPI.Service;

import abc.project.CheckInAPI.Repository.LotteryRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LotteryService {
    @Autowired
    LotteryRepository lotteryRepository;

    static Set lotterySet  = new HashSet();
    public JSONObject lotteryResult(int cid){
        int r;
        List<Integer> sids=lotteryRepository.LotteryAll(cid);
        while(true ) {
            r = (int) Math.random() * (sids.size());
            if (lotterySet.contains(r)) {
                //已經存在
            } else {
                // set 中無此號碼 因此成功
                lotterySet.add(r);
                break;
            }
        }
        JSONObject responseObject = new JSONObject(lotteryRepository.whoIsBingo(sids.get(r)));
        return responseObject;
    }

    // 清除抽籤資料
    public void  resetLottery() {
        lotterySet.clear();
    }
}
