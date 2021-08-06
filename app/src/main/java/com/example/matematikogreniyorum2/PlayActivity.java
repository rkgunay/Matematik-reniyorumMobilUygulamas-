package com.example.matematikogreniyorum2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {
    Button btnAdd, btnSubstract, btnDivide, btnMultiply, btnAdvance, btnHowTo;
    TextView tvHead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        btnAdd = findViewById(R.id.btnAdd);
        btnSubstract = findViewById(R.id.btnSubstract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnAdvance = findViewById(R.id.btnAdvance);
        btnHowTo = findViewById(R.id.btnHowTo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=nqwx8Hw7Hvc&list=PLgrsdYG0dL0KtggLHJ-NNKzunstT7gSdY&index=10"))  );
            }
        });
        btnSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=HC-B27erqgE&list=PLgrsdYG0dL0KtggLHJ-NNKzunstT7gSdY&index=21")));

            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=4JtP_YRfHIc&list=PLgrsdYG0dL0LiKoaJvu7oQrqL_u3ryHZt&index=7")));

            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=c2RPZ3McyYI&list=PLgrsdYG0dL0LiKoaJvu7oQrqL_u3ryHZt&index=11")));

            }
        });
        btnAdvance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=xJK6K4FU67Q")));

            }
        });
        btnHowTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayActivity.this,
                        About.class));

            }
        });

    }
}