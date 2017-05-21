package at.crosspi.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JsonUrl {



  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

  public static void main(String[] args) throws IOException, JSONException {
    JSONObject json = readJsonFromUrl("https://crosspi.at/xpi/feed/aget.json?id=40&apikey=394c86968bb0c69ff0fe1f482de52829");
    System.out.println(json.toString());
         
       // JsonObject w = person.get("main").getAsJsonObject();
        
       System.out.println("ID: " + json.get("id").toString()); 
        System.out.println("Messumgebung: " + json.get("tag").toString());
        
        long timestamp = json.getLong("time");
        Timestamp time = new Timestamp();
        System.out.println("Datum/Uhrzeit: " + time.getTime(timestamp));   
        
        System.out.println(json.get("name").toString() +": " + json.get("value").toString());
        
}
}
