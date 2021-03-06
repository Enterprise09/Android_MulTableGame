package com.example.multablegame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameDisplay extends AppCompatActivity implements View.OnClickListener {

    ProgressBar progress;
    TextView question, input, correctAws;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, cancelBtn, enterBtn;
    Runnable process, timer;

    private Random random = new Random();
    private int num1, num2;
    private int ctn = 0;
    public static int s = 0;

    Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s = 0;
        ctn = 0;
        progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setMax(100);
        progress.setProgress(0);
        question = (TextView) findViewById(R.id.qustion);
        randomQuestion();
        question.setText(num1 + " * " + num2);

        input = (TextView) findViewById(R.id.input);
        correctAws = (TextView) findViewById(R.id.correctAnswer);
        correctAws.setText(ctn + "");

        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn0 = (Button) findViewById(R.id.button0);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);
        enterBtn = (Button) findViewById(R.id.enterBtn);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
        enterBtn.setOnClickListener(this);

        process = new Runnable() {
            @Override
            public void run() {
                progress.incrementProgressBy(1);
                s++;
                if(s < 100){
                    handler.postDelayed(process, 600);      //600ms * 100 = 60000 >> 60Second >> 1Minute
                }
            }
        };
        handler.postDelayed(process, 600);

        timer= new Runnable() {
            @Override
            public void run() {
                Intent i = getIntent();
                i.putExtra("count", ctn);
                setResult(RESULT_OK, i);
                finish();
            }
        };
        handler.postDelayed(timer, 60000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                input.append("1");
                break;
            case R.id.button2:
                input.append("2");
                break;
            case R.id.button3:
                input.append("3");
                break;
            case R.id.button4:
                input.append("4");
                break;
            case R.id.button5:
                input.append("5");
                break;
            case R.id.button6:
                input.append("6");
                break;
            case R.id.button7:
                input.append("7");
                break;
            case R.id.button8:
                input.append("8");
                break;
            case R.id.button9:
                input.append("9");
                break;
            case R.id.button0:
                input.append("0");
                break;
            case R.id.enterBtn:
                int correct = num1 * num2;
                int ans = Integer.parseInt(input.getText().toString());
                if (ans == correct){    //is this Correct?
                    ctn++;  //Count Correct Answer
                    correctAws.setText(ctn + "");
                }
                input.setText("");
                randomQuestion();
                break;
            case R.id.cancelBtn:
                input.setText("");
                break;
        }
    }

    public int randomQuestion(){    //Create Question
        num1 = 1 + random.nextInt(9);
        num2 = 1 + random.nextInt(9);

        //Create the Question & Display
        question.setText(num1 + " * " + num2);

        return num1*num2;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ingame_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.exit:
                Intent i = getIntent();
                i.putExtra("count", ctn);
                setResult(RESULT_OK, i);
                finish();       //Return to MainActivity with Result Code "RESULT_OK"
                break;
            case R.id.restart:  //End GameDisplay Activity & Return result RESULT_CANCELED
                Intent r = new Intent(getApplicationContext(), GameDisplay.class);
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
