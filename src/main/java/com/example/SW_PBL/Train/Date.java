package com.example.SW_PBL.Train;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {
    public String td;
    public Date() {
        Calendar cal = Calendar.getInstance();
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        cal.add(cal.DATE, +1);
        String date = sdf.format(cal.getTime());
        this.td = "d" + date.substring(0,4) + date.substring(5,7) + date.substring(8,10);
    }
}
