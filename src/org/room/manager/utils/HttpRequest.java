package org.room.manager.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class HttpRequest {
	private static void getService(String name) {

		String url = configReader.getUrl() + "/services";
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet request = new HttpGet(url);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            String json = EntityUtils.toString(result.getEntity(), "UTF-8");
            try {
                JSONParser parser = new JSONParser();
                Object resultObject = parser.parse(json);

                if (resultObject instanceof JSONArray) {
                    JSONArray array=(JSONArray)resultObject;
                    for (Object object : array) {
                        JSONObject obj =(JSONObject)object;
                        System.out.print("objeto:"+obj.get("name").toString());
                        System.out.print("el nombre es:"+name);
                        if(obj.get("name").toString().equals(name)){
                        	System.out.print("name:"+name);
                        	deleteServiceById(obj.get("_id").toString());
                        }
                    }

                }else if (resultObject instanceof JSONObject) {
                    JSONObject obj =(JSONObject)resultObject;
                    if(obj.get("name").toString().equals(name)){
                    	deleteServiceById(obj.get("_id").toString());
                    }
                }

            } catch (Exception e) {
            }

        } catch (IOException ex) {
        }
    }
	public static void deleteServiceByName(String name){
		getService(name);
	}
	
	private static void deleteServiceById(String id) {

		String url = configReader.getUrl()  + "/services/" + id;
		System.out.print("ID:"+id);
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpDelete request = new HttpDelete(url);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
        } catch (IOException ex) {
        }
    }
	public static void addEmailServerJson() throws IOException {
		addEmailServer();
	}
	//pasar como parametros y concatenar dentro del body
	private static void addEmailServer()throws IOException{
		String url = configReader.getUrl() + "/services?type=exchange";
		String body =  "{\"username\":\"Administrator\",\"password\":\"qadev02**\",\"hostname\":\"env01001.unit.com\"}";
		try(CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
			HttpPost requestPost = new HttpPost(url);
			StringEntity params = new StringEntity(body);
			requestPost.addHeader("content-type", "application/json");
			requestPost.setEntity(params);
			System.out.print(body);			
			HttpResponse result = httpClient.execute(requestPost);
			System.out.println("Response Code : " 
		                + result.getStatusLine().getStatusCode());
			BufferedReader rd = new BufferedReader(
			        new InputStreamReader(result.getEntity().getContent()));
		 
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				buffer.append(line);
			}
		}catch(IOException ex){
			
		}
	}
}
