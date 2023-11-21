package com.example.stock_fifo_lifo;

import com.example.stock_fifo_lifo.entity.FlowEntity;
import com.example.stock_fifo_lifo.models.Flow;
import com.example.stock_fifo_lifo.reponseObject.OutResponse;
import jakarta.ws.rs.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Path("/out")
public class OutResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @POST
    @Consumes("application/json")
    public OutResponse out(Flow flow) throws Exception{
        //System.out.println("eto " + flow.getDate());
        Flow result = new Flow();
        boolean result_state = false;
        OutResponse outResponse = new OutResponse();
        try{
            FlowEntity flowEntity = new FlowEntity();
            String dateFrom = String.valueOf(flow.getDate());
            result_state = flowEntity.out(null, flow.getId_item(), flow.getId_store(), flow.getDate(), flow.getQuantity());
        }catch(Exception e){
            outResponse.setMessage(e.getMessage());
            outResponse.setStatus_code("500");
        }
        if(result_state){
            outResponse.setMessage("Out success");
            outResponse.setStatus_code("201");
        }
        return outResponse;
    }

    public static void main(String[] args) throws Exception {
        Flow flow = new Flow();
        flow.setId_item("IR00001");
        flow.setId_store("ST00001");
        flow.setQuantity(10);

        String date = "2021-11-08 00:00:00";
        /*LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = currentDate.format(formatter);
        System.out.println(formattedDate);*/

        /*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedData = dateFormat.parse(date);
        Timestamp result = new Timestamp(parsedData.getTime());
        System.out.println(result);*/

        /*LocalDateTime currentDate = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(currentDate);*/

        //long currentTimestampMillis = System.currentTimeMillis();

        // Créer un objet Timestamp à partir du timestamp
        //Timestamp timestamp = new Timestamp(currentTimestampMillis);

        // Afficher le timestamp
        //System.out.println("Timestamp actuel en millisecondes : " + currentTimestampMillis);
        //System.out.println("Timestamp au format Timestamp : " + timestamp);

        flow.setDate(date);
        OutResource outResource = new OutResource();
        OutResponse outResponse = outResource.out(flow);
        System.out.println(outResponse.getMessage());
    }
}