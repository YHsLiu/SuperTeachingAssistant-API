package abc.project.CheckInAPI.Repository.Dao;

public interface RegDao {

    public long checkUser(String acc, String pwd);
    public void saveUser(String univ, String depart, String name, String acc,  String pwd, String email, String identity);

}
