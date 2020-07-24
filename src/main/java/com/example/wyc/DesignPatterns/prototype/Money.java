package com.example.wyc.DesignPatterns.prototype;

/**
 * @author wyc
 * @date 2020/6/1/16:43
 */
public class Money implements Cloneable {


    private int faceValue;

    private Area area;

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public Money(int faceValue, Area area) {
        this.faceValue = faceValue;
        this.area = area;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

/*    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }*/

    @Override
    protected Money clone() throws CloneNotSupportedException {
        return (Money) super.clone();
    }
}
