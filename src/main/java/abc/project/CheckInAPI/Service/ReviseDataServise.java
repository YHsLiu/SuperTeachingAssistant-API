package abc.project.CheckInAPI.Service;

import abc.project.CheckInAPI.Repository.ReviseDataRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviseDataServise {

    @Autowired
    ReviseDataRepository repository;

    public JSONObject getStdDataResult(int sid){

        JSONObject STDresult = new JSONObject(repository.getStdData(sid));
        return STDresult;

    }

    public JSONObject getTchDataResult(int tid){

        JSONObject TCHresult = new JSONObject(repository.getTchData(tid));
        return TCHresult;

    }

    public void updateStdDataResult(int sid, String univ, String depart, String name, String acc, String pwd, String email){

        repository.updateStdData(sid, univ, depart, name, acc, pwd, email);

    }

    public void updateTchDataResult(int tid, String univ, String name, String acc, String pwd, String email){

        repository.updateTchData(tid, univ, name, acc, pwd, email);

    }






}
