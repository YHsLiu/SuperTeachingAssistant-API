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
        String sql = "select count(*) from 老師資料 where 教師編號=? and 密碼=? and 學校=?;";
        long count =jdbcTemplate.queryForObject(sql,new Object[]{acc,pwd,univ}, Long.class);
        System.out.println(acc+" "+pwd+" "+univ+" ");
        return count;
    }

    @Override
    public int Findtid(String acc, String univ) {
        String sql = "select tid from 老師資料 where 教師編號=? and 學校=?;";
        int tid = jdbcTemplate.queryForObject(sql,new Object[]{acc,univ}, Integer.class);
        return tid;
    }

    @Override
    public long checkStudent(String acc, String pwd, String univ) {
        String sql = "select count(*) from 學生資料 where 學號=? and 密碼=? and 學校=?;";
        long count =jdbcTemplate.queryForObject(sql,new Object[]{acc,pwd,univ}, Long.class);
        return count;
    }

    @Override
    public int Findsid(String acc, String univ) {
        String sql = "select sid from 學生資料 where 學號=? and 學校=?;";
        int sid = jdbcTemplate.queryForObject(sql,new Object[]{acc,univ}, Integer.class);
        System.out.println(sid);
        return sid;
    }
}
