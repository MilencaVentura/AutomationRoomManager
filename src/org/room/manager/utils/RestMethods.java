package org.room.manager.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

public class RestMethods {
	private static JsonReader value = new JsonReader();
	private BufferedReader br;
	private String lineReader;
	private String output = "";
	private static String appconfigPath = "\\appconfig.json";
	public static final String URL_REST = value.readJsonFile("browser", "urlRest", appconfigPath);
	private String urlpath =  URL_REST;
	public String getOrDeleteMethods(String type, String request)throws IOException, MalformedURLException {
		try {
			URL url = new URL(urlpath + request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(type);
			conn.setRequestProperty("Accept",  "application/json");
			if (conn.getResponseCode() !=  200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+  conn.getResponseCode());
			}
			br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			while ((lineReader = br.readLine()) !=  null) {
				output = output + lineReader;
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}
}
