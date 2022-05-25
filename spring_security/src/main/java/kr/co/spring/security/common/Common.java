package kr.co.spring.security.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.map.MultiValueMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Common {

	/**
	 * object 객체에 대한 null 체크
	 * @param obj
	 * @return
	 */
	public boolean isEmpty(Object obj) {
		
		if (obj == null) {return true;}
		if ((obj instanceof String) && (((String)obj).trim().length() == 0)) {return true;}
		if (obj instanceof Map) {return ((Map<?, ?>)obj).isEmpty();}
		if (obj instanceof List) {return ((List<?>)obj).isEmpty();}
		if (obj instanceof Object[]) {return (((Object[])obj).length == 0);}
		
		return false;
	}
	
	public String post(String url, String auth) throws IOException {
		
		String result = "";
        try {
 
        	URL obj = new URL(url);
 
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
 
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            
            byte[] authEncBytes = Base64.encodeBase64(auth.getBytes());
            String authStringEnc = new String(authEncBytes);
            System.out.println("authStringEnc : " + authStringEnc);
            conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
            
    		OutputStream os = conn.getOutputStream();
//    		os.write(jsonValue.getBytes("UTF-8"));
//    		os.flush();
            
            int responseCode = conn.getResponseCode();
            System.out.println("code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
 
            String inputLine;
            StringBuffer response = new StringBuffer();
 
            JSONObject items = (JSONObject) JSONValue.parse(in);
            
//        	System.out.println("requestId : " + items.get("requestId"));
//            result = items.get("requestId").toString();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
        		
	}
	
	public String put(String url, String jsonValue, String auth) throws IOException {
		
		String result = "";
        try {
 
        	URL obj = new URL(url);
        	
        	RestTemplate rest = new RestTemplate();
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
 
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            
            byte[] authEncBytes = Base64.encodeBase64(auth.getBytes());
            String authStringEnc = new String(authEncBytes);
            System.out.println("authStringEnc : " + authStringEnc);
            conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
            
    		OutputStream os = conn.getOutputStream();
    		os.write(jsonValue.getBytes("UTF-8"));
    		os.flush();
            
            int responseCode = conn.getResponseCode();
            System.out.println("code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
 
            String inputLine;
            StringBuffer response = new StringBuffer();
 
            JSONObject items = (JSONObject) JSONValue.parse(in);
            
        	System.out.println("requestId : " + items.get("requestId"));
            result = items.get("requestId").toString();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
        		
	}
	
	public List<Map<String, Object>> getResultContent(String url, String auth) throws IOException {
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		System.out.println(url);
        try {
 
        	URL obj = new URL(url);
 
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
 
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            
            byte[] authEncBytes = Base64.encodeBase64(auth.getBytes());
            String authStringEnc = new String(authEncBytes);
            System.out.println("authStringEnc : " + authStringEnc);
            conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
            
            int responseCode = conn.getResponseCode();
            System.out.println("code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            JSONObject items = (JSONObject) JSONValue.parse(in);
    		for (int i = 0; i < items.size(); i++) {
    			Map<String, Object> map = getMapFromJsonObject(items);
    			list.add((HashMap<String, Object>) map);
    		}
    		
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
	}
	
	public String getId(String url, String auth) throws IOException {
		
		String result = "";
		
        try {
 
        	url = this.parseURL(url);
        	
        	URL obj = new URL(url);
        	
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            
            byte[] authEncBytes = Base64.encodeBase64(auth.getBytes());
            String authStringEnc = new String(authEncBytes);
            System.out.println("authStringEnc : " + authStringEnc);
            conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
            
            int responseCode = conn.getResponseCode();
            System.out.println("code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
 
            String inputLine;
            StringBuffer response = new StringBuffer();
 
            JSONObject items = (JSONObject) JSONValue.parse(in);
            
        	System.out.println("Id : " + items.get("id"));
        	result = items.get("id").toString();
        	
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
 
            System.out.println("response : " + response.toString()); 
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
	}
	
	public String getResultType(String url, String auth) throws IOException {
		
		String result = "";
		
        try {
 
        	URL obj = new URL(url);
 
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
 
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            
            byte[] authEncBytes = Base64.encodeBase64(auth.getBytes());
            String authStringEnc = new String(authEncBytes);
            System.out.println("authStringEnc : " + authStringEnc);
            conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
            
            int responseCode = conn.getResponseCode();
            System.out.println("code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            JSONObject items = (JSONObject) JSONValue.parse(in);
    		
            result = items.get("result").toString();
    		System.out.println(items.get("result"));
    		
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
	}
	
	public List<Map<String, Object>> getListId(String url, String auth) throws IOException {
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
        try {
 
        	URL obj = new URL(url);
 
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
 
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            
            byte[] authEncBytes = Base64.encodeBase64(auth.getBytes());
            String authStringEnc = new String(authEncBytes);
            System.out.println("authStringEnc : " + authStringEnc);
            conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
            
            int responseCode = conn.getResponseCode();
            System.out.println("code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            JSONArray arr = (JSONArray) JSONValue.parse(in);
            System.out.println("arr : " + arr);
    		for (int i = 0; i < arr.size(); i++) {
    			Map<String, Object> map = getMapFromJsonObject((JSONObject) arr.get(i));
    			list.add((HashMap<String, Object>) map);

//    			System.out.println(list.get(i).get("id"));
//    			System.out.println(list.get(i).get("name"));
//    			
    		}
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
	}
	
	public Map<String, Object> getMapFromJsonObject(JSONObject jsonObj) {
		Map<String, Object> map = null;

		try {

			map = new ObjectMapper().readValue(jsonObj.toJSONString(), Map.class);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	}
	
	public String getParticularId(List<Map<String, Object>> param, String division){
		
		String result = "";
		
		for(int i = 0; i < param.size(); i++){
			System.out.println("name : " + param.get(i).get("name"));
			System.out.println("id : " + param.get(i).get("id"));
			result = param.get(0).get("id").toString();
		}
		
		return result;
	}
	
	public String parseURL(String url) {
		
		url = url.replaceAll(" ", "%20");
		
		return url;
	}
}
