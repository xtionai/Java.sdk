package net.xtion.ai.bean;


import java.util.List;

public class ImageDetail {

    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * 分层点
     */
    private List<LayerPoint> layerPoint;

    public ImageDetail(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ImageDetail(String imageUrl,List<LayerPoint> layerPoint) {
        this.layerPoint = layerPoint;
        this.imageUrl = imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setLayerPoint(List<LayerPoint> layerPoint) {
        this.layerPoint = layerPoint;
    }
    public List<LayerPoint> getLayerPoint() {
        return layerPoint;
    }

}
