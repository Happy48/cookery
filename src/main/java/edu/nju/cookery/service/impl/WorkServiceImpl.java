package edu.nju.cookery.service.impl;
import edu.nju.cookery.repository.WorkRepository;
import edu.nju.cookery.service.WorkService;
import edu.nju.cookery.entity.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkRepository workRepository;


    @Override
    public int createWork(int userid, int noteid, String picUrl, String content) {
        Work work=new Work();
        work.setNoteID(noteid);
        work.setUserID(userid);
        work.setPicture(picUrl);
        work.setDescription(content);
        workRepository.saveAndFlush(work);
        return 0;
    }
}
