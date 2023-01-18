package abc.project.CheckInAPI.Repository.Dao;

import org.json.JSONObject;

import java.util.List;

public interface LotteryDao {
    public List<Integer>  LotteryAll(int cid);
    public JSONObject whoIsBingo(int sid);
}
