package org.geekster;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchData {
    public static void fetchingData() throws Exception{

        String urlStr ="https://api.nationalize.io/?name=nathaniel";
        URL url = new URL(urlStr);
        HttpURLConnection urlConnection =  (HttpURLConnection) url.openConnection();
        int responseCode = urlConnection.getResponseCode();

        if(responseCode==200){
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder apiData = new StringBuilder();
            String readLine =null;

            while ((readLine = br.readLine()) !=null){
                apiData.append(readLine);
            }
            try {
                br.close();
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }


            JSONObject jsonAPIResponse = new JSONObject(apiData.toString());

            System.out.println(jsonAPIResponse);
            System.out.println("count : "+jsonAPIResponse.get("count"));
            System.out.println("name : "+jsonAPIResponse.get("name"));
            System.out.println("country : "+jsonAPIResponse.get("country"));
        }
        else{
            System.out.println("Calling API is not working!!!");
        }

    }
}
