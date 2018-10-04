package com.example.franc.animatedpiechart;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.callback.OnPieSelectListener;
import com.razerdp.widget.animatedpieview.data.IPieInfo;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

public class MainActivity extends AppCompatActivity {
    private AnimatedPieView animatedPieView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animatedPieView = findViewById(R.id.animatedPieView);
        AnimatedPieViewConfig config = new AnimatedPieViewConfig();

        config.addData(new SimplePieInfo(3, Color.parseColor("#27e901"),"A"));
        config.addData(new SimplePieInfo(6, Color.parseColor("#e24d33"),"B"));
        config.addData(new SimplePieInfo(9, Color.parseColor("#FF4081"),"C"));
        config.addData(new SimplePieInfo(2, Color.parseColor("#FF2081"),"D"));
        config.duration(100);
        config.drawText(true);
        config.textSize(50);
        config.strokeWidth(200);
        config.selectListener(new OnPieSelectListener<IPieInfo>() {
            @Override
            public void onSelectPie(@NonNull IPieInfo pieInfo, boolean isFloatUp) {
                Toast.makeText(MainActivity.this, pieInfo.getDesc()+" - "+pieInfo.getValue(), Toast.LENGTH_SHORT).show();
            }
        });


        animatedPieView.applyConfig(config);
        animatedPieView.start();


    }
}
