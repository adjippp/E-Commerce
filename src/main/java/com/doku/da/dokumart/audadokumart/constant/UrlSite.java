package com.doku.da.dokumart.audadokumart.constant;

public enum UrlSite {
    BASE_URL("http://localhost/");

    private String url;

    UrlSite(String url){
        this.url = url;
    }

    public String getUrl(){
        return this.url;
    }
}
