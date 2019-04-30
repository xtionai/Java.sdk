package net.xtion.ai.common;

import org.apache.http.HttpException;

import java.io.IOException;

public class AiManagerGet extends AiManager{

    protected AiManagerGet(){}

    /**
     * 异步获取AI识别数据
     * @param auth
     * @param requestParams
     * @version 1.0
     * @return
     */
    public String getBusiness(Auth auth,String account,Object requestParams) throws IOException, HttpException {
        return common(auth,account,requestParams,GETBUSINESS_URI,commonFields[1]);
    }


    public String getServToken(Auth auth,String account,Object requestParams) throws IOException, HttpException {
        return common(auth,account,requestParams,AUTH_SERVTOKEN_URI,commonFields[1]);
    }


}
