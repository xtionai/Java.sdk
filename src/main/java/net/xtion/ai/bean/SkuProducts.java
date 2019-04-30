/**
  * Copyright 2018 bejson.com 
  */
package net.xtion.ai.bean;
import java.util.List;

public class SkuProducts {

    private List<CompetitorProducts> competitorProducts;
    private String originName;
    private String proUnit;
    private int productId;
    private String productName;
    public void setCompetitorProducts(List<CompetitorProducts> competitorProducts) {
         this.competitorProducts = competitorProducts;
     }
     public List<CompetitorProducts> getCompetitorProducts() {
         return competitorProducts;
     }

    public void setOriginName(String originName) {
         this.originName = originName;
     }
     public String getOriginName() {
         return originName;
     }

    public void setProUnit(String proUnit) {
         this.proUnit = proUnit;
     }
     public String getProUnit() {
         return proUnit;
     }

    public void setProductId(int productId) {
         this.productId = productId;
     }
     public int getProductId() {
         return productId;
     }

    public void setProductName(String productName) {
         this.productName = productName;
     }
     public String getProductName() {
         return productName;
     }

}