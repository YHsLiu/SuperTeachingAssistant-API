package abc.project.CheckInAPI.Repository.Dao;

import org.json.JSONObject;

public interface ReviseDataDao {

    public JSONObject getStdData(int sid);
    public JSONObject getTchData(int tid);
    public JSONObject updateStdData(String univ, String depart, String name, String acc,  String pwd, String email);
    public JSONObject updateTchData(String univ, String name, String acc,  String pwd, String email);

}
