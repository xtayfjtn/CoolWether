package com.zhangqian.coolwether.log;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/16.
 */

public class Logger {
    static final String FILENAME = "logger.txt";
    public static void loge(String msg) {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return;
        }

        String path = Environment.getExternalStorageDirectory().toString()
                + File.separator
                + "Weather_log"
                + File.separator
                + FILENAME;
        File file = new File(path);

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        PrintStream ps = null;

        try {
            ps = new PrintStream(new FileOutputStream(file, true));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date curDate = new Date(System.currentTimeMillis());
            String time = formatter.format(curDate);
            ps.println(msg + time);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            ps.close();
        }
    }
}
