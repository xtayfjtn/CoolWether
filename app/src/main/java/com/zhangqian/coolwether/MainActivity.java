package com.zhangqian.coolwether;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhangqian.coolwether.log.Logger;
import com.zhangqian.coolwether.util.SystemUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SystemUtil.verifyStoragePermissions(this);
    }
}
