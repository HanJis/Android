package com.example.prac_6_7th_week_9;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CustomFragment extends Fragment {

    EditText name;
    EditText age;
    Button birthday;

    Date curDate = new Date(); // 현재
    final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy년 MM월 dd일");

    String result = dataFormat.format(curDate);

    public CustomFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_custom, container, false);

        name = view.findViewById(R.id.editTextTextPersonName);
        age = view.findViewById(R.id.editTextTextPersonName2);

        birthday = view.findViewById(R.id.button);
        birthday.setText(result);
        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        Button save = view.findViewById(R.id.button2);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr = name.getText().toString();
                String ageStr = age.getText().toString();
                String birthStr = birthday.getText().toString();

                Toast.makeText(getContext(),"이름 : "+nameStr +", 나이 : "+ageStr+", 생년월일 : "+birthStr
                        ,Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void showDateDialog(){
        Calendar calendar = Calendar.getInstance();
        try {
            curDate = dataFormat.parse(birthday.getText().toString());

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        calendar.setTime(curDate);

        int curYear = calendar.get(Calendar.YEAR);
        int curMonth = calendar.get(Calendar.MONTH);
        int curDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(getContext(),  birthDateSetListener,  curYear, curMonth, curDay);
        dialog.show();
    }

    private DatePickerDialog.OnDateSetListener birthDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            Calendar selectedCalendar = Calendar.getInstance();
            selectedCalendar.set(Calendar.YEAR, year);
            selectedCalendar.set(Calendar.MONTH, month);
            selectedCalendar.set(Calendar.DAY_OF_MONTH, day);

            Date curDate = selectedCalendar.getTime();
            setSelectedDate(curDate);
        }
    };

    private void setSelectedDate(Date curDate) {
        String selectedDateStr = dataFormat.format(curDate);
        birthday.setText(selectedDateStr);
    }
}