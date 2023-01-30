package abc.project.CheckInAPI.Service;

import abc.project.CheckInAPI.Repository.ReviseDataRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReviseDataServise {

    @Autowired
    ReviseDataRepository repository;

    public Map<String,Object> getStdDataResult(int sid){

        return repository.getStdData(sid);

    }

    public Map<String,Object> getTchDataResult(int tid){

        return repository.getTchData(tid);

    }

    public void updateStdDataResult(int sid, String depart, String name, String acc, String pwd, String email){

        repository.updateStdData(sid, depart, name, acc, pwd, email);

    }

    public void updateTchDataResult(int tid, String name, String acc, String pwd, String email){

        repository.updateTchData(tid, name, acc, pwd, email);

    }






}
