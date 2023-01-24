package abc.project.CheckInAPI.Repository.Dao;

public interface CreateClassDao {
    public  long checkClassCod(String semester,String code);
    public void createClass(int tid,String semester,String name,String code);
}
