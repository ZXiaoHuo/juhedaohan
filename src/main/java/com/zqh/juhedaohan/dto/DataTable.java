package com.zqh.juhedaohan.dto;

import java.io.Serializable;
import java.util.List;

public class DataTable<T> implements Serializable {

    public DataTable(List<T> data, int count, int code){
        this.setData(data);
        this.setCount(count);
        this.setCode(code);
    }

    public DataTable(List<T> data, int count){
        this.setData(data);
        this.setCount(count);
    }

    public DataTable(List<T> data, int count,int pageNumber,int pageSize){
        this.setData(data);
        this.setCount(count);
        this.setPageNumber(pageNumber);
        this.setPageSize(pageSize);
    }

    public DataTable(){

    }

    private Integer pageNumber;

    private Integer pageSize;

    private List<T> data;

    private int count;

    private int code = 0;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
