package net.xtion.ai;

import com.alibaba.fastjson.JSONObject;
import net.xtion.ai.bean.ImageDetail;
import net.xtion.ai.bean.OcrRequest;
import net.xtion.ai.common.AiManager;
import net.xtion.ai.common.Auth;
import org.apache.http.HttpException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AiJavaSdkApplication {

    public static void main(String[] args) throws IOException, HttpException {
//        getImageMergResult();
//        getBusinessSyn();
//        insertmerg();
//        mergmulti();
//        getmergmulti();
        fakePhoto();
    }
    private static void fakePhoto() {
        //图片拼接
//        //**
//        kAccessKey  fe9e0a2abdab4f259b4e5e413028caa4
//        kSecretKey 064c030330bf46cbb670ae49f13afeb5
//        kServicePath https://aiapi.xtion.net
//        kServiceTenantId 10028
        Auth auth = Auth.create("https://aiapi.xtion.net", "fe9e0a2abdab4f259b4e5e413028caa4", "064c030330bf46cbb670ae49f13afeb5");
        OcrRequest request = new OcrRequest();
        request.setUrl("https://ai-plat-test.oss-cn-shenzhen.aliyuncs.com/001/img/20190403/10026/1.jpg");
        try {
            String result = AiManager.post().fakePhoto(auth, "10028", request);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void getmergmulti(){
        long startTime = System.currentTimeMillis();
//        Auth auth = Auth.create("http://172.16.31.86:20400", "bab872638d5b423c9a87480128c337e3", "911fa17d21c24b16a494cb8644698adc");
//        https://ai-plat-test.oss-cn-shenzhen.aliyuncs.com/2eb/img/20190305/1008336/lxt3.MP4
        Auth auth = Auth.create("http://172.16.0.133", "bab872638d5b423c9a87480128c337e3", "911fa17d21c24b16a494cb8644698adc");
        String urlJson="{\n" +
                "    \"id\":1103911750824235008\n" +
                "}";
        try {
            String result = AiManager.post().getmergmultiinfo(auth, "1008336", JSONObject.parseObject(urlJson));
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public static void mergmulti(){
        long startTime = System.currentTimeMillis();
//        Auth auth = Auth.create("http://172.16.31.86:20400", "bab872638d5b423c9a87480128c337e3", "911fa17d21c24b16a494cb8644698adc");
//        https://ai-plat-test.oss-cn-shenzhen.aliyuncs.com/2eb/img/20190305/1008336/lxt3.MP4
        Auth auth = Auth.create("http://172.16.31.86:20400", "bab872638d5b423c9a87480128c337e3", "911fa17d21c24b16a494cb8644698adc");
//        Auth auth = Auth.create("https://ai.xtion.net", "a3e13e3ebc224d02911c660aa1d9f498", "caae5b4da738442db3129e48713540c9");
        String urlJson="{\n" +
                "    \"sourceUrl\":{\n" +
                "        \"videoUrl\":\"https://ai.xtion.net/img/20190306/lxt3.MP4\",\n" +
                "        \"imageUrls\":[]\n" +
                "    }\n" +
                "}";
        try {
            String result = AiManager.post().mergmulti(auth, "1008336", JSONObject.parseObject(urlJson));
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public static void getBusinessSyn() {
        long startTime = System.currentTimeMillis();
//        Auth auth = Auth.create("http://172.16.31.86:20400", "bab872638d5b423c9a87480128c337e3", "911fa17d21c24b16a494cb8644698adc");
        Auth auth = Auth.create("http://172.16.31.164:20400", "5b3cd57441ee10468d5419fd345d6547", "33afc824dd29495faa8df17edb9f0c1v");
        ImageDetail imageDetail = new ImageDetail("");
        //https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3483963350,947213035&fm=26&gp=0.jpg
        imageDetail.setImageUrl("http://42.159.86.21:9000/defaultBucket/6c92f817-f813-48da-b6c2-3a361cbaa019.jpeg");
        //imageDetail.setImageUrl("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3483963350,947213035&fm=26&gp=0.jpg");
//        imageDetail.setImageUrl("https://ai-plat-test.oss-cn-shenzhen.aliyuncs.com/84b/img/20190410/10025/84bb07b3c926403080a2247d04491b41.jpg");
//        imageDetail.setImageUrl("https://ai-plat-test.oss-cn-shenzhen.aliyuncs.com/test/3.jpg");
//        imageDetail.setImageUrl("https://ai-plat-test.oss-cn-shenzhen.aliyuncs.com/test/5.jpg");
//  String result = AiManager.post().GetTenantResource(auth, "2018112014325316");
        try {
            String result = AiManager.post().getBusinessSyn(auth, "1008336", imageDetail);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    private static void getImageMergResult() {
        //查询拼接成功图片
        Auth auth = Auth.create("http://172.16.31.86:20400", "5b3cd57441ee10468d5419fd345d6547", "33afc824dd29495faa8df17edb9f0c1v");
        Map<String, Object> idmap = new HashMap<>();
        idmap.put("megreId", 1090496411532922880L);
        String result = null;
        try {
            result = AiManager.post().getImageMergeResult(auth, "2018112014325316", idmap);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertmerge() {
        //图片拼接
        Auth auth = Auth.create("https://ai.xtion.net", "5b3cd57441ee10468d5419fd345d6547", "33afc824dd29495faa8df17edb9f0c1v");
        Map<String, Object> urlmap = new HashMap<>();
        urlmap.put("videoUrl", "https://ai-plat-test.oss-cn-shenzhen.aliyuncs.com/67f/img/20190314/1008336/67f89ecd-e663-424c-9294-475fd612c7c2.mp4");
        String stringArray[] = {"http://ai-plat.oss-cn-shenzhen.aliyuncs.com/test/d056f786-909e-42eb-a4a8-47db92a41418.jpg", "http://ai-plat.oss-cn-shenzhen.aliyuncs.com/test/15436097989150.png"};
        urlmap.put("imageUrls", stringArray);
        try {
            String result = AiManager.post().insertmerge(auth, "1008336", urlmap);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}