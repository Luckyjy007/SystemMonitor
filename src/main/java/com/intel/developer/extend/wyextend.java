package com.intel.developer.extend;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.intel.fangpei.task.handler.Extender;

public class wyextend extends Extender {
    public wyextend() {
        System.out.println("nothing to do!");
    }

    public wyextend(String s) {
        System.out.println(s);
    }

    public wyextend(String s, String s2) {
        System.out.println(s + "~" + s2);
    }

    @Override
    public void commitTask() {

        Date nowTime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String start = sdFormatter.format(nowTime);
        System.out.println("1 start at : " + start);
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("1:" + i);
                Thread.sleep(1000);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("1 end");
        FileWriter fw;
        try {
            fw = new FileWriter("D:/wyextend.txt");
            fw.write("end");
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}