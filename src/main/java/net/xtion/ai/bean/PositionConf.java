/**
  * Copyright 2018 bejson.com 
  */
package net.xtion.ai.bean;

public class PositionConf {

    private FirstFlag firstFlag;
    private SecondFlag secondFlag;
    private ThirdFlag thirdFlag;
    public void setFirstFlag(FirstFlag firstFlag) {
         this.firstFlag = firstFlag;
     }
     public FirstFlag getFirstFlag() {
         return firstFlag;
     }

    public void setSecondFlag(SecondFlag secondFlag) {
         this.secondFlag = secondFlag;
     }
     public SecondFlag getSecondFlag() {
         return secondFlag;
     }

    public void setThirdFlag(ThirdFlag thirdFlag) {
         this.thirdFlag = thirdFlag;
     }
     public ThirdFlag getThirdFlag() {
         return thirdFlag;
     }

}