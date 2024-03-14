package edu.eci.awsprimerlogservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class RemoteLogServiceInvoker {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static String[] get_URL = null;
    private static int instancia = 0;

    public RemoteLogServiceInvoker(String[] invokerUrls) {
        get_URL = invokerUrls;
    }

    
    public static String invoke(String msg) throws IOException {
        URL obj = new URL(get_URL[instancia] + msg);
        if (instancia == get_URL.length - 1) instancia = 0;
        else instancia++;
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        StringBuffer response = new StringBuffer();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) response.append(inputLine);
            in.close();
        } else System.out.println("GET request not worked");
        System.out.println(response);
        System.out.println("GET DONE");
        return response.toString();
    }
}
