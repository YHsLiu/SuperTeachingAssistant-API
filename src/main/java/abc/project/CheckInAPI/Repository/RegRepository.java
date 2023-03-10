package abc.project.CheckInAPI.Repository;

import abc.project.CheckInAPI.Repository.Dao.RegDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class RegRepository implements RegDao {

    @Autowired
    JdbcTemplate jdbcTemplate ;

    @Override
    public long checkStd(String acc, String pwd) {
        String query = "select count(*) from dbo.學生資料 where 學號=? and 密碼=?";
        long count = jdbcTemplate.queryForObject(query, new Object[]{acc,pwd},Long.class);
        return count;
    }

    @Override
    public long checkTch(String acc, String pwd) {
        String query = "select count(*) from dbo.老師資料 where 教師編號=? and 密碼=?";
        long count = jdbcTemplate.queryForObject(query, new Object[]{acc,pwd},Long.class);
        return count;
    }

    @Override
    public void saveStd(String univ, String depart, String name, String acc,  String pwd, String email){
        String sql = null;
        sql = "insert into 學生資料([學校], [科系], [學生姓名], [學號], [密碼], [信箱]) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,univ,depart,name,acc,pwd,email);
        System.out.println("資料已儲存");

    }

    @Override
    public void saveTch(String univ, String name, String acc, String pwd, String email) {

        String sql;
        sql = "insert into 老師資料([學校], [教師姓名], [教師編號], [密碼], [信箱]) values(?,?,?,?,?)";
        jdbcTemplate.update(sql,univ,name,acc,pwd,email);
        System.out.println("資料已儲存");

    }


}
