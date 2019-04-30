package net.xtion.ai.bean;

import java.util.HashMap;

/**
 * @author <a href="lizongxian@wxchina.com">ZongXian.Li </a>
 * @Description:OcrRequest
 * @Date 2019-04-20
 * @Version 1.0
 **/
public class OcrRequest {

    private String url;

    private byte[] image;

    /**
     * 图片base64字符编码
     */
    private String base64Data;

    private HashMap<String, String> options;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getBase64Data() {
        return base64Data;
    }

    public void setBase64Data(String base64Data) {
        this.base64Data = base64Data;
    }

    public HashMap<String, String> getOptions() {
        return options;
    }

    public void setOptions(HashMap<String, String> options) {
        this.options = options;
    }
}
