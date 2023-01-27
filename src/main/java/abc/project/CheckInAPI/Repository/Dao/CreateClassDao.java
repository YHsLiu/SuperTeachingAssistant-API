package abc.project.CheckInAPI.Repository.Dao;

public interface CreateClassDao {
    public  long checkClassCod(String semester,String code);
    public int createClass(int tid,String semester,String name,String code);
}
