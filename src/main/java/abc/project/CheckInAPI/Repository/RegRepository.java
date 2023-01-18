package abc.project.CheckInAPI.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class RegRepository {

    @Autowired
    JdbcTemplate jdbcTemplate ;

    public long checkUser(String acc, String pwd) {
        String query = "select count(*) from dbo.學生資料 where 學號=? and 密碼=?";
        long count = jdbcTemplate.queryForObject(query, new Object[]{acc,pwd},Long.class);
        return count;
    }


    public void saveUser(String univ, String depart, String name, String acc,  String pwd, String email, String identity){
        String sql = null;
        if(identity.equals("我是學生")) {
            sql = "insert into 學生資料([學校], [科系], [學生姓名], [學號], [密碼], [信箱]) values(?,?,?,?,?,?)";
        }
        else {
            sql = "insert into 老師資料([學校],[科系], [學生姓名], [學號], 密碼, 信箱) values(?,?,?,?,?,?)";
        }
        jdbcTemplate.update(sql,univ,depart,name,acc,pwd,email);
        System.out.println("資料已儲存");

    }


}
