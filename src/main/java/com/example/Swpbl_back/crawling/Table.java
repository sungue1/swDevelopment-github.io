package com.example.Swpbl_back.crawling;

public class Table {
    private String ETD;
    private String ETA;
    private String PRC;
    private String DUR;

    public String getETD() {
        return ETD;
    }
    public void setETD(String ETD) {
        this.ETD = ETD;
    }
    public String getETA() {
        return ETA;
    }
    public void setETA(String ETA) {
        this.ETA = ETA;
    }
    public String getPRC() {
        return PRC;
    }
    public void setPRC(String PRC) {
        this.PRC = PRC;
    }
    public String getDUR() {
        return DUR;
    }
    public void setDUR(String DUR) {
        this.DUR = DUR;
    }
    Table(){

    }
    Table(String ETD, String ETA, String PRC, String DUR){
        this.ETD = ETD;
        this.ETA = ETA;
        this.PRC = PRC;
        this.DUR = DUR;
    }
}
