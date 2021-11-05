
package com.example.lvm.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class date
{

    public date()
    {
    }

    public String date()
    {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd=hh:mm:ss");
        String dateStr = simpleDateFormat.format(date);
        dateStr = dateStr.replace("-", "");
        dateStr = dateStr.replace("=", " ");
        return dateStr;
    }
}
