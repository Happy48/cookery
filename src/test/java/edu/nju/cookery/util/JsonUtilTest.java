package edu.nju.cookery.util;

import edu.nju.cookery.vo.FollowVO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class JsonUtilTest {

    @Test
    public void toJson() {
        HashMap<String,String> map=new HashMap<>();
        map.put("test","test");
        JsonUtil.toJson(map);
        assertEquals("{\"test\":\"test\"}",JsonUtil.toJson(map));
    }

    @Test
    public void fromString() {
        Map map = JsonUtil.fromString("{\"test\":\"test\"}");
        assertEquals("test",map.get("test"));
    }

    @Test
    public void toJson1() {
        List<FollowVO> list=new ArrayList<>();
        list.add(new FollowVO("name1","name3"));
        list.add(new FollowVO("name2","name4"));

        assertEquals("[{\"icon\":\"name3\",\"name\":\"name1\"},{\"icon\":\"name4\",\"name\":\"name2\"}]",JsonUtil.toJson(list));
    }

}