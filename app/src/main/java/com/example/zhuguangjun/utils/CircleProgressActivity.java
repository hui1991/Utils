package com.example.zhuguangjun.utils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CircleProgressActivity extends AppCompatActivity {
    private CircleProgress progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_progress);
        progress = (CircleProgress) findViewById(R.id.progress);
        progress.setProgress(75);
        progress.startAnimator(75);
    }
}
