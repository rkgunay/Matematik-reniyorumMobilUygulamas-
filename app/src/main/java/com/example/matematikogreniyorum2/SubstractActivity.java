package com.example.matematikogreniyorum2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SubstractActivity extends AppCompatActivity {

    Button btnStart, btnAnswer0, btnAnswer1, btnAnswer2, btnAnswer3;
    TextView tvScore, tvQuestions, tvTimer, tvBottomMessage, tvChoice;
    ProgressBar progBar;
    GameSubstract g = new GameSubstract();

    int secondsRemaining = 30;

    CountDownTimer timer = new CountDownTimer(30000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            secondsRemaining--;
            tvTimer.setText(Integer.toString(secondsRemaining) + "sn");
            progBar.setProgress(secondsRemaining);
        }
        @Override
        public void onFinish() {

            btnAnswer0.setEnabled(false);
            btnAnswer1.setEnabled(false);
            btnAnswer2.setEnabled(false);
            btnAnswer3.setEnabled(false);
            tvBottomMessage.setText("Zamanın doldu!  " + (g.getNumberCorrect()) + "/" + (g.getTotalQuestion()-1));
            btnStart.setText("YENİDEN OYNA");

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btnStart.setVisibility(View.VISIBLE);
                }
            }, 4000);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        btnStart = findViewById(R.id.btnStart);
        btnAnswer0 = findViewById(R.id.btnAnswer0);
        btnAnswer1 = findViewById(R.id.btnAnswer1);
        btnAnswer2 = findViewById(R.id.btnAnswer2);
        btnAnswer3 = findViewById(R.id.btnAnswer3);

        tvScore = findViewById(R.id.tvScore);
        tvBottomMessage = findViewById(R.id.tvBottomMessage);
        tvQuestions = findViewById(R.id.tvQuestions);
        tvTimer = findViewById(R.id.tvTimer);

        progBar = findViewById(R.id.progBar);

        tvTimer.setText("0 sn");
        tvQuestions.setText("");
        tvBottomMessage.setText("Başla'ya Basın");
        tvScore.setText("0 puan");

        View.OnClickListener startButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button startButton = (Button) v;
                startButton.setVisibility(View.INVISIBLE);

                secondsRemaining = 30;
                g = new GameSubstract();


                nextTurn();
                timer.start();
            }
        };

        View.OnClickListener answerButtonClickListener  = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked = (Button) v;
                int answerSelected = Integer.parseInt(buttonClicked.getText().toString());
                g.checkAnswer(answerSelected);

                tvScore.setText(Integer.toString(g.getScore()) + " puan");
                nextTurn();
            }
        };

        btnStart.setOnClickListener(startButtonClickListener);

        btnAnswer0.setOnClickListener(answerButtonClickListener);
        btnAnswer1.setOnClickListener(answerButtonClickListener);
        btnAnswer2.setOnClickListener(answerButtonClickListener);
        btnAnswer3.setOnClickListener(answerButtonClickListener);

    }

    private void nextTurn() {
        //create a new question
        g.makeNewQuestion();
        int [] answer = g.getCurrentQuestion().getAnswerArray();

        btnAnswer0.setText(Integer.toString(answer[0]));
        btnAnswer1.setText(Integer.toString(answer[1]));
        btnAnswer2.setText(Integer.toString(answer[2]));
        btnAnswer3.setText(Integer.toString(answer[3]));

        btnAnswer0.setEnabled(true);
        btnAnswer1.setEnabled(true);
        btnAnswer2.setEnabled(true);
        btnAnswer3.setEnabled(true);


        tvQuestions.setText(g.getCurrentQuestion().getQuestionPhrase());

        tvBottomMessage.setText(g.getNumberCorrect() + "/" + (g.getTotalQuestion() -1) );

        //set text on answer buttons
        // enable answer buttons
        // start the timer
    }



}