package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton one;
    private ImageButton two;
    private ImageButton three;
    private ImageButton four;
    private ImageButton five;
    private ImageButton six;
    private ImageButton seven;
    private ImageButton eight;
    private ImageButton nine;
    private ImageButton zero;
    private ImageButton plus;
    private ImageButton minus;
    private ImageButton divide;
    private ImageButton percent;
    private ImageButton equals;
    private ImageButton changesign;
    private ImageButton reset;
    private ImageButton times;
    private ImageButton point;
    private TextView info;
    private TextView result;
    private  final char ADDITION = '+';
    private  final char SUBTRACTION = '-';
    private  final char MULTIPLICATION = '*';
    private  final char DIVESION = '/';
    private  final char EQU = 0;
    private double val1 = Double.NaN;
    private  double val2;
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpButtons();

        zero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"1");
            }
        });
       two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+"9");
            }
        });
        plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               compute();
               ACTION = ADDITION;
               info.setText(String.valueOf(val1)+"+");
               result.setText(null);
            }
        });
        minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                compute();
                ACTION = SUBTRACTION;
                info.setText(String.valueOf(val1)+"-");
                result.setText(null);
            }
        });
        times.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                compute();
                ACTION = MULTIPLICATION;
                info.setText(String.valueOf(val1)+"*");
                result.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                compute();
                ACTION = DIVESION;
                info.setText(String.valueOf(val1)+"/");
                result.setText(null);
            }
        });

        point.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                info.setText(String.valueOf(val1)+".");
            }
        });

        equals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                compute();
                ACTION = EQU;
                result.setText(result.getText().toString() +  String.valueOf(val1));
                //5+4=9;
                info.setText(result.getText().toString() + String.valueOf(val2));
            }
        });

        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (info.getText().length() > 0){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });

    }

    private void setUpButtons() {
        one = (ImageButton) findViewById(R.id.imageButton1);
        two = (ImageButton) findViewById(R.id.imageButton2);
        three = (ImageButton) findViewById(R.id.imageButton3);
        four = (ImageButton) findViewById(R.id.imageButton4);
        five = (ImageButton) findViewById(R.id.imageButton5);
        six = (ImageButton) findViewById(R.id.imageButton6);
        seven = (ImageButton) findViewById(R.id.imageButton7);
        eight = (ImageButton) findViewById(R.id.imageButton8);
        nine = (ImageButton) findViewById(R.id.imageButton9);
        zero = (ImageButton) findViewById(R.id.imageButton0);
        point = (ImageButton) findViewById(R.id.point);
        plus = (ImageButton) findViewById(R.id.plus);
        minus = (ImageButton) findViewById(R.id.minus);
        divide = (ImageButton) findViewById(R.id.divide);
        changesign = (ImageButton) findViewById(R.id.changesign);
        reset = (ImageButton) findViewById(R.id.reset);
        times = (ImageButton) findViewById(R.id.times);
        percent = (ImageButton) findViewById(R.id.percent);
        equals = (ImageButton) findViewById(R.id.equals);
        info = (TextView) findViewById(R.id.tvControl);
        result = (TextView) findViewById(R.id.tvResult);
    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(info.getText().toString());

            switch(ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVESION:
                    val1 = val1 / val2;
                    break;
                case EQU:

                    break;
            }
        }
        else{
            val1 = Double.parseDouble(info.getText().toString());
        }
    }
}
