package com.tietoevry.serverskeletonjava.dto;

import java.util.List;

public class WrapperList {
    private List<ResponseWrapper> list;

    public WrapperList(){

    }
    public List<ResponseWrapper> getWrapperList(){
        return list;
    }
    public void setWrapperList(List<ResponseWrapper> list){
        this.list = list;
    }
}
