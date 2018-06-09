package edu.nju.cookery.service.impl;

import edu.nju.cookery.entity.Collect;
import edu.nju.cookery.repository.CollectRepository;
import edu.nju.cookery.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectRepository collectRepository;

    @Override
    public int getCollectCount(int noteID) {
        List<Collect> collectList = collectRepository.findByNoteID(noteID);
        return collectList.size();
    }

}
