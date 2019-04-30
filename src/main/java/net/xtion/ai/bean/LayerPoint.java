package net.xtion.ai.bean;

/**
 * 坐标系：向右为X，向下为Y
 */
public class LayerPoint {

    /**
     * x轴最大值
     */
    private String xmax;
    /**
     * x轴最小值
     */
    private String xmin;
    /**
     * y轴最大值
     */
    private String ymax;
    /**
     * y轴最小值
     */
    private String ymin;

    public void setXmax(String xmax) {
         this.xmax = xmax;
     }
     public String getXmax() {
         return xmax;
     }

    public void setXmin(String xmin) {
         this.xmin = xmin;
     }
     public String getXmin() {
         return xmin;
     }

    public void setYmax(String ymax) {
         this.ymax = ymax;
     }
     public String getYmax() {
         return ymax;
     }

    public void setYmin(String ymin) {
         this.ymin = ymin;
     }
     public String getYmin() {
         return ymin;
     }

}