package com.jj.restful.resource;

import com.google.gson.Gson;
import com.jj.job.optimizer.ScanData;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * Created by weizh on 2016/8/17.
 */

@Path("scanbykey")
public class scanbykey{

    @GET
    @Path("{timeRangeAndKey}")
    @Produces(MediaType.APPLICATION_JSON)
    public String GetJob(@PathParam("timeRangeAndKey") String timeRangeAndKey,
                         @Context org.glassfish.grizzly.http.server.Request request) {
        Gson gson = new Gson();
        //System.out.println(timeRangeAndKey);
        Map<String, String> infoMap = gson.fromJson(timeRangeAndKey, Map.class);


        String startTime = infoMap.get("startTimeStamp");
        String endTime = infoMap.get("endTimeStamp");
        String key = infoMap.get("orderBy");

        /*if(startTime == null || endTime == null || key == null ) {
            return "Input message unavailable!";
        }*/
        //System.out.println(timeRangeAndKey + "456");
        //System.out.println("debug info  " + startTime + " " + endTime + " " + key );
        ScanData sd = new ScanData();
        String res = sd.TimeRangeOrderByOneKey(startTime, endTime, key);
        //System.out.println(res);


        return res;


    }


}
