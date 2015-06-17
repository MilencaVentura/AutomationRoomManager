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
import org.room.manager.utils.configReader;

public class HttpReader {
	private static void getResourceByName(String name) {

		String url = configReader.getUrl() + "/resources";
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
                        if(obj.get("name").toString().equals(name)){
                        	deleteResourceById(obj.get("_id").toString());
                        }
                    }

                }else if (resultObject instanceof JSONObject) {
                    JSONObject obj =(JSONObject)resultObject;
                    if(obj.get("name").toString().equals(name)){
                    	deleteResourceById(obj.get("_id").toString());
                    }
                }

            } catch (Exception e) {
            }

        } catch (IOException ex) {
        }
    }
	
	
	
	
	public static void deleteResourceByName(String name){
		getResourceByName(name);
	}
	
	private static void deleteResourceById(String id) {

		String url = configReader.getUrl()  + "/resources/" + id;
		
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpDelete request = new HttpDelete(url);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
        } catch (IOException ex) {
        }
    }

	public static void createResourceJson(String name, String displayName, String icon, String description) throws IOException {
		createResource(name, displayName, icon, description);
	}
	private static void createResource(String name, String displayName, String icon, String description)throws IOException{
		String url = configReader.getUrl() + "/resources";
		String body =  "{\"name\":\""+name+"\",\"customName\":\""+displayName+"\",\"fontIcon\":\""+icon+"\",\"from\":\"\",\"description\":\""+description+"\"}";
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