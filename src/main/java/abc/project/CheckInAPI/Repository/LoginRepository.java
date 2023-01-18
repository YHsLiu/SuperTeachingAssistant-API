package abc.project.CheckInAPI.Repository;

import abc.project.CheckInAPI.Repository.Dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository implements LoginDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public long checkTeacher(String acc, String pwd, String univ) {
        String sql = "select count(*) from 老師資料 where 教師編號=? and 密碼=? and 學校=?";
        long count =jdbcTemplate.queryForObject(sql,new Object[]{acc,pwd,univ}, Long.class);
        return count;
    }

    @Override
    public long checkStudent(String acc, String pwd, String univ) {
        String sql = "select count(*) from 學生資料 where 學號=? and 密碼=? and 學校=?";
        long count =jdbcTemplate.queryForObject(sql,new Object[]{acc,pwd,univ}, Long.class);
        return count;
    }
}
