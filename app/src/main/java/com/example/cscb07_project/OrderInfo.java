package com.example.cscb07_project;

import java.io.Serializable;
import java.util.List;

/**
 * 加入购物车的信息(只是为了传数据加的类)
 */
public class OrderInfo implements Serializable {
    private List<CustomProductView> data;

    public List<CustomProductView> getData() {
        return data;
    }

    public void setData(List<CustomProductView> data) {
        this.data = data;
    }
}
