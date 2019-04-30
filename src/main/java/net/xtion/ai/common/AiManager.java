package net.xtion.ai.common;

import com.google.common.collect.Maps;
import net.xtion.ai.util.DateUtil;
import net.xtion.ai.util.HttpUtil;
import net.xtion.ai.util.SecurityUtil;
import net.xtion.ai.util.StringUtil;
import org.apache.http.HttpException;

import java.io.IOException;
import java.util.HashMap;

public class AiManager {

    AiManager() {
    }

    public static AiManagerGet get() {
        return get;
    }

    public static AiManagerPost post() {
        return post;
    }

    public static AiManagerPut put() {
        return put;
    }

    public static AiManagerDelete delete() {
        return delete;
    }

    private static AiManagerGet get = new AiManagerGet();
    private static AiManagerPost post = new AiManagerPost();
    private static AiManagerPut put = new AiManagerPut();
    private static AiManagerDelete delete = new AiManagerDelete();
    protected static final String[] commonFields = new String[]{"1.0", "GET", "POST", "2", "HmacSHA256", "PUT", "DELETE"};

    /**
     * 通用接口，也为了紧急新接口做的准备
     *
     * @param auth
     * @param requestParams
     * @return
     * @version 2.0
     */
    public static String common(Auth auth, String account, Object requestParams, String uri, String method) throws IOException, HttpException {

        //权限数据
        String host = auth.getHost();
        String accessKey = auth.getAccessKey();
        String secretKey = auth.getSecretKey();

        //基本数据
        String apiVersion = commonFields[0];
        String timestamp = DateUtil.gmtNow();
        String signatureVersion = commonFields[3];
        String signatureMethod = commonFields[4];

        //混合数据
        String url, signature;
        HashMap<String, String> params;
        String response = null;

        //数据请求
        switch (method) {
            case "GET":
                params = (HashMap<String, String>) requestParams;
                signature = SecurityUtil.createSignature(accessKey, secretKey, method, host, uri, timestamp, signatureVersion, signatureMethod, params);
                url = StringUtil.changeGetUrlWithParam(host, uri, params);
                response = HttpUtil.getInstance().requestHttpGet(url, apiVersion, account, accessKey, timestamp, signature, signatureVersion, signatureMethod);
                break;
            case "POST":
                signature = SecurityUtil.createSignature(accessKey, secretKey, method, host, uri, timestamp, signatureVersion, signatureMethod, Maps.newHashMap());
                url = new StringBuffer(host).append(uri).toString();
                response = HttpUtil.getInstance().requestHttpPost(url, apiVersion, account, accessKey, timestamp, signature, signatureVersion, signatureMethod, requestParams);
                break;
            case "PUT":
                signature = SecurityUtil.createSignature(accessKey, secretKey, method, host, uri, timestamp, signatureVersion, signatureMethod, Maps.newHashMap());
                url = new StringBuffer(host).append(uri).toString();
                response = HttpUtil.getInstance().requestHttpPut(url, apiVersion, account, accessKey, timestamp, signature, signatureVersion, signatureMethod, requestParams);
                break;
            case "DELETE":
                params = (HashMap<String, String>) requestParams;
                signature = SecurityUtil.createSignature(accessKey, secretKey, method, host, uri, timestamp, signatureVersion, signatureMethod, params);
                url = StringUtil.changeGetUrlWithParam(host, uri, params);
                response = HttpUtil.getInstance().requestHttpDelete(url, apiVersion, account, accessKey, timestamp, signature, signatureVersion, signatureMethod);
                break;
        }

        return response;
    }

    /**
     * 1.0接口：异步，插入任务
     */
    protected static final String INPUTTASK_URI = "/api/ai/task/tasks";
    /**
     * 1.0接口：异步，查询图片基础数据
     */
    protected static final String GETBUSINESS_URI = "/api/ai/business/imageInfo/base_result";
    /**
     * 1.0接口：同步，实时提交数据返回图片基础数据
     */
    protected static final String GETBUSINESSINREALTIME_URI = "/api/ai/business/imageInfo/base_result";
    /**
     * 1.0接口：同步，实时提交数据返回图片基础数据,且自动分层
     */
    protected static final String GETBUSINESSAUTOLAYERED_URI = "/api/ai/business/imageInfo/base_result/auto_layer";

    /**
     * 3.1接口：图片拼接服务-插入待拼接图片
     */
    protected static final String BUSINESS_INSERTMERGE_URI = "/api/ai/image/mergemulti";
    /**
     * 3.1接口：图片拼接服务-获取拼接结果
     */

    /**
     * 3.1接口：图片拼接服务-获取拼接结果
     */
    protected static final String IMAGE_mergmulti_URI = "/api/ai/image/mergmulti";

    protected static final String IMAGE_getmergmultiinfo_URI = "/api/ai/image/getmergmultiinfo";

    protected static final String BUSINESS_MERGERESULT_URI = "/api/ai/image/mergemulti";
    /**
    /**
     * 2.0接口：同步，查询图片基础数据
     */
    protected static final String BUSINESS_SYN_URI = "/api/ai/business/business/syn";
    /**
     * 2.0接口：异步，实时提交数据返回图片基础数据
     */
    protected static final String BUSINESS_ASYN_URI = "/api/ai/business/business/asyn";
    /**
     * 2.0接口：同步，实时提交数据返回图片基础数据,且自动分层
     */
    protected static final String BUSINESS_SYN_AUTOLAYER_URI = "/api/ai/business/business/syn_autolayer";
    /**
     * 2.0接口：更新企业配置
     */
    protected static final String BUSINESS_CONFIG_URI = "/api/ai/business/config";
    /**
     * 3.0获取资源配置
     */
    protected static final String GET_TENANT_RESOURCE_URI = "/api/ai/tenant/resource/getTenantResource";
    /**
     * 3.0获取资源配置token
     */
    protected static final String AUTH_SERVTOKEN_URI = "/api/ai/auth/servToken";

    /**
     * 3.0人脸考勤：是否创建人脸
     */
    protected static final String ISEXIST_PERSON_URI = "/api/ai/thirdparty/face/isExist";
    /**
     * 3.0人脸考勤：添加个体
     */
    protected static final String ADD_PERSON_URI = "/api/ai/thirdparty/face/createperson";

    /**
     * 3.0人脸考勤：删除个体
     */
    protected static final String DELETE_PERSON_URI = "/api/ai/thirdparty/face/delectperson";
    /**
     * 3.0人脸考勤：人脸验证
     */
    protected static final String VERIFY_FACE_URI = "/api/ai/thirdparty/face/verify";
    /**
     * 3.0人脸考勤：人脸核身+个体创建 接口
     */
    protected static final String FIRST_FACE_URI = "/api/ai/thirdparty/face/firstface";

    /**
     * OCR价签识别服务 路径
     */
    protected static String OCR_PRICETAG_URI = "/api/ai/thirdparty/ocr/bussiness/pricetag";

    /**
     * OCR店头照识别服务 路径
     */
    protected static String OCR_STOREHEAD_URI = "/api/ai/thirdparty/ocr/bussiness/storehead";

    /**
     * OCR营业执照识别服务 路径
     */
    protected static String OCR_BUSSINESSLICENSE_URI = "/api/ai/thirdparty/ocr/bussiness/businesslicense";

    /**
     * OCR假照识别服务 路径
     */
    protected static String OCR_FAKEPHOTO_URI = "/api/ai/thirdparty/ocr/bussiness/fakephoto";

}

