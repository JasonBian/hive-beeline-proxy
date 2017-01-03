package com.jj.dbClient;

/**
 * Created by weizh on 2016/8/16.
 */
public class ClientFactory {
    public MyClient createClient(String type) {
        MyClient client = null;
        if(type.equals("hivejdbc")) {
            client = new HiveJdbc();
        }else if (type.equals("mysqljdbc") ){
            client = new MysqlJdbc();
        }
        return client;
    }
}
