package com.example.SW_PBL.Train;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Train {

    private int train_id;
    private String dep;
    private String arr;
    private String etd;
    private String eta;
    private String price;
    private String duration;



    public Train() {
    }

    public Train(int train_id, String dep, String arr, String etd, String eta, String price, String duration) {
        this.train_id = train_id;
        this.dep = dep;
        this.arr = arr;
        this.etd = etd;
        this.eta = eta;
        this.price = price;
        this.duration = duration;
    }
}
