package abc.project.CheckInAPI.Repository.Dao;

public interface CreateClassDao {
    public  long checkClassCod(String code);
    public void createClass(int tid,String name,String code);
    public void createRollCallList(String code);
}
