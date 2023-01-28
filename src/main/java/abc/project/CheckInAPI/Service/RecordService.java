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
    RecordRepository recordRepository;

    public List<Map<String, Object>> SemesterRecord(int cid){
        return recordRepository.RollCallRecordForSemester(cid);
    }

    public List<Map<String, Object>> TodayRecord(int cid,String dd){
        return recordRepository.RollCallRecordForToday(cid, dd);
    }
}
