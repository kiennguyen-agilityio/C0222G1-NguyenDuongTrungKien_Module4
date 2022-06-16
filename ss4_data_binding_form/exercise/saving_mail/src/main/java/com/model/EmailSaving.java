package com.model;

public class EmailSaving {
    private String language;
    private int pageSize;
    private Boolean spamFilters;
    private String signature;

    public EmailSaving() {
    }

    public EmailSaving(String language, int pageSize, Boolean spamFilters, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamFilters = spamFilters;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getSpamFilters() {
        return spamFilters;
    }

    public void setSpamFilters(Boolean spamFilters) {
        this.spamFilters = spamFilters;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

}
