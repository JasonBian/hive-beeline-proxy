package com.jj.restful.util;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static com.jj.restful.util.ClouderaClient.QueryType.QueueMem;

/**
 * Created by weizh on 2016/11/30.
 */
public class ClouderaClient {
    public enum QueryType{
        QueueMem
    }
    public static String clouderaCli(QueryType type, String queueName, Long from, Long to){

        DateFormat df =  new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSS'z'" );
        String fromStr = df.format(from);
        String toStr = df.format(to);
        String queryStr = null;
        switch(type){
            case QueueMem:
                queryStr = "timeseries?query=" +
                "SELECT+allocated_memory_mb_cumulative+WHERE+entityName=yarn:root.hdfs+AND+category=YARN_POOL";
                break;
        }

        ClientConfig config = new ClientConfig();

        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("hadoop_ro", "hadoop_ro@JJMatch");
        config.register( feature) ;

        Client client = ClientBuilder.newClient(config);


        URI uri = null;
        try {
            //uri = new URI("http://192.168.8.20:7180/");
            uri = new URI("http://192.168.8.20:7180/api/v12/" + queryStr + "&contentType=application/json&from="
                    + fromStr +"&to=" + toStr );
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        WebTarget target = client.target(uri);
       /* String requestTxt = "timeseries?query=" +
                "SELECT allocated_memory_mb_cumulative WHERE entityName=yarn:root.hdfs" +
                " AND category=YARN_POOL&contentType=" +
                "application/json&from=2016-11-28T14:31:57.948Z&to=2016-11-29T15:01:57.948Z";*/
        //String requestTxt = "timeseries";
       /* String requestTxt = "timeseries?query=SELECT%20allocated_memory_mb_cumulative%20WHERE%20entityName%20=" +
                "%20yarn:root.hdfs%20AND%20category%20=%20YARN_POOL&contentType=application/json&from=" +
                "2016-11-28T14:31:57.948Z&to=2016-11-29T15:01:57.948Z";*/

        //String requestTxt = "hosts";
        /*try {
            requestTxt = URLEncoder.encode(requestTxt, "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        //requestTxt = requestTxt.replaceAll(" ", "+");





        System.out.println(target.path(""));
        return target.request().
                accept(MediaType.APPLICATION_JSON_TYPE).get(String.class).toString();


    }
    public static void main(String [] args ){
        String  res = clouderaCli(QueueMem, "yarn:root.hdfs", 1480494317000L, 1480577268000L);
        System.out.println(res);
    }
}
