package edu.nju.cookery.service.impl;

import edu.nju.cookery.Application;
import edu.nju.cookery.service.NoteService;
import edu.nju.cookery.util.DateHelper;
import edu.nju.cookery.vo.NewNoteVO;
import edu.nju.cookery.vo.UpdateNoteVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class NoteServiceImplTest {

    @Autowired
    NoteService noteService;

    @Test
    public void getBlogListByUserID() {
        assertEquals(1, noteService.getBlogListByUserID(1).get(0).getNoteId());
        assertEquals(10, noteService.getBlogListByUserID(2).get(0).getNoteId());
    }

    @Test
    public void getCollectedBlog() {
        assertEquals(8, noteService.getCollectedBlog(1).size());
        assertEquals(4, noteService.getCollectedBlog(2).size());
    }

    @Test
    public void getTopPopularNote() {
        assertEquals(38, noteService.getTopPopularNote(4).get(0).getNoteId());
    }

    @Test
    public void getNoteListByUserIdAndPage() {
        assertEquals(11, noteService.getNoteListByUserIdAndPage(2,0).get(1).getNoteId());
        assertEquals(37, noteService.getNoteListByUserIdAndPage(5,1).get(3).getNoteId());
    }

    @Test
    public void getIndexRecommend() {

        HashMap<String, Object> indexRecommend = noteService.getIndexRecommend();
        assertNotNull(indexRecommend.get("month"));
        assertNotNull(indexRecommend.get("recommend"));
        assertNotNull(indexRecommend.get("hot"));
    }

    @Test
    public void addCollect() {
        assertEquals(0,noteService.addCollect(3,13));
        assertEquals(1,noteService.addCollect(3,13));
    }

    @Test
    public void addLike() {
        assertEquals(0,noteService.addCollect(3,13));
        assertEquals(1,noteService.addCollect(3,13));
    }

    @Test
    public void isLike(){
        assertEquals(0,noteService.isLike(1,59));
        assertEquals(1,noteService.isLike(1,1));
    }

    @Test
    public void isCollect(){
        assertEquals(0,noteService.isCollect(1,20));
        assertEquals(1,noteService.isCollect(1,1));
    }


//    @Test success
    public void testCreateNote(){
        List<String> subTagList=new ArrayList<String>();
        subTagList.add("减肥");
        subTagList.add("素菜");
        NewNoteVO newNoteVO=new NewNoteVO(13,"减肥必备沙拉","http://s2.cdn.xiachufang.com/5e019284893111e6a9a10242ac110002_1125w_1125h.jpg?imageView2/2/w/660/interlace/1/q/90",
                "减肥神器","\"[{'unit': '', 'name': '紫薯'}, {'unit': '', 'name': '糯米粉或面粉'}, {'unit': '', 'name': '牛奶（减肥可用脱脂牛奶）'}",
                "[{'id': 1, 'img': 'http://s2.cdn.xiachufang.com/55855000939f11e6a9a10242ac110002_1836w_1836h.jpg?imageView2/2/w/300/interlace/1/q/90', 'information': '紫薯蒸熟后压成紫薯泥，压的越细腻口感越好。然后加入白糖，糖的用量根据自己口味放吧。'}, {'id': 2, 'img': 'http://s2.cdn.xiachufang.com/56842012939f11e6a9a10242ac110002_1836w_1836h.jpg?imageView2/2/w/300/interlace/1/q/90', 'information': '加糯米粉，没有糯米粉的加普通面粉低筋面都可以。搅拌匀称后加牛奶，一点一点加。加完之后紫薯泥就变的有黏性。'}, {'id': 3, 'img': 'http://s2.cdn.xiachufang.com/57ce88c2939f11e6b87c0242ac110003_1836w_1836h.jpg?imageView2/2/w/300/interlace/1/q/90', 'information': '把紫薯泥揉成面团。我一直都揉不好面，一生的痛啊'}, {'id': 4, 'img': 'http://s1.cdn.xiachufang.com/58bd4dea939f11e6a9a10242ac110002_720w_720h.jpg@2o_50sh_1pr_1l_300w_90q_1wh', 'information': '把紫薯泥搓成球状，放在芝麻里滚一圈，尽量都能沾到芝麻。'}, {'id': 5, 'img': 'http://s1.cdn.xiachufang.com/592cbe6e939f11e6a9a10242ac110002_720w_720h.jpg@2o_50sh_1pr_1l_300w_90q_1wh', 'information': '用手依次把它们压成饼，放入烤箱，上下火150度烤15分钟左右。不过每家烤箱脾气不一样，自己掌握吧。没有烤箱的，电饼档或者平底锅，加少量油，小火煎熟。'}]",
                new Timestamp(System.currentTimeMillis()),"脱脂牛奶对减肥效果更好哦",subTagList);


        assertEquals(0,noteService.createNote(newNoteVO));
    }

    @Test
    public void getNoteUpdateInfo(){
        UpdateNoteVO noteVO=noteService.getNoteUpdateInfo(183);
        System.out.println(noteVO);
    }
}