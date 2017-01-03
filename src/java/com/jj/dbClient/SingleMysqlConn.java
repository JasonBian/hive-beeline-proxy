package com.jj.dbClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by weizh on 2016/11/16.
 */
public class SingleMysqlConn {
    Connection conn = null;
    String url = null;

    volatile private static SingleMysqlConn instance = null;
    private SingleMysqlConn(String driverName, String user, String password, String url){
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        this.url = url;
        try {
            connection = DriverManager.getConnection(this.url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn = connection;

    }
    public static SingleMysqlConn getInstance(String driverName, String user, String password, String url) {
        try {
            if(instance != null && instance.conn!=null &&  instance.url.equals(url)){//懒汉式
                return instance;
            }else{
                //创建实例之前可能会有一些准备性的耗时工作
                Thread.sleep(300);
                synchronized (SingleMysqlConn.class) {
                    if(instance == null){//二次检查
                        instance = new SingleMysqlConn(driverName, user, password, url);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return instance;
    }

}
