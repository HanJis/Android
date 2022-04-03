package com.example.selfproject4_4;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch swtAgree;
    RadioGroup rGroup1;
    RadioButton rdoQ, rdoR, rdoS;
    Button btnTer, btnFirst;
    ImageView imgAndroid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        text1 =(TextView) findViewById(R.id.Text1);
        swtAgree =(Switch) findViewById(R.id.SwtAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 =(RadioGroup) findViewById(R.id.Rgroup1);
        rdoQ = (RadioButton) findViewById(R.id.RdoQ);
        rdoR = (RadioButton) findViewById(R.id.RdoR);
        rdoS = (RadioButton) findViewById(R.id.RdoS);

        btnTer = (Button) findViewById(R.id.BtnTerminate);
        btnFirst = (Button) findViewById(R.id.BtnForFirst);
        imgAndroid = (ImageView) findViewById(R.id.ImgPet);

        swtAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(swtAgree.isChecked()==true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnTer.setVisibility(View.VISIBLE);
                    btnFirst.setVisibility(View.VISIBLE);
                    imgAndroid.setVisibility(View.VISIBLE);
                } else
                {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnTer.setVisibility(View.INVISIBLE);
                    btnFirst.setVisibility(View.INVISIBLE);
                    imgAndroid.setVisibility(View.INVISIBLE);
                }
            }
        });
        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (rGroup1.getCheckedRadioButtonId()){
                    case R.id.RdoQ:
                        imgAndroid.setImageResource(R.drawable.q);
                        break;
                    case R.id.RdoR:
                        imgAndroid.setImageResource(R.drawable.r);
                        break;
                    case R.id.RdoS:
                        imgAndroid.setImageResource(R.drawable.s);
                }
            }
        });
        btnTer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdoQ.setChecked(false);
                rdoR.setChecked(false);
                rdoS.setChecked(false);
                imgAndroid.setImageResource(0);
                swtAgree.setChecked(false);
            }
        });
    }
}