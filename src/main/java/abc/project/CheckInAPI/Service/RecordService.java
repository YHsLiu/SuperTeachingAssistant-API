package abc.project.CheckInAPI.Service;

import abc.project.CheckInAPI.Repository.RecordRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecordService {
    @Autowired
    RecordRepository repository;

    public Map<String, Object> SemesterRecord(int cid){
        Map<String, Object> Info = new HashMap<>();
        List<Map<String,Object>> result = repository.RollCallRecordForSemester(cid);
        String dd = result.get(0).get("日期").toString();
        String record = "";
        for (int i=0;i<result.size();i++){
            if (dd == result.get(i).get("日期").toString()) {
                record += result.get(i).get("姓名")+" ";
            } else {
                Info.put(dd,record);
                dd = result.get(i).get("日期").toString();
                record = ""+result.get(i).get("姓名")+" ";
            }
        }
        Info.put(dd,record);
        return Info;
    }

    public List<Map<String, Object>> TodayRecord(int cid,String dd){
        return repository.RollCallRecordForToday(cid, dd);
    }
}
