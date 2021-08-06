package com.example.matematikogreniyorum2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import static android.view.View.*;

public class SplashActivity extends AppCompatActivity {
    Button btnUp;
    ImageView imgStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        btnUp = findViewById(R.id.btnUp);
        Animation btnUpAnim = AnimationUtils.loadAnimation(this, R.anim.btn_up);
        btnUp.startAnimation(btnUpAnim);

        imgStart = findViewById(R.id.imgStart);
        Animation imgDownAnim = AnimationUtils.loadAnimation(this, R.anim.img_down);
        imgStart.startAnimation(imgDownAnim);

        final Animation imgUpAnim = AnimationUtils.loadAnimation(this, R.anim.img_up);
        final Animation btnDown = AnimationUtils.loadAnimation(this, R.anim.btn_down);
        View.OnClickListener onClick  = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnUp.startAnimation(btnDown);
                imgStart.startAnimation(imgUpAnim);
                CountDownTimer timer = new CountDownTimer(1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                }
                    @Override
                    public void onFinish() {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    }
                };
                timer.start();
            }
        };

        btnUp.setOnClickListener(onClick);
    }
}