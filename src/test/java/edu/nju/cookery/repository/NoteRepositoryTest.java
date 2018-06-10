package edu.nju.cookery.repository;

import edu.nju.cookery.util.DateHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import edu.nju.cookery.entity.Note;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteRepositoryTest {

    @Autowired
    NoteRepository noteRepository;

    @Test
    public void findByUserID() {
        assertEquals(2, noteRepository.findByUserID(2).size());
        assertEquals(6, noteRepository.findByUserID(7).size());
    }

    @Test
    public void findByNoteID() {
        assertEquals("香芋红烧肉", noteRepository.findByNoteID(1).getNoteName());
        assertEquals("粢饭团", noteRepository.findByNoteID(12).getNoteName());
    }

    @Test
    public void findByUserID2() {
        Pageable pageable = new PageRequest(0, 5);
        assertEquals(2, noteRepository.findByUserID(1,pageable).getContent().get(1).getNoteID());
        pageable = new PageRequest(1, 5);
        assertEquals(7, noteRepository.findByUserID(1,pageable).getContent().get(1).getNoteID());
    }

    @Test
    public void createNote(){
        Note note=new Note();
        note.setUserID(12);
        note.setNoteName("减肥必备沙拉");
        note.setNoteCover("http://s2.cdn.xiachufang.com/5e019284893111e6a9a10242ac110002_1125w_1125h.jpg?imageView2/2/w/660/interlace/1/q/90");
        note.setDescription("减肥神器");
        note.setMaterial("[{'unit': '', 'name': '紫薯'}, {'unit': '', 'name': '糯米粉或面粉'}, {'unit': '', 'name': '牛奶（减肥可用脱脂牛奶）'}, {'unit': '', 'name': '芝麻'}]");
        note.setPractice("[{'id': 1, 'img': 'http://s2.cdn.xiachufang.com/55855000939f11e6a9a10242ac110002_1836w_1836h.jpg?imageView2/2/w/300/interlace/1/q/90', 'information': '紫薯蒸熟后压成紫薯泥，压的越细腻口感越好。然后加入白糖，糖的用量根据自己口味放吧。'}, {'id': 2, 'img': 'http://s2.cdn.xiachufang.com/56842012939f11e6a9a10242ac110002_1836w_1836h.jpg?imageView2/2/w/300/interlace/1/q/90', 'information': '加糯米粉，没有糯米粉的加普通面粉低筋面都可以。搅拌匀称后加牛奶，一点一点加。加完之后紫薯泥就变的有黏性。'}, {'id': 3, 'img': 'http://s2.cdn.xiachufang.com/57ce88c2939f11e6b87c0242ac110003_1836w_1836h.jpg?imageView2/2/w/300/interlace/1/q/90', 'information': '把紫薯泥揉成面团。我一直都揉不好面，一生的痛啊'}, {'id': 4, 'img': 'http://s1.cdn.xiachufang.com/58bd4dea939f11e6a9a10242ac110002_720w_720h.jpg@2o_50sh_1pr_1l_300w_90q_1wh', 'information': '把紫薯泥搓成球状，放在芝麻里滚一圈，尽量都能沾到芝麻。'}, {'id': 5, 'img': 'http://s1.cdn.xiachufang.com/592cbe6e939f11e6a9a10242ac110002_720w_720h.jpg@2o_50sh_1pr_1l_300w_90q_1wh', 'information': '用手依次把它们压成饼，放入烤箱，上下火150度烤15分钟左右。不过每家烤箱脾气不一样，自己掌握吧。没有烤箱的，电饼档或者平底锅，加少量油，小火煎熟。'}]");
        note.setTip("脱脂牛奶对减肥效果更好哦");
        note.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        Note saveObject=noteRepository.saveAndFlush(note);
        int id=saveObject.getNoteID();
        System.out.println(id);
        note.setNoteID(id);
        noteRepository.delete(note);
    }

    @Test
    public void findByUserIDAndNoteNameLike() {
        Pageable pageable = new PageRequest(0, 2);
        assertEquals(63, noteRepository.findByUserIDAndNoteNameLike(10,"饮", pageable).getContent().get(0).getNoteID());
    }
}