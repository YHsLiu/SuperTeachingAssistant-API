package abc.project.CheckInAPI.Repository.Dao;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public interface ReviseDataDao {

    public Map<String,Object> getStdData(int sid);
    public Map<String,Object> getTchData(int tid);
    public void updateStdData(int sid, String depart, String name, String acc,  String pwd, String email);
    public void updateTchData(int tid, String name, String acc,  String pwd, String email);

}
