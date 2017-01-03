package com.jj.dbClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by weizh on 2016/8/15.
 */
public class AddJsonHead {
    public static  Map<Object, List<Object>> addhead(List<Object> list) {
        Map<Object, List<Object>> map = new HashMap<Object, List<Object>>();
        map.put("dbs",list);
        return map;


    }
}
