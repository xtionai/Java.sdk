package net.xtion.ai.common;

import com.alibaba.fastjson.JSONObject;
import net.xtion.ai.bean.FacePersonCard;
import net.xtion.ai.bean.ImageDetail;
import net.xtion.ai.bean.OcrRequest;
import org.apache.http.HttpException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AiManagerPost extends AiManager {

    protected AiManagerPost() {
    }

    /**
     * 异步插入AI图片识别任务
     *
     * @param auth
     * @param requestParams
     * @return
     * @version 1.0
     */
    public String inputTask(Auth auth, String account, Object requestParams) throws IOException, HttpException {
        return common(auth, account, requestParams, INPUTTASK_URI, commonFields[2]);
    }

    /**
     * 实时处理并返回业务数据
     *
     * @param auth
     * @param requestParams
     * @return
     * @version 1.0
     */
    @Deprecated
    public String getBusinessInRealTime(Auth auth, String account, Object requestParams) throws IOException, HttpException {
        return common(auth, account, requestParams, GETBUSINESSINREALTIME_URI, commonFields[2]);
    }

    /**
     * 实时处理并返回业务数据，带自动分层
     *
     * @param auth
     * @param requestParams
     * @return
     * @version 1.0
     */
    @Deprecated
    public String getBusinessAutoLayered(Auth auth, String account, Object requestParams) throws IOException, HttpException {
        return common(auth, account, requestParams, GETBUSINESSAUTOLAYERED_URI, commonFields[2]);
    }

    /**
     * 实时处理并返回业务数据
     *
     * @param auth
     * @param requestParams
     * @return
     * @version 2.0
     */
    public String getBusinessSyn(Auth auth, String account, ImageDetail requestParams) throws IOException, HttpException {
        return common(auth, account, requestParams, BUSINESS_SYN_URI, commonFields[2]);
    }

    public String mergmulti(Auth auth, String account, JSONObject requestParams) throws IOException, HttpException {
        return common(auth, account, requestParams, IMAGE_mergmulti_URI, commonFields[2]);
    }

    public String getmergmultiinfo(Auth auth, String account, JSONObject requestParams) throws IOException, HttpException {
        return common(auth, account, requestParams, IMAGE_getmergmultiinfo_URI, commonFields[2]);
    }

    /**
     * 图片拼接
     *
     * @param auth
     * @param requestParams
     * @return
     * @version 2.0
     */
    public String insertmerge(Auth auth, String account, Map requestParams) throws IOException, HttpException {
        return common(auth, account, requestParams, BUSINESS_INSERTMERGE_URI, commonFields[2]);
    }

    public String getImageMergeResult(Auth auth, String account, Map requestParams) throws IOException, HttpException {
        return common(auth, account, requestParams, BUSINESS_MERGERESULT_URI, commonFields[2]);
    }

    /**
     * 实时处理并返回业务数据，带自动分层
     *
     * @param auth
     * @param requestParams
     * @return
     * @version 2.0
     */
    public String getBusinessSynAutoLayer(Auth auth, String account, ImageDetail requestParams) throws IOException, HttpException {
        return common(auth, account, requestParams, BUSINESS_SYN_AUTOLAYER_URI, commonFields[2]);
    }

    /**
     * 异步返回业务数据
     *
     * @param auth
     * @param requestParams
     * @return
     * @version 2.0
     */
    public String getBusinessAsyn(Auth auth, String account, ImageDetail requestParams) throws IOException, HttpException {
        return common(auth, account, requestParams, BUSINESS_ASYN_URI, commonFields[2]);
    }

    public String getTenantResource(Auth auth, String account) throws IOException, HttpException {
        return common(auth, account, new HashMap<>(), GET_TENANT_RESOURCE_URI, commonFields[2]);
    }

    public String faceIsExist(Auth auth, String account) throws IOException, HttpException {
        return common(auth, account, null, ISEXIST_PERSON_URI, commonFields[2]);
    }

    public String personAdd(Auth auth, String account, FacePersonCard requestParams) throws IOException, HttpException {
        return common(auth, account, requestParams, ADD_PERSON_URI, commonFields[2]);
    }

    public String firstFace(Auth auth, String account, FacePersonCard requestParams) throws IOException, HttpException {
        return common(auth, account, requestParams, FIRST_FACE_URI, commonFields[2]);
    }

    public String verifyFace(Auth auth, String account, FacePersonCard requestParams) throws IOException, HttpException {
        return common(auth, account, requestParams, VERIFY_FACE_URI, commonFields[2]);
    }


    public String detectPricetag(Auth auth, String account, OcrRequest request) throws IOException, HttpException {
        return common(auth, account, request, OCR_PRICETAG_URI, commonFields[2]);
    }

    public String fakePhoto(Auth auth, String account, OcrRequest request) throws IOException, HttpException {
        return common(auth, account, request, OCR_FAKEPHOTO_URI, commonFields[2]);
    }
}