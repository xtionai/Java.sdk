package net.xtion.ai.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.alibaba.fastjson.JSON.toJSONString;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty;

/**
 * 封装HTTP get post请求，简化发送http请求
 *
 */
public class HttpUtil {

	private static HttpUtil instance = new HttpUtil();
	private static HttpClient client;
	private static long startTime = System.currentTimeMillis();
	public  static PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();  
	private static ConnectionKeepAliveStrategy keepAliveStrat = new DefaultConnectionKeepAliveStrategy() {  

		 @Override
	     public long getKeepAliveDuration(  
	            HttpResponse response,  
	            HttpContext context) {  
	        long keepAlive = super.getKeepAliveDuration(response, context);  
	        
	        if (keepAlive == -1) {  
	            keepAlive = 5000;  
	        }  
	        return keepAlive;  
	    }  
	  
	};
	private HttpUtil() {

		client = HttpClients
				.custom()
				.setConnectionManager(cm)
				.setKeepAliveStrategy(keepAliveStrat)
//				.setSSLHostnameVerifier((hostname, session) -> {
//					hostname = "*.xtion.net";
//					return SSLConnectionSocketFactory.getDefaultHostnameVerifier().verify(hostname, session);
//				})
				.build();
	}

    public static void IdleConnectionMonitor(){
		
		if(System.currentTimeMillis()-startTime>30000){
			 startTime = System.currentTimeMillis();
			 cm.closeExpiredConnections();  
             cm.closeIdleConnections(30, TimeUnit.SECONDS);
		}
	}
	 
	private static RequestConfig requestConfig = RequestConfig.custom()
	        .setSocketTimeout(60000)
	        .setConnectTimeout(60000)
	        .setConnectionRequestTimeout(60000)
	        .build();
	
	
	public static HttpUtil getInstance() {
		return instance;
	}

	public HttpClient getHttpClient() {
		return client;
	}

	private HttpPost httpPostMethod(String url) {
		return new HttpPost(url);
	}

    private HttpPut httpPutMethod(String url) {
        return new HttpPut(url);
    }

    private HttpDelete httpDeleteMethod(String url) {
        return new HttpDelete(url);
    }

	private  HttpRequestBase httpGetMethod(String url) {
		return new  HttpGet(url);
	}
	
	public String requestHttpGet(String url,String apiVersion,String account,String accessKey,String timestamp,
								 String signature,String signatureVersion,String signatureMethod) throws HttpException, IOException{
		
		IdleConnectionMonitor();
		HttpRequestBase method = this.httpGetMethod(url);
		method.setConfig(requestConfig);
		method.addHeader("Content-Type", "application/json;charset=UTF-8");
		method.addHeader("Api-Version",apiVersion);
		method.addHeader("Account",account);
		method.addHeader("Access-Key",accessKey);
		method.addHeader("Timestamp",timestamp);
		method.addHeader("Signature",signature);
		method.addHeader("Signature-Version",signatureVersion);
		method.addHeader("Signature-Method",signatureMethod);

		HttpResponse response = client.execute(method);
		HttpEntity entity =  response.getEntity();
		if(entity == null){
			return "";
		}
		InputStream is = null;
		String responseData = "";
		try{
		    is = entity.getContent();
		    responseData = IOUtils.toString(is, "UTF-8");
		}finally{
			if(is!=null){
			    is.close();
			}
		}
		return responseData;
	}
	
