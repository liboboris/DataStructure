package com.java.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: boris
 * @Date: 2020-01-09 23:18
 * @Description:
 */
public class TimeTool {
    private static final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SSS");

    public interface Task {
        void execute();
    }

    public static void check(String title, Task task) {
        if(task == null) return;
        title = title == null ? "" : "[" + title + "]";
        System.out.println(title);
        System.out.println("begin: " + fmt.format(new Date()));
        long begin = System.currentTimeMillis();
        task.execute();
        long end = System.currentTimeMillis();
        System.out.println("end: " + fmt.format(new Date()));
        double delta = ( end - begin ) / 1000.0;
        System.out.println("elapsed time: " + delta + "seconds");
        System.out.println("-------------------------------------");
    }
}
