package abc.project.CheckInAPI.Repository.Dao;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public interface LotteryDao {
    public List<Integer>  LotteryAll(int cid);
    public Map<String, Object> whoIsBingo(int sid);
    public List<Integer>  LotteryByRollCall(int cid,String date);
    public long  CheckRollCallForLottery(int cid,String date);
}
