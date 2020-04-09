package com.rohitpathak.bmicalculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText weight;
    EditText in;
    EditText fe;
    Button button;
    TextView ans;
    TextView com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight = (EditText) findViewById(R.id.wt);
        in = (EditText) findViewById(R.id.inch);
        fe = (EditText) findViewById(R.id.feet);
        button = (Button) findViewById(R.id.btn);
        ans = (TextView) findViewById(R.id.res);
        com=(TextView) findViewById(R.id.r0);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float w=Float.parseFloat(weight.getText().toString());
                float f=Float.parseFloat(fe.getText().toString());
                float i=Float.parseFloat((in.getText().toString()));

                float d= (float) (30.48*(f+(i*0.083)));
                float calc= (w/(d*d))*10000;
                if(weight.getText().toString()==null || fe.getText().toString()==null || in.getText().toString()==null)
                {
                    ans.setText("Please enter the values");
                    com.setText("");
                }
                else if(calc<18.5) {
                    ans.setText("Result:" + String.valueOf(calc));
                    com.setText("Do you even eat");
                }
                else if(calc>=18.5 && calc<=24.9) {
                    ans.setText("Result:" + String.valueOf(calc));
                    com.setText("You are Healthy :)");
                }
                else if(calc>=25.0 && calc<=29.9) {
                    ans.setText("Result:" + String.valueOf(calc) );
                    com.setText("Little bit of workout");
                }
                else if(calc>=30.0 && calc<=34.9) {
                    ans.setText("Result:" + String.valueOf(calc) );
                    com.setText("Regular workout");
                }
                else if(calc>=35.0 && calc<=39.9) {
                    ans.setText("Result:" + String.valueOf(calc));
                    com.setText("Heavy workout fatty");
                }
                else if(calc>=40) {
                    ans.setText("Result:" + String.valueOf(calc));
                    com.setText("Okay next time you will eat in heaven");
                }
            }
        });

    }
}
