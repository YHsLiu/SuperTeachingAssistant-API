package abc.project.CheckInAPI.Repository.Dao;

import org.json.JSONObject;

public interface ReviseDataDao {

    public JSONObject getStdData(int sid);
    public JSONObject getTchData(int tid);
    public void updateStdData(int sid, String depart, String name, String acc,  String pwd, String email);
    public void updateTchData(int tid, String name, String acc,  String pwd, String email);

}
