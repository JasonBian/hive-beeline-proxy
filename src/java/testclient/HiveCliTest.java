package testclient;

import com.jj.dbClient.HiveJdbc;

import java.util.List;

/**
 * Created by weizh on 2017/1/3.
 */
public class HiveCliTest {
    public static void main(String [] args ) {
        List res = new HiveJdbc().output("jdbc:hive2://192.168.8.184:10000","show databases");
        System.out.println(res);
    }
}
