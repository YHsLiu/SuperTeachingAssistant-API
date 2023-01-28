package abc.project.CheckInAPI.Repository.Dao;

public interface RegDao {

    public long checkStd(String acc, String pwd);
    public long checkTch(String acc, String pwd);
    public void saveStd(String univ, String depart, String name, String acc,  String pwd, String email);
    public void saveTch(String univ, String name, String acc,  String pwd, String email);


}
