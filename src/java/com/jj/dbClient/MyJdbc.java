package com.jj.dbClient;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by weizh on 2016/8/12.
 */
public class MyJdbc implements MyClient {

    public List<Object> output(String url, String sql){
        String driverName = "org.apache.hive.jdbc.HiveDriver";
        String user = "root";
        String password = "123456";
        return jdbc(driverName, user, password, url, sql);
    }

    public List<Object> outputId(String url, String sql, int col) {
        return null;
    }


    public List<Object> outputCol(String  driverName, String user, String password, String url, String sql, int col) {
        ResultSet res;
        List list = new ArrayList<Object>();
        Connection conn = SqlConnection(driverName, user, password, url);
        try {
            Statement stmt = conn.createStatement();
            String judgeSql = sql.toLowerCase().split("\\s+")[0];
            res = stmt.executeQuery(sql);

            while (res.next()) {
                String str = res.getString(col);
                list.add(str);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

         return list;

    }

    public List<Object> jdbc(String driverName, String user, String password, String url, String sql ){

        ResultSet res;
        List list = new ArrayList<Object>();

        Connection conn = SingleMysqlConn.getInstance(driverName, user, password, url).conn;

        try {
            //conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String judgeSql = sql.toLowerCase().split("\\s+")[0];

            if(judgeSql.contains("create") || judgeSql.contains("insert") || judgeSql.contains("delete")
                    || judgeSql.contains("drop") || judgeSql.contains("update") || judgeSql.contains("alter")){

                int eRes = stmt.executeUpdate(sql);
                list.add(eRes);
               /* boolean eRes = stmt.execute(sql);
                if(eRes){
                    list.add("Success");
                }else{
                    list.add("Failed");
                }*/


            }else if(judgeSql.contains("select") || judgeSql.contains("desc") || judgeSql.contains("show")){
                res = stmt.executeQuery(sql);
                while(res.next()){
                    int col = res.getMetaData().getColumnCount();
                    List tmplist = new ArrayList<Object>();
                    for(int i=1;i<=col;i++){
                        Object element = res.getObject(i);

                        /*System.out.println("columnType : " + res.getMetaData().getColumnTypeName(i) +
                                           " colunmnName : " + res.getMetaData().getColumnName(i)+
                                           " value type " + element.getClass().getName());*/
                        tmplist.add(element);
                    }
                    //String entry = ToJson.toJson(tmplist);
                    //list.add(entry);
                    list.add(tmplist);
                }

            }else{
                res = stmt.executeQuery(sql);
                while (res.next()) {
                    Object str = res.getObject(1);
                    //if(str.contains(":struct") && str.contains("{")){
                        //list.add(StringFixer.structFixer(str));
                        //list.add(str);
                    //}
                    list.add(str);
                }
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }/*finally{
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/


        return list;

    }

    private Connection SqlConnection(String driverName, String user, String password, String url) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }



    public static void main(String [] args ) {
        String driverName = "org.apache.hive.jdbc.HiveDriver";
        //String sql = "desc abnormaluser.simuappear_abnormaluser_day_island_abusergroup";
        String sql = "show table EXTENDED in abnormaluser like simuappear_abnormaluser_day_island_abusergroup";
        String user = "hdfs";
        String password = "1234";
        String url = "jdbc:hive2://192.168.10.151:10000";
        //List<Object> list  = new MyJdbc().jdbc(driverName, user, password, url, sql);
        List<Object> list = new ClientFactory().createClient("hivejdbc").output(url, sql);

        System.out.println(ToJson.toJson(AddJsonHead.addhead(list)));

    }


}
