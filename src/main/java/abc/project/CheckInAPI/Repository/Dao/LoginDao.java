package abc.project.CheckInAPI.Repository.Dao;

public interface LoginDao {
    public long checkTeacher(String acc, String pwd, String univ);
    public int Findtid(String acc,String univ);
    public long checkStudent(String acc, String pwd, String univ);
    public int Findsid(String acc,String univ);
}
