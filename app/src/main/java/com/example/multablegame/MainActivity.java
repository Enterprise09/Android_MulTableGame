package com.example.multablegame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ProgressBar progress;
    TextView question, input, correctAws;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, cancelBtn, enterBtn;

    private static final Random random = new Random();
    private static int num1, num2;
    private static int ctn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);

        num1 = 2 + random.nextInt(9);   // 2 - 9
        num2 = 1 + random.nextInt(9);   // 1 - 9

        progress = (ProgressBar) findViewById(R.id.progressBar);
        question = (TextView) findViewById(R.id.qustion);
        input = (TextView) findViewById(R.id.input);
        correctAws = (TextView) findViewById(R.id.correctAnswer);

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





    }

    @Override
    public void onClick(View v) {

        if (btn1.equals(v.getResources())){
            input.append("1");
        }
        else if(btn2.equals(v.getResources())){
            input.append("2");
        }
        else if(btn3.equals(v.getResources())){
            input.append("3");
        }
        else if(btn4.equals(v.getResources())){
            input.append("4");
        }
        else if(btn5.equals(v.getResources())){
            input.append("5");
        }
        else if(btn6.equals(v.getResources())){
            input.append("6");
        }
        else if(btn7.equals(v.getResources())){
            input.append("7");
        }
        else if(btn8.equals(v.getResources())){
            input.append("8");
        }
        else if(btn9.equals(v.getResources())){
            input.append("9");
        }
        else if(btn0.equals(v.getResources())){
            input.append("0");
        }
        else if(cancelBtn.equals(v.getResources())){
            input.setText("");
        }
        else if(enterBtn.equals(v.getResources())){
            int correct = num1 * num2;
            if (Integer.valueOf(input.getText().toString()) == correct){
                ctn++;
                correctAws.setText("정답 개수란 : " + ctn + "개");
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.startGame:
                Intent it = new Intent(this, GameDisplay.class);
                startActivity(it);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}