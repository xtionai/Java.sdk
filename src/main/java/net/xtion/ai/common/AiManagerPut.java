package net.xtion.ai.common;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import net.xtion.ai.bean.BusinessConfig;
import org.apache.http.HttpException;

import java.io.IOException;
import java.util.Map;

public class AiManagerPut extends AiManager{

    protected AiManagerPut(){}

    /**
     * 业务配置更新
     * @param auth
     * @param requestParams
     * @version 2.0
     * @return
     */
    public String updateBusinessConfig(Auth auth,String account, BusinessConfig requestParams) throws IOException, HttpException {
        String configJsonString = JSON.toJSONString(requestParams);
        Map<String,String> params = Maps.newHashMap();
        params.put("configJsonString",configJsonString);
        return common(auth,account,params,BUSINESS_CONFIG_URI,commonFields[5]);
    }

}
