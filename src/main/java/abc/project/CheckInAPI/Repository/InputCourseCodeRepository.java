package abc.project.CheckInAPI.Repository;

import abc.project.CheckInAPI.Repository.Dao.InputCourseCodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class InputCourseCodeRepository implements InputCourseCodeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public long checkCode(String code){

        String sql = "select count(*) from dbo.課程 where 課程代碼=?" ;
        long count = jdbcTemplate.queryForObject(sql, new Object[]{code},Long.class);

        return count;
    }

    @Override
    public String getName(String code) {

        String sql = "select 課程名稱 from dbo.課程 where 課程代碼=?" ;
        String classname = jdbcTemplate.queryForObject(sql,new Object[]{code}, String.class);
        return classname;
    }


}