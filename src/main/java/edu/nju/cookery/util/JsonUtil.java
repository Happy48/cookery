package edu.nju.cookery.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 简单键值对生成Json字符串工具
 */
public class JsonUtil {

    public static String toJson(HashMap<String,String> map){
        JSONObject jsonObject = new JSONObject();
        Set<String> set=map.keySet();
        for (String key : set) {
            jsonObject.put(key,map.get(key));
        }

        return jsonObject.toString();
    }

    public static Map<String,String> fromString(String string){
        JSONObject jsonObject=JSONObject.fromObject(string);

        Set<String> set=jsonObject.keySet();

        HashMap<String,String> result=new HashMap<>();

        for (String key:set){
            result.put(key,jsonObject.getString(key));
        }
        return result;
    }

    public static String toJson(List list){
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }
}
