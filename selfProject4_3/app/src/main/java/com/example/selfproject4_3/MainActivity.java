package com.example.selfproject4_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnRe;
    TextView textResult;
    String num1, num2;
    Double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnRe = (Button) findViewById(R.id.BtnRe);

        textResult = (TextView) findViewById(R.id.TextResult);

       btnAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               num1 = edit1.getText().toString();
               num2 = edit2.getText().toString();
               if (num1.equals("") || num2.equals("")) {
                   Toast.makeText(getApplicationContext(), "값을 입력하지 않은 부분이 있습니다.", Toast.LENGTH_SHORT).show();
               } else {
                   result = Double.parseDouble(num1) + Double.parseDouble(num2);
                   textResult.setText("계산 결과 : " + result.toString());
                   return;
               }
           }
       });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if (num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하지 않은 부분이 있습니다.", Toast.LENGTH_SHORT).show();
                } else {
                result =Double.parseDouble(num1) - Double.parseDouble(num2);
                textResult.setText("계산 결과 : "+ result.toString());
                return;
            }}
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if (num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하지 않은 부분이 있습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                    return;
                }
            }

        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if (num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하지 않은 부분이 있습니다.", Toast.LENGTH_SHORT).show();
                } else {

                    if (Float.parseFloat(num2) == 0) {
                        Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        result = Math.floor(Double.parseDouble(num1) / Double.parseDouble(num2));
                        textResult.setText("계산 결과 : "+result.toString());
                        return;
                    }
                }
            }
        });

        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if (num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하지 않은 부분이 있습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    result =Double.parseDouble(num1) % Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                    return;
                }
            }
        });
    }
}