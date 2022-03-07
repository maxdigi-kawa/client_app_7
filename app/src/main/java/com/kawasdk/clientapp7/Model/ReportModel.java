package com.kawasdk.clientapp7.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReportModel {

    @SerializedName("report_url")
    @Expose
    private String reportUrl;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("errors")
    @Expose
    private List<String> errors = null;


    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

}


