package com.nominatim.rest;
import com.nominatim.model.*;
import com.nominatim.JDBC.Jdbc;
import com.nominatim.JDBC.Jdbc.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

@Path("https://nominatim.md7.info/")
public class restApi {

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public Response search(@QueryParam("q") String search){
        
        
        String url = "https://nominatim.md7.info/search?q=" + search;
        
        JSONArray result = new JSONArray();
        try{
            URL urlApi  = new URL(url);
            HttpURLConnection connect = (HttpURLConnection)urlApi.openConnection();
            connect.setRequestMethod("GET");
            connect.setRequestProperty("Accept", "application_json");

            if(connect.getResponseCode() != 200){
                return Response.status(Response.Status.BAD_REQUEST).build();
            }

            BufferedReader read = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            StringBuilder str = new StringBuilder();
            String out;
            while((out = read.readLine()) !=  null){
                str.append(out);
            }

            connect.disconnect();

            JSONParser parse = new JSONParser();
            JSONArray jArray = (JSONArray)parse.parse(str.toString());
            
            for(Object o: jArray){
                JSONObject obj = (JSONObject)o;
                Integer id = (Integer)obj.get("place_id");
                Integer lat = (Integer)obj.get("lat");
                Integer lon = (Integer)obj.get("lon");
                String category = (String)obj.get("category");

                JSONObject loc = new JSONObject();
                loc.put("id", id);
                loc.put("lat", lat);
                loc.put("lon", lon);
                loc.put("category", category);

                result.add(loc);

                Jdbc.addToTable(id, "search", lat, lon, category);
            }


        }catch(Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok(result, MediaType.APPLICATION_JSON).build();

    }
@GET
@Path("/reverse")
@Produces(MediaType.APPLICATION_JSON)
@Operation(summary = "Reverse geocode location", description = "Get location details by latitude and longitude")
@ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successful operation"),
    @ApiResponse(responseCode = "400", description = "Invalid input"),
    @ApiResponse(responseCode = "500", description = "Internal server error")
})
public Response reverse(@QueryParam("lat") String lat, @QueryParam("lon") String lon) {
    String url = "https://nominatim.md7.info/reverse?lat=" + lat + "&lon=" + lon + "&format=json";
    JSONObject resultObject = new JSONObject();

    try {
        URL urlApi = new URL(url);
        HttpURLConnection connect = (HttpURLConnection) urlApi.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("Accept", "application/json");

        if (connect.getResponseCode() != 200) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("{\"message\":\"Failed to fetch data from the external API\"}")
                .build();
        }

        BufferedReader read = new BufferedReader(new InputStreamReader((connect.getInputStream())));
        StringBuilder str = new StringBuilder();
        String out;
        while ((out = read.readLine()) != null) {
            str.append(out);
        }

        connect.disconnect();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(str.toString());

        String name = (String) jsonObject.get("display_name");
        String address = jsonObject.get("address").toString();

        resultObject.put("name", name);
        resultObject.put("address", address);

    } catch (Exception e) {
        e.printStackTrace();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity("{\"message\":\"An error occurred while processing the request\"}")
            .build();
    }

    return Response.ok(resultObject.toJSONString(), MediaType.APPLICATION_JSON).build();
}
}
