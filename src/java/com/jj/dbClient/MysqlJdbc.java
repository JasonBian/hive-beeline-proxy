package com.jj.dbClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weizh on 2016/8/18.
 */
public class MysqlJdbc implements MyClient{
    String driverName = "com.mysql.jdbc.Driver";
    /*String user = "root";
    String password = "123456";*/
    String user = "tkpoc";
    String password = "k5e46UhzY";


    public List<Object> output(String url, String sql){
        return new MyJdbc().jdbc(driverName, user, password, url, sql);
    }


    public List<Object>  outputId(String url, String sql, int col) {
        return new MyJdbc().outputCol(driverName, user, password, url, sql, col);
    }
    public static void RestPlainExtractedTables(){
        List<String> list = new ArrayList<String>();
        String sql = "drop table plain_job.extracted";
        list.add(sql);
        sql = "create table plain_job.extracted" +
                "(id varchar(50)  not null, " +
                "submitTime varchar(50) , " +
                "JRuningTime BIGINT ," +
                "JDelayTime BIGINT, " +
                "TRunTimeDev BIGINT, " +
                "TByteReadDev DOUBLE, " +
                "TByteReadAvg BIGINT, " +
                "JDealDataPS BIGINT, " +
                "JShuffleBytes BIGINT, " +
                "PRIMARY KEY (id))";
        list.add(sql);
        String url = "jdbc:mysql://192.168.10.135:3306";
        MysqlJdbc mj = new MysqlJdbc();

        for(String str:list){
            mj.output(url, str);
        }

    }
    public static void RestPlainJobTables(){
        List<String> list = new ArrayList<String>();
        String sql = "drop table plain_job.job";
        list.add(sql);

        sql = "drop table plain_job.task";
        list.add(sql);

        sql = "create table plain_job.job" +
                "(id varchar(50)  not null, " +
                "submitTime varchar(50) , " +
                "startTime varchar(50) ," +
                "finishTime varchar(50) ," +
                "name text ," +
                "queue varchar(50) ," +
                "user varchar(50) ," +
                "state varchar(50) ," +
                "mapsTotal int(50) ," +
                "mapsCompleted int(50) ," +
                "reducesTotal int(50) ," +
                "reducesCompleted int(50) ," +
                "uberized varchar(50) ," +
                "diagnostics text ," +
                "avgMapTime int ," +
                "avgReduceTime int ," +
                "avgShuffleTime int ," +
                "avgMergeTime int ," +
                "failedReduceAttempts int(50) ," +
                "killedReduceAttempts int(50) ," +
                "successfulReduceAttempts int(50) ," +
                "failedMapAttempts int(50) ," +
                "killedMapAttempts int(50) ," +
                "successfulMapAttempts int(50) ," +
                "FILE_BYTES_READ_mapCounterValue BIGINT," +
                "FILE_BYTES_READ_reduceCounterValue BIGINT," +
                "FILE_BYTES_READ_totalCounterValue BIGINT," +
                "FILE_BYTES_WRITTEN_mapCounterValue BIGINT," +
                "FILE_BYTES_WRITTEN_reduceCounterValue BIGINT," +
                "FILE_BYTES_WRITTEN_totalCounterValue BIGINT," +
                "FILE_READ_OPS_mapCounterValue BIGINT," +
                "FILE_READ_OPS_reduceCounterValue BIGINT," +
                "FILE_READ_OPS_totalCounterValue BIGINT," +
                "FILE_LARGE_READ_OPS_mapCounterValue BIGINT," +
                "FILE_LARGE_READ_OPS_reduceCounterValue BIGINT," +
                "FILE_LARGE_READ_OPS_totalCounterValue BIGINT," +
                "FILE_WRITE_OPS_mapCounterValue BIGINT," +
                "FILE_WRITE_OPS_reduceCounterValue BIGINT," +
                "FILE_WRITE_OPS_totalCounterValue BIGINT," +
                "HDFS_BYTES_READ_mapCounterValue BIGINT," +
                "HDFS_BYTES_READ_reduceCounterValue BIGINT," +
                "HDFS_BYTES_READ_totalCounterValue BIGINT," +
                "HDFS_BYTES_WRITTEN_mapCounterValue BIGINT," +
                "HDFS_BYTES_WRITTEN_reduceCounterValue BIGINT," +
                "HDFS_BYTES_WRITTEN_totalCounterValue BIGINT," +
                "HDFS_READ_OPS_mapCounterValue BIGINT," +
                "HDFS_READ_OPS_reduceCounterValue BIGINT," +
                "HDFS_READ_OPS_totalCounterValue BIGINT," +
                "HDFS_LARGE_READ_OPS_mapCounterValue BIGINT," +
                "HDFS_LARGE_READ_OPS_reduceCounterValue BIGINT," +
                "HDFS_LARGE_READ_OPS_totalCounterValue BIGINT," +
                "HDFS_WRITE_OPS_mapCounterValue BIGINT," +
                "HDFS_WRITE_OPS_reduceCounterValue BIGINT," +
                "HDFS_WRITE_OPS_totalCounterValue BIGINT," +
                "NUM_KILLED_REDUCES_mapCounterValue BIGINT," +
                "NUM_KILLED_REDUCES_reduceCounterValue BIGINT," +
                "NUM_KILLED_REDUCES_totalCounterValue BIGINT," +
                "TOTAL_LAUNCHED_MAPS_mapCounterValue BIGINT," +
                "TOTAL_LAUNCHED_MAPS_reduceCounterValue BIGINT," +
                "TOTAL_LAUNCHED_MAPS_totalCounterValue BIGINT," +
                "TOTAL_LAUNCHED_REDUCES_mapCounterValue BIGINT," +
                "TOTAL_LAUNCHED_REDUCES_reduceCounterValue BIGINT," +
                "TOTAL_LAUNCHED_REDUCES_totalCounterValue BIGINT," +
                "OTHER_LOCAL_MAPS_mapCounterValue BIGINT," +
                "OTHER_LOCAL_MAPS_reduceCounterValue BIGINT," +
                "OTHER_LOCAL_MAPS_totalCounterValue BIGINT," +
                "DATA_LOCAL_MAPS_mapCounterValue BIGINT," +
                "DATA_LOCAL_MAPS_reduceCounterValue BIGINT," +
                "DATA_LOCAL_MAPS_totalCounterValue BIGINT," +
                "RACK_LOCAL_MAPS_mapCounterValue BIGINT," +
                "RACK_LOCAL_MAPS_reduceCounterValue BIGINT," +
                "RACK_LOCAL_MAPS_totalCounterValue BIGINT," +
                "SLOTS_MILLIS_MAPS_mapCounterValue BIGINT," +
                "SLOTS_MILLIS_MAPS_reduceCounterValue BIGINT," +
                "SLOTS_MILLIS_MAPS_totalCounterValue BIGINT," +
                "SLOTS_MILLIS_REDUCES_mapCounterValue BIGINT," +
                "SLOTS_MILLIS_REDUCES_reduceCounterValue BIGINT," +
                "SLOTS_MILLIS_REDUCES_totalCounterValue BIGINT," +
                "MILLIS_MAPS_mapCounterValue BIGINT," +
                "MILLIS_MAPS_reduceCounterValue BIGINT," +
                "MILLIS_MAPS_totalCounterValue BIGINT," +
                "MILLIS_REDUCES_mapCounterValue BIGINT," +
                "MILLIS_REDUCES_reduceCounterValue BIGINT," +
                "MILLIS_REDUCES_totalCounterValue BIGINT," +
                "VCORES_MILLIS_MAPS_mapCounterValue BIGINT," +
                "VCORES_MILLIS_MAPS_reduceCounterValue BIGINT," +
                "VCORES_MILLIS_MAPS_totalCounterValue BIGINT," +
                "VCORES_MILLIS_REDUCES_mapCounterValue BIGINT," +
                "VCORES_MILLIS_REDUCES_reduceCounterValue BIGINT," +
                "VCORES_MILLIS_REDUCES_totalCounterValue BIGINT," +
                "MB_MILLIS_MAPS_mapCounterValue BIGINT," +
                "MB_MILLIS_MAPS_reduceCounterValue BIGINT," +
                "MB_MILLIS_MAPS_totalCounterValue BIGINT," +
                "MB_MILLIS_REDUCES_mapCounterValue BIGINT," +
                "MB_MILLIS_REDUCES_reduceCounterValue BIGINT," +
                "MB_MILLIS_REDUCES_totalCounterValue BIGINT," +
                "MAP_INPUT_RECORDS_mapCounterValue BIGINT," +
                "MAP_INPUT_RECORDS_reduceCounterValue BIGINT," +
                "MAP_INPUT_RECORDS_totalCounterValue BIGINT," +
                "MAP_OUTPUT_RECORDS_mapCounterValue BIGINT," +
                "MAP_OUTPUT_RECORDS_reduceCounterValue BIGINT," +
                "MAP_OUTPUT_RECORDS_totalCounterValue BIGINT," +
                "MAP_OUTPUT_BYTES_mapCounterValue BIGINT," +
                "MAP_OUTPUT_BYTES_reduceCounterValue BIGINT," +
                "MAP_OUTPUT_BYTES_totalCounterValue BIGINT," +
                "MAP_OUTPUT_MATERIALIZED_BYTES_mapCounterValue BIGINT," +
                "MAP_OUTPUT_MATERIALIZED_BYTES_reduceCounterValue BIGINT," +
                "MAP_OUTPUT_MATERIALIZED_BYTES_totalCounterValue BIGINT," +
                "SPLIT_RAW_BYTES_mapCounterValue BIGINT," +
                "SPLIT_RAW_BYTES_reduceCounterValue BIGINT," +
                "SPLIT_RAW_BYTES_totalCounterValue BIGINT," +
                "COMBINE_INPUT_RECORDS_mapCounterValue BIGINT," +
                "COMBINE_INPUT_RECORDS_reduceCounterValue BIGINT," +
                "COMBINE_INPUT_RECORDS_totalCounterValue BIGINT," +
                "COMBINE_OUTPUT_RECORDS_mapCounterValue BIGINT," +
                "COMBINE_OUTPUT_RECORDS_reduceCounterValue BIGINT," +
                "COMBINE_OUTPUT_RECORDS_totalCounterValue BIGINT," +
                "REDUCE_INPUT_GROUPS_mapCounterValue BIGINT," +
                "REDUCE_INPUT_GROUPS_reduceCounterValue BIGINT," +
                "REDUCE_INPUT_GROUPS_totalCounterValue BIGINT," +
                "REDUCE_SHUFFLE_BYTES_mapCounterValue BIGINT," +
                "REDUCE_SHUFFLE_BYTES_reduceCounterValue BIGINT," +
                "REDUCE_SHUFFLE_BYTES_totalCounterValue BIGINT," +
                "REDUCE_INPUT_RECORDS_mapCounterValue BIGINT," +
                "REDUCE_INPUT_RECORDS_reduceCounterValue BIGINT," +
                "REDUCE_INPUT_RECORDS_totalCounterValue BIGINT," +
                "REDUCE_OUTPUT_RECORDS_mapCounterValue BIGINT," +
                "REDUCE_OUTPUT_RECORDS_reduceCounterValue BIGINT," +
                "REDUCE_OUTPUT_RECORDS_totalCounterValue BIGINT," +
                "SPILLED_RECORDS_mapCounterValue BIGINT," +
                "SPILLED_RECORDS_reduceCounterValue BIGINT," +
                "SPILLED_RECORDS_totalCounterValue BIGINT," +
                "SHUFFLED_MAPS_mapCounterValue BIGINT," +
                "SHUFFLED_MAPS_reduceCounterValue BIGINT," +
                "SHUFFLED_MAPS_totalCounterValue BIGINT," +
                "FAILED_SHUFFLE_mapCounterValue BIGINT," +
                "FAILED_SHUFFLE_reduceCounterValue BIGINT," +
                "FAILED_SHUFFLE_totalCounterValue BIGINT," +
                "MERGED_MAP_OUTPUTS_mapCounterValue BIGINT," +
                "MERGED_MAP_OUTPUTS_reduceCounterValue BIGINT," +
                "MERGED_MAP_OUTPUTS_totalCounterValue BIGINT," +
                "GC_TIME_MILLIS_mapCounterValue BIGINT," +
                "GC_TIME_MILLIS_reduceCounterValue BIGINT," +
                "GC_TIME_MILLIS_totalCounterValue BIGINT," +
                "CPU_MILLISECONDS_mapCounterValue BIGINT," +
                "CPU_MILLISECONDS_reduceCounterValue BIGINT," +
                "CPU_MILLISECONDS_totalCounterValue BIGINT," +
                "PHYSICAL_MEMORY_BYTES_mapCounterValue BIGINT," +
                "PHYSICAL_MEMORY_BYTES_reduceCounterValue BIGINT," +
                "PHYSICAL_MEMORY_BYTES_totalCounterValue BIGINT," +
                "VIRTUAL_MEMORY_BYTES_mapCounterValue BIGINT," +
                "VIRTUAL_MEMORY_BYTES_reduceCounterValue BIGINT," +
                "VIRTUAL_MEMORY_BYTES_totalCounterValue BIGINT," +
                "COMMITTED_HEAP_BYTES_mapCounterValue BIGINT," +
                "COMMITTED_HEAP_BYTES_reduceCounterValue BIGINT," +
                "COMMITTED_HEAP_BYTES_totalCounterValue BIGINT," +
                "CREATED_FILES_mapCounterValue BIGINT," +
                "CREATED_FILES_reduceCounterValue BIGINT," +
                "CREATED_FILES_totalCounterValue BIGINT," +
                "DESERIALIZE_ERRORS_mapCounterValue BIGINT," +
                "DESERIALIZE_ERRORS_reduceCounterValue BIGINT," +
                "DESERIALIZE_ERRORS_totalCounterValue BIGINT," +
                "RECORDS_IN_mapCounterValue BIGINT," +
                "RECORDS_IN_reduceCounterValue BIGINT," +
                "RECORDS_IN_totalCounterValue BIGINT," +
                "RECORDS_OUT_0_mapCounterValue BIGINT," +
                "RECORDS_OUT_0_reduceCounterValue BIGINT," +
                "RECORDS_OUT_0_totalCounterValue BIGINT," +
                "RECORDS_OUT_INTERMEDIATE_mapCounterValue BIGINT," +
                "RECORDS_OUT_INTERMEDIATE_reduceCounterValue BIGINT," +
                "RECORDS_OUT_INTERMEDIATE_totalCounterValue BIGINT," +
                "BAD_ID_mapCounterValue BIGINT," +
                "BAD_ID_reduceCounterValue BIGINT," +
                "BAD_ID_totalCounterValue BIGINT," +
                "CONNECTION_mapCounterValue BIGINT," +
                "CONNECTION_reduceCounterValue BIGINT," +
                "CONNECTION_totalCounterValue BIGINT," +
                "IO_ERROR_mapCounterValue BIGINT," +
                "IO_ERROR_reduceCounterValue BIGINT," +
                "IO_ERROR_totalCounterValue BIGINT," +
                "WRONG_LENGTH_mapCounterValue BIGINT," +
                "WRONG_LENGTH_reduceCounterValue BIGINT," +
                "WRONG_LENGTH_totalCounterValue BIGINT," +
                "WRONG_MAP_mapCounterValue BIGINT," +
                "WRONG_MAP_reduceCounterValue BIGINT," +
                "WRONG_MAP_totalCounterValue BIGINT," +
                "WRONG_REDUCE_mapCounterValue BIGINT," +
                "WRONG_REDUCE_reduceCounterValue BIGINT," +
                "WRONG_REDUCE_totalCounterValue BIGINT," +
                "BYTES_READ_mapCounterValue BIGINT," +
                "BYTES_READ_reduceCounterValue BIGINT," +
                "BYTES_READ_totalCounterValue BIGINT," +
                "BYTES_WRITTEN_mapCounterValue BIGINT," +
                "BYTES_WRITTEN_reduceCounterValue BIGINT," +
                "BYTES_WRITTEN_totalCounterValue BIGINT," +
                "runningTime BIGINT," +
                "delayTime BIGINT," +
                "tasks longtext not null," +
                "PRIMARY KEY ( id ))";
        list.add(sql);

        sql = "create table plain_job.task " +
                "(id  varchar(50)  not null, " +
                "startTime varchar(50) ," +
                "finishTime varchar(50) ," +
                "elapsedTime varchar(50) ," +
                "progress varchar(50) ," +
                "state varchar(50) ," +
                "type varchar(50) ," +
                "successfulAttempt varchar(50) ," +
                "FILE_BYTES_READ BIGINT," +
                "FILE_BYTES_WRITTEN BIGINT," +
                "FILE_READ_OPS BIGINT," +
                "FILE_LARGE_READ_OPS BIGINT," +
                "FILE_WRITE_OPS BIGINT," +
                "HDFS_BYTES_READ BIGINT," +
                "HDFS_BYTES_WRITTEN BIGINT," +
                "HDFS_READ_OPS BIGINT," +
                "HDFS_LARGE_READ_OPS BIGINT," +
                "HDFS_WRITE_OPS BIGINT," +
                "MAP_INPUT_RECORDS BIGINT," +
                "MAP_OUTPUT_RECORDS BIGINT," +
                "MAP_OUTPUT_BYTES BIGINT," +
                "MAP_OUTPUT_MATERIALIZED_BYTES BIGINT," +
                "SPLIT_RAW_BYTES BIGINT," +
                "COMBINE_INPUT_RECORDS BIGINT," +
                "COMBINE_OUTPUT_RECORDS BIGINT," +
                "REDUCE_INPUT_GROUPS BIGINT," +
                "REDUCE_SHUFFLE_BYTES BIGINT," +
                "REDUCE_INPUT_RECORDS BIGINT," +
                "REDUCE_OUTPUT_RECORDS BIGINT," +
                "RECORDS_OUT_INTERMEDIATE BIGINT," +
                "RECORDS_OUT_0 BIGINT," +
                "SPILLED_RECORDS BIGINT," +
                "SHUFFLED_MAPS BIGINT," +
                "FAILED_SHUFFLE BIGINT," +
                "MERGED_MAP_OUTPUTS BIGINT," +
                "GC_TIME_MILLIS BIGINT," +
                "CPU_MILLISECONDS BIGINT," +
                "PHYSICAL_MEMORY_BYTES BIGINT," +
                "VIRTUAL_MEMORY_BYTES BIGINT," +
                "COMMITTED_HEAP_BYTES BIGINT," +
                "CREATED_FILES BIGINT," +
                "DESERIALIZE_ERRORS BIGINT," +
                "RECORDS_IN BIGINT," +
                "BAD_ID BIGINT," +
                "CONNECTION BIGINT," +
                "IO_ERROR BIGINT," +
                "WRONG_LENGTH BIGINT," +
                "WRONG_MAP BIGINT," +
                "WRONG_REDUCE BIGINT," +
                "BYTES_READ BIGINT," +
                "BYTES_WRITTEN BIGINT," +
                "runningTime BIGINT," +
                "PRIMARY KEY (id))";
        list.add(sql);

        //String url = "jdbc:mysql://192.168.8.173:3306";
        String url = "jdbc:mysql://192.168.10.135:3306";
        MysqlJdbc mj = new MysqlJdbc();

        for(String str:list){
            mj.output(url, str);
        }

    }
    public static void RestJobTables(){
        List<String> list = new ArrayList<String>();
        String sql = "drop table job.job";
        list.add(sql);
        sql = "drop table job.jobcounters";
        list.add(sql);
        sql = "drop table job.task";
        list.add(sql);
        sql = "drop table job.taskcounters";
        list.add(sql);
        sql = "create table job.job" +
                "(id varchar(50)  not null, " +
                "submitTime varchar(50) , " +
                "startTime varchar(50) ," +
                "finishTime varchar(50) ," +
                "name text ," +
                "queue varchar(50) ," +
                "user varchar(50) ," +
                "state varchar(50) ," +
                "mapsTotal int(50) ," +
                "mapsCompleted int(50) ," +
                "reducesTotal int(50) ," +
                "reducesCompleted int(50) ," +
                "uberized varchar(50) ," +
                "diagnostics text ," +
                "avgMapTime int ," +
                "avgReduceTime int ," +
                "avgShuffleTime int ," +
                "avgMergeTime int ," +
                "failedReduceAttempts int(50) ," +
                "killedReduceAttempts int(50) ," +
                "successfulReduceAttempts int(50) ," +
                "failedMapAttempts int(50) ," +
                "killedMapAttempts int(50) ," +
                "successfulMapAttempts int(50) ," +
                "tasks longtext not null," +
                "PRIMARY KEY ( id ))";
        list.add(sql);
        sql = "create table job.jobcounters " +
                "(id int(10) auto_increment not null, " +
                "jobid varchar(50)  not null, " +
                "counterGroupName text , " +
                "counter text  , " +
                "PRIMARY KEY (id))";
        list.add(sql);
        sql = "create table job.task " +
                "(id  varchar(50)  not null, " +
                "startTime varchar(50) ," +
                "finishTime varchar(50) ," +
                "elapsedTime varchar(50) ," +
                "progress varchar(50) ," +
                "state varchar(50) ," +
                "type varchar(50) ," +
                "successfulAttempt varchar(50) ," +
                "PRIMARY KEY (id))";
        list.add(sql);
        sql = "create table job.taskcounters " +
                "(id int(10) auto_increment not null, " +
                "taskid varchar(50)  not null, " +
                "counterGroupName text , " +
                "counter text  , " +
                "PRIMARY KEY (id))";
        list.add(sql);
        //String url = "jdbc:mysql://192.168.8.173:3306";
        String url = "jdbc:mysql://192.168.10.135:3306";
         MysqlJdbc mj = new MysqlJdbc();

        for(String str:list){
            mj.output(url, str);
        }
    }
    public static void alterColumnType(){
        String url = "jdbc:mysql://192.168.10.135:3306";
        MysqlJdbc mj = new MysqlJdbc();
        String [] taskColums = {"FILE_BYTES_READ","FILE_BYTES_WRITTEN","FILE_READ_OPS","FILE_LARGE_READ_OPS",
                "FILE_WRITE_OPS","HDFS_BYTES_READ","HDFS_BYTES_WRITTEN","HDFS_READ_OPS","HDFS_LARGE_READ_OPS",
                "HDFS_WRITE_OPS","MAP_INPUT_RECORDS","MAP_OUTPUT_RECORDS","MAP_OUTPUT_BYTES",
                "MAP_OUTPUT_MATERIALIZED_BYTES","SPLIT_RAW_BYTES","COMBINE_INPUT_RECORDS",
                "COMBINE_OUTPUT_RECORDS","REDUCE_INPUT_GROUPS","REDUCE_SHUFFLE_BYTES","REDUCE_INPUT_RECORDS",
                "REDUCE_OUTPUT_RECORDS","RECORDS_OUT_INTERMEDIATE","RECORDS_OUT_0","SPILLED_RECORDS","SHUFFLED_MAPS",
                "FAILED_SHUFFLE","MERGED_MAP_OUTPUTS","GC_TIME_MILLIS","CPU_MILLISECONDS","PHYSICAL_MEMORY_BYTES",
                "VIRTUAL_MEMORY_BYTES","COMMITTED_HEAP_BYTES","CREATED_FILES","DESERIALIZE_ERRORS","RECORDS_IN",
                "BAD_ID","CONNECTION","IO_ERROR","WRONG_LENGTH","WRONG_MAP","WRONG_REDUCE","BYTES_READ",
                "BYTES_WRITTEN","runningTime"};
        String [] columns = {"FILE_BYTES_READ_mapCounterValue","FILE_BYTES_READ_reduceCounterValue",
                "FILE_BYTES_READ_totalCounterValue","FILE_BYTES_WRITTEN_mapCounterValue",
                "FILE_BYTES_WRITTEN_reduceCounterValue","FILE_BYTES_WRITTEN_totalCounterValue",
                "FILE_READ_OPS_mapCounterValue","FILE_READ_OPS_reduceCounterValue","FILE_READ_OPS_totalCounterValue",
                "FILE_LARGE_READ_OPS_mapCounterValue","FILE_LARGE_READ_OPS_reduceCounterValue",
                "FILE_LARGE_READ_OPS_totalCounterValue","FILE_WRITE_OPS_mapCounterValue",
                "FILE_WRITE_OPS_reduceCounterValue","FILE_WRITE_OPS_totalCounterValue",
                "HDFS_BYTES_READ_mapCounterValue","HDFS_BYTES_READ_reduceCounterValue",
                "HDFS_BYTES_READ_totalCounterValue","HDFS_BYTES_WRITTEN_mapCounterValue",
                "HDFS_BYTES_WRITTEN_reduceCounterValue","HDFS_BYTES_WRITTEN_totalCounterValue",
                "HDFS_READ_OPS_mapCounterValue","HDFS_READ_OPS_reduceCounterValue","HDFS_READ_OPS_totalCounterValue",
                "HDFS_LARGE_READ_OPS_mapCounterValue","HDFS_LARGE_READ_OPS_reduceCounterValue",
                "HDFS_LARGE_READ_OPS_totalCounterValue","HDFS_WRITE_OPS_mapCounterValue",
                "HDFS_WRITE_OPS_reduceCounterValue","HDFS_WRITE_OPS_totalCounterValue",
                "NUM_KILLED_REDUCES_mapCounterValue","NUM_KILLED_REDUCES_reduceCounterValue",
                "NUM_KILLED_REDUCES_totalCounterValue","TOTAL_LAUNCHED_MAPS_mapCounterValue",
                "TOTAL_LAUNCHED_MAPS_reduceCounterValue","TOTAL_LAUNCHED_MAPS_totalCounterValue",
                "TOTAL_LAUNCHED_REDUCES_mapCounterValue","TOTAL_LAUNCHED_REDUCES_reduceCounterValue",
                "TOTAL_LAUNCHED_REDUCES_totalCounterValue","OTHER_LOCAL_MAPS_mapCounterValue",
                "OTHER_LOCAL_MAPS_reduceCounterValue","OTHER_LOCAL_MAPS_totalCounterValue",
                "DATA_LOCAL_MAPS_mapCounterValue","DATA_LOCAL_MAPS_reduceCounterValue",
                "DATA_LOCAL_MAPS_totalCounterValue","RACK_LOCAL_MAPS_mapCounterValue",
                "RACK_LOCAL_MAPS_reduceCounterValue","RACK_LOCAL_MAPS_totalCounterValue",
                "SLOTS_MILLIS_MAPS_mapCounterValue","SLOTS_MILLIS_MAPS_reduceCounterValue",
                "SLOTS_MILLIS_MAPS_totalCounterValue","SLOTS_MILLIS_REDUCES_mapCounterValue",
                "SLOTS_MILLIS_REDUCES_reduceCounterValue","SLOTS_MILLIS_REDUCES_totalCounterValue",
                "MILLIS_MAPS_mapCounterValue","MILLIS_MAPS_reduceCounterValue","MILLIS_MAPS_totalCounterValue",
                "MILLIS_REDUCES_mapCounterValue","MILLIS_REDUCES_reduceCounterValue","MILLIS_REDUCES_totalCounterValue",
                "VCORES_MILLIS_MAPS_mapCounterValue","VCORES_MILLIS_MAPS_reduceCounterValue",
                "VCORES_MILLIS_MAPS_totalCounterValue","VCORES_MILLIS_REDUCES_mapCounterValue",
                "VCORES_MILLIS_REDUCES_reduceCounterValue","VCORES_MILLIS_REDUCES_totalCounterValue",
                "MB_MILLIS_MAPS_mapCounterValue","MB_MILLIS_MAPS_reduceCounterValue",
                "MB_MILLIS_MAPS_totalCounterValue","MB_MILLIS_REDUCES_mapCounterValue",
                "MB_MILLIS_REDUCES_reduceCounterValue","MB_MILLIS_REDUCES_totalCounterValue",
                "MAP_INPUT_RECORDS_mapCounterValue","MAP_INPUT_RECORDS_reduceCounterValue",
                "MAP_INPUT_RECORDS_totalCounterValue","MAP_OUTPUT_RECORDS_mapCounterValue",
                "MAP_OUTPUT_RECORDS_reduceCounterValue","MAP_OUTPUT_RECORDS_totalCounterValue",
                "MAP_OUTPUT_BYTES_mapCounterValue","MAP_OUTPUT_BYTES_reduceCounterValue",
                "MAP_OUTPUT_BYTES_totalCounterValue","MAP_OUTPUT_MATERIALIZED_BYTES_mapCounterValue",
                "MAP_OUTPUT_MATERIALIZED_BYTES_reduceCounterValue","MAP_OUTPUT_MATERIALIZED_BYTES_totalCounterValue",
                "SPLIT_RAW_BYTES_mapCounterValue","SPLIT_RAW_BYTES_reduceCounterValue",
                "SPLIT_RAW_BYTES_totalCounterValue","COMBINE_INPUT_RECORDS_mapCounterValue",
                "COMBINE_INPUT_RECORDS_reduceCounterValue","COMBINE_INPUT_RECORDS_totalCounterValue",
                "COMBINE_OUTPUT_RECORDS_mapCounterValue","COMBINE_OUTPUT_RECORDS_reduceCounterValue",
                "COMBINE_OUTPUT_RECORDS_totalCounterValue","REDUCE_INPUT_GROUPS_mapCounterValue",
                "REDUCE_INPUT_GROUPS_reduceCounterValue","REDUCE_INPUT_GROUPS_totalCounterValue",
                "REDUCE_SHUFFLE_BYTES_mapCounterValue","REDUCE_SHUFFLE_BYTES_reduceCounterValue",
                "REDUCE_SHUFFLE_BYTES_totalCounterValue","REDUCE_INPUT_RECORDS_mapCounterValue",
                "REDUCE_INPUT_RECORDS_reduceCounterValue","REDUCE_INPUT_RECORDS_totalCounterValue",
                "REDUCE_OUTPUT_RECORDS_mapCounterValue","REDUCE_OUTPUT_RECORDS_reduceCounterValue",
                "REDUCE_OUTPUT_RECORDS_totalCounterValue","SPILLED_RECORDS_mapCounterValue",
                "SPILLED_RECORDS_reduceCounterValue","SPILLED_RECORDS_totalCounterValue",
                "SHUFFLED_MAPS_mapCounterValue","SHUFFLED_MAPS_reduceCounterValue",
                "SHUFFLED_MAPS_totalCounterValue","FAILED_SHUFFLE_mapCounterValue",
                "FAILED_SHUFFLE_reduceCounterValue","FAILED_SHUFFLE_totalCounterValue",
                "MERGED_MAP_OUTPUTS_mapCounterValue","MERGED_MAP_OUTPUTS_reduceCounterValue",
                "MERGED_MAP_OUTPUTS_totalCounterValue","GC_TIME_MILLIS_mapCounterValue",
                "GC_TIME_MILLIS_reduceCounterValue","GC_TIME_MILLIS_totalCounterValue",
                "CPU_MILLISECONDS_mapCounterValue","CPU_MILLISECONDS_reduceCounterValue",
                "CPU_MILLISECONDS_totalCounterValue","PHYSICAL_MEMORY_BYTES_mapCounterValue",
                "PHYSICAL_MEMORY_BYTES_reduceCounterValue","PHYSICAL_MEMORY_BYTES_totalCounterValue",
                "VIRTUAL_MEMORY_BYTES_mapCounterValue","VIRTUAL_MEMORY_BYTES_reduceCounterValue",
                "VIRTUAL_MEMORY_BYTES_totalCounterValue","COMMITTED_HEAP_BYTES_mapCounterValue",
                "COMMITTED_HEAP_BYTES_reduceCounterValue","COMMITTED_HEAP_BYTES_totalCounterValue",
                "CREATED_FILES_mapCounterValue","CREATED_FILES_reduceCounterValue",
                "CREATED_FILES_totalCounterValue","DESERIALIZE_ERRORS_mapCounterValue",
                "DESERIALIZE_ERRORS_reduceCounterValue","DESERIALIZE_ERRORS_totalCounterValue",
                "RECORDS_IN_mapCounterValue","RECORDS_IN_reduceCounterValue","RECORDS_IN_totalCounterValue",
                "RECORDS_OUT_0_mapCounterValue","RECORDS_OUT_0_reduceCounterValue","RECORDS_OUT_0_totalCounterValue",
                "RECORDS_OUT_INTERMEDIATE_mapCounterValue","RECORDS_OUT_INTERMEDIATE_reduceCounterValue",
                "RECORDS_OUT_INTERMEDIATE_totalCounterValue","BAD_ID_mapCounterValue","BAD_ID_reduceCounterValue",
                "BAD_ID_totalCounterValue","CONNECTION_mapCounterValue","CONNECTION_reduceCounterValue",
                "CONNECTION_totalCounterValue","IO_ERROR_mapCounterValue","IO_ERROR_reduceCounterValue",
                "IO_ERROR_totalCounterValue","WRONG_LENGTH_mapCounterValue","WRONG_LENGTH_reduceCounterValue",
                "WRONG_LENGTH_totalCounterValue","WRONG_MAP_mapCounterValue","WRONG_MAP_reduceCounterValue",
                "WRONG_MAP_totalCounterValue","WRONG_REDUCE_mapCounterValue","WRONG_REDUCE_reduceCounterValue",
                "WRONG_REDUCE_totalCounterValue","BYTES_READ_mapCounterValue","BYTES_READ_reduceCounterValue",
                "BYTES_READ_totalCounterValue", "BYTES_WRITTEN_mapCounterValue","BYTES_WRITTEN_reduceCounterValue",
                "BYTES_WRITTEN_totalCounterValue","runningTime","delayTime"};
        for(String cols:taskColums){
            String sql = "alter table plain_job.task change " + cols + " " + cols + " BIGINT";
            List<Object> list = mj.output(url, sql);
            System.out.println("content " + ToJson.toJson(list));
        }
    }
    public static void main(String [] args ) {




        /*String sql = "create table WZH.virtual_db " +
                "(id int(10) auto_increment not null, " +
                "name char(10) not null UNIQUE, " +
                "PRIMARY KEY ( id ))";*/



        String url = "jdbc:mysql://192.168.10.135:3306";
        //String url = "jdbc:mysql://192.168.8.173:3306";

        //String jobid = "job_1476341534026_56541";
        //String sql = "select * from job.job where id='" + jobid +"'";
        /*String sql = "create database job;";
        List<Object> list = new MysqlJdbc().output(url, sql);
        if(!list.isEmpty()){
            System.out.println(123);
        }
        System.out.println("content " + ToJson.toJson(list));*/
        //String sql = "select * from job.job limit 5";
        //String sql = "select * from job.job where submitTime between 1479282473000 and 1479368873000";
        //String sql = "alter table job.job change diagnostics diagnostics text";
        //String sql ="show create table job.job";
        //String sql = "create database plain_job";
        //String sql = "select * from plain_job.job where submitTime betwee n 1479355194 and 1479555194 limit 5";
        //String sql = "select runningTime, runningTime from plain_job.job where id = 'job_1480409780677_3466'";
        //String sql = "select count(*) from plain_job.extracted";
        //String sql = "select * from plain_job.job order by submitTime limit 5  ";
        String sql = "select * from plain_job.job where id= 'job_1480409780677_7342'";
        //String sql = "alter table plain_job.extracted change TByteReadDev TByteReadDev DOUBLE";


        List<Object> list = new MysqlJdbc().output(url, sql);
        if(!list.isEmpty()){
            System.out.println("content is " + list);
        }
        System.out.println("content " + ToJson.toJson(list));
        //alterColumnType();

        //RestJobTables();
        //RestPlainJobTables();
        //RestPlainExtractedTables();
    }
}
