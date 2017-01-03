package com.jj.dbClient;

import java.util.List;

/**
 * Created by weizh on 2016/8/15.
 */
public interface MyClient {

    List output(String url, String sql);
    List<Object> outputId(String url, String sql, int col);
}
