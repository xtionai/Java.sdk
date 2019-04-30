package net.xtion.ai.bean;

import java.util.List;

/**
 * 业务配置
 */
public class BusinessConfig {

    private List<SkuProducts> skuProducts;
    private PositionConf positionConf;
    private String backgroundConf;
    private PlumpnessConf plumpnessConf;
    public void setSkuProducts(List<SkuProducts> skuProducts) {
        this.skuProducts = skuProducts;
    }
    public List<SkuProducts> getSkuProducts() {
        return skuProducts;
    }

    public void setPositionConf(PositionConf positionConf) {
        this.positionConf = positionConf;
    }
    public PositionConf getPositionConf() {
        return positionConf;
    }

    public void setBackgroundConf(String backgroundConf) {
        this.backgroundConf = backgroundConf;
    }
    public String getBackgroundConf() {
        return backgroundConf;
    }

    public void setPlumpnessConf(PlumpnessConf plumpnessConf) {
        this.plumpnessConf = plumpnessConf;
    }
    public PlumpnessConf getPlumpnessConf() {
        return plumpnessConf;
    }

}
