package org.geekster;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchData {
    public static void fetchingData() throws Exception{

        String urlStr ="https://api.zippopotam.us/us/33162";
        URL url = new URL(urlStr);
        HttpURLConnection urlConnection =  (HttpURLConnection) url.openConnection();
        int responseCode = urlConnection.getResponseCode();

        if(responseCode==200){
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder apiData = new StringBuilder();
            String readLine = null;

            while ((readLine = br.readLine()) !=null){
                apiData.append(readLine);
            }
            br.close();

            JSONObject jsonAPIResponse = new JSONObject(apiData.toString());

            System.out.println(jsonAPIResponse);
            System.out.println(jsonAPIResponse.get("post code"));
            System.out.println(jsonAPIResponse.get("country"));
            System.out.println(jsonAPIResponse.get("country abbreviation"));
            System.out.println(jsonAPIResponse.get("places"));
            JSONArray dataArray = jsonAPIResponse.getJSONArray("places");
            for (int i = 0; i < dataArray.length()/2; i++) {
                System.out.println(dataArray.get(i));
            }
        }
        else{
            System.out.println("Calling API is not working!!!");
        }

    }
}
