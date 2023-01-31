package abc.project.CheckInAPI.Repository;

import abc.project.CheckInAPI.Repository.Dao.InputCourseCodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InputCourseCodeRepository implements InputCourseCodeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public long checkCode(String code){

        String sql = "select count(*) from 課程 where [課程代碼]=?" ;
        long count = jdbcTemplate.queryForObject(sql, new Object[]{code},Long.class);

        return count;
    }

    @Override
    public String getName(String code) {

        String sql = "select 課程名稱 from 課程 where [課程代碼]=?" ;
        String classname = jdbcTemplate.queryForObject(sql,new Object[]{code}, String.class);
        return classname;
    }


    public int getCid(String code) {

        String sql = "select cid from 課程 where [課程代碼]=?" ;
        int cid = jdbcTemplate.queryForObject(sql,new Object[]{code}, Integer.class);
        return cid;
    }

    public void putSidinClass(int cid, int sid){
        String sql ="insert into 選課(cid,sid) values(?,?);" ;
        jdbcTemplate.update(sql,cid,sid);
        System.out.println("資料已儲存至選課資料表");
    }


}
