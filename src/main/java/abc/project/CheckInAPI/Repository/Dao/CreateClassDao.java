package abc.project.CheckInAPI.Repository.Dao;

public interface CreateClassDao {
    public  long checkClassCod(int semester,String code);
    public int createClass(int tid,int semester,String name,String code);
}
