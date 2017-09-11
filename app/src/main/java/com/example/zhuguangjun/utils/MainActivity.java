package com.example.zhuguangjun.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button circleProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        long maxMemory = Runtime.getRuntime().maxMemory();
//        long totalMemory = Runtime.getRuntime().totalMemory();
//        long freeMemory = Runtime.getRuntime().freeMemory();
//        Log.i("zhu","maxMemory== "+maxMemory/1024/1024+"MB");
//        Log.i("zhu","totalMemory== "+totalMemory/1024/1024+"MB");
//        Log.i("zhu","freeMemory== "+freeMemory/1024/1024+"MB");
//        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//        int memory = manager.getMemoryClass();
//        Log.i("zhi","memory== "+memory+"MB");
        circleProgress = (Button) findViewById(R.id.circle_progress);
        circleProgress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id==R.id.circle_progress){
            Intent intent=new Intent(this,CircleProgressActivity.class);
            startActivity(intent);
        }
    }
}
