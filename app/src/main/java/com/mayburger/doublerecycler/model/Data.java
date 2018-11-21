package com.mayburger.doublerecycler.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<ScholarshipData> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ScholarshipData> getData() {
        return data;
    }

    public void setData(List<ScholarshipData> data) {
        this.data = data;
    }
}