	public String requestHttpPost(String url,String apiVersion,String account,String accessKey,String timestamp,
								  String signature,String signatureVersion,String signatureMethod,Object params) throws HttpException, IOException{
		
		IdleConnectionMonitor();
		HttpPost method = this.httpPostMethod(url);
//		List<NameValuePair> valuePairs = this.convertMap2PostParams(params);
//		UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(valuePairs, Consts.UTF_8);
		StringEntity se = new StringEntity(JSON.toJSONString(params,WriteNullListAsEmpty), ContentType.APPLICATION_JSON);
		se.setContentEncoding("UTF-8");
		se.setContentType("application/json");//发送json数据需要设置contentType
		method.setEntity(se);
		method.setConfig(requestConfig);
		method.addHeader("Content-Type", "application/json;charset=UTF-8");
		method.addHeader("Api-Version",apiVersion);
		method.addHeader("Account",account);
		method.addHeader("Access-Key",accessKey);
		method.addHeader("Timestamp",timestamp);
		method.addHeader("Signature",signature);
		method.addHeader("Signature-Version",signatureVersion);
		method.addHeader("Signature-Method",signatureMethod);

		HttpResponse response = client.execute(method);
		HttpEntity entity =  response.getEntity();
		if(entity == null){
			return "";
		}
		InputStream is = null;
		String responseData = "";
		try{
		    is = entity.getContent();
		    responseData = IOUtils.toString(is, "UTF-8");
		}finally{
			if(is!=null){
			    is.close();
			}
		}
		return responseData;
		
	}

    public String requestHttpPut(String url,String apiVersion,String account,String accessKey,String timestamp,
                                  String signature,String signatureVersion,String signatureMethod,Object params) throws HttpException, IOException{

        IdleConnectionMonitor();
        HttpPut method = this.httpPutMethod(url);
//		List<NameValuePair> valuePairs = this.convertMap2PostParams(params);
//		UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(valuePairs, Consts.UTF_8);
		StringEntity se = new StringEntity(JSON.toJSONString(params,WriteNullListAsEmpty), ContentType.APPLICATION_JSON);
        se.setContentEncoding("UTF-8");
        se.setContentType("application/json");//发送json数据需要设置contentType
        method.setEntity(se);
        method.setConfig(requestConfig);
        method.addHeader("Content-Type", "application/json;charset=UTF-8");
        method.addHeader("Api-Version",apiVersion);
        method.addHeader("Account",account);
        method.addHeader("Access-Key",accessKey);
        method.addHeader("Timestamp",timestamp);
        method.addHeader("Signature",signature);
        method.addHeader("Signature-Version",signatureVersion);
        method.addHeader("Signature-Method",signatureMethod);

        HttpResponse response = client.execute(method);
        HttpEntity entity =  response.getEntity();
        if(entity == null){
            return "";
        }
        InputStream is = null;
        String responseData = "";
        try{
            is = entity.getContent();
            responseData = IOUtils.toString(is, "UTF-8");
        }finally{
            if(is!=null){
                is.close();
            }
        }
        return responseData;

    }

    public String requestHttpDelete(String url,String apiVersion,String account,String accessKey,String timestamp,
                                 String signature,String signatureVersion,String signatureMethod) throws HttpException, IOException{

        IdleConnectionMonitor();
        HttpRequestBase method = this.httpDeleteMethod(url);
        method.setConfig(requestConfig);
        method.addHeader("Content-Type", "application/json;charset=UTF-8");
        method.addHeader("Api-Version",apiVersion);
        method.addHeader("Account",account);
        method.addHeader("Access-Key",accessKey);
        method.addHeader("Timestamp",timestamp);
        method.addHeader("Signature",signature);
        method.addHeader("Signature-Version",signatureVersion);
        method.addHeader("Signature-Method",signatureMethod);

        HttpResponse response = client.execute(method);
        HttpEntity entity =  response.getEntity();
        if(entity == null){
            return "";
        }
        InputStream is = null;
        String responseData = "";
        try{
            is = entity.getContent();
            responseData = IOUtils.toString(is, "UTF-8");
        }finally{
            if(is!=null){
                is.close();
            }
        }
        return responseData;
    }
	
	private List<NameValuePair> convertMap2PostParams(Map<String,String> params){
		List<String> keys = new ArrayList<String>(params.keySet());
		if(keys.isEmpty()){
			return null;
		}
		int keySize = keys.size();
		List<NameValuePair>  data = new LinkedList<NameValuePair>() ;
		for(int i=0;i<keySize;i++){
			String key = keys.get(i);
			String value = params.get(key);
			data.add(new BasicNameValuePair(key,value));
		}
		return data;
	}

}

