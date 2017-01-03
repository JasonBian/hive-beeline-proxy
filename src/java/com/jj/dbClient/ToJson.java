package com.jj.dbClient;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by weizh on 2016/8/15.
 */
public class ToJson {
    public static String toJson(Object src){
        Gson gson = new Gson();
        String res =  gson.toJson(src);
        return res;
    }
    public static void main(String [] args ) {
        System.out.println("123");
        Map map = new HashMap<String, Object>();
        map.put("name","product");
        map.put("comment", "all of the products");
        List list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        Map tmpmap = new HashMap<String,Object>();
        tmpmap.put("aaa",list);
        map.put("theme id", tmpmap);
        Gson gson = new Gson();
        System.out.println(gson.toJson(map));
    }
}
