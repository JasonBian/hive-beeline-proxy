package testclient;

import org.apache.hive.beeline.BeeLine;

import java.io.IOException;
import java.sql.*;

/**
 * Created by weizh on 2016/12/28.
 */
public class MyCli {
    private static final String driverName = "org.apache.hive.jdbc.HiveDriver";
    private static final String BEELINE_EXIT = "beeline.system.exit";
    private static Connection con = null;
    public static void main(String [] args ){
        String host = "192.168.8.184";
        String port = "10000";
        String proxyUser = "hdfs";
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //String url = "jdbc:hive2://" + host + ":" + port + "/bill;hive.server2.proxy.user=" + proxyUser;
        String url = "jdbc:hive2://" + host + ":" + port + "/bill";
        String [] beeLineArgs = new String[] { "-u", url, "-n", "hdfs", "-p", "bar", "-e", "show databases"};
        try {
            BeeLine.main(beeLineArgs);
            //BeeLine.main(new String [] { "show", "databases" } );
        } catch (IOException e) {
            e.printStackTrace();
        }
        String sqlStmt = "show databases";
        Statement stmt = null;
        try {
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(sqlStmt);

            ResultSetMetaData meta = res.getMetaData();
            System.out.println("Resultset has " + meta.getColumnCount() + " columns");
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.println("Column #" + i + " Name: " + meta.getColumnName(i) +
                        " Type: " + meta.getColumnType(i));
            }

            while (res.next()) {
                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    System.out.println("Column #" + i + ": " + res.getString(i));
                }
            }
            res.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    };
}
