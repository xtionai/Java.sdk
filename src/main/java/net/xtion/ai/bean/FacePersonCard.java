package net.xtion.ai.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FacePersonCard {
    private String[] groupIds;        //加入到组的列表
    private String personIds;       //定的个体 ID
    private String imageUrl;        //图片的 url、image提供一个即可；如果都提供，只使用 url
    private String base64Image;     //图片内容
    private String personName;      //名字
    private String tag;         //备注信息
}
