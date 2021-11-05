
package com.example.lvm.Controller;

import java.util.Random;

public class rewriteState
{

    public rewriteState()
    {
    }

    public String rewriteState()
    {
        return getRandomString(6);
    }

    public static String getRandomString(int length)
    {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sB = new StringBuffer();
        for(int i = 0; i < length; i++)
        {
            int number = random.nextInt(62);
            sB.append(str.charAt(number));
        }

        return sB.toString();
    }
}
