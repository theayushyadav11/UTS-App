package com.mycompany.uts;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

public class datepick extends AppCompatActivity {
DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepick);
        datePicker=findViewById(R.id.datepicker);
        Calendar calendar=Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear=monthOfYear+1;
                String month="",day="";
                if(monthOfYear<10)
                    month="0"+monthOfYear;
                else
                    month=""+monthOfYear;
                if(dayOfMonth<10)
                    day="0"+dayOfMonth;
                else
                    day=""+dayOfMonth;

                Toast.makeText(getApplicationContext(),"Date selected: "+day+"/"+month+"/"+year,Toast.LENGTH_SHORT).show();

                MainActivity ma=new MainActivity();
                ma.date=day+"/"+month+"/"+year;

             SharedPreferences sharedPreferences=getSharedPreferences("Shared Preferences",Context.MODE_PRIVATE);
             SharedPreferences.Editor editor=sharedPreferences.edit();
             editor.putString("sharedate",day+"/"+month+"/"+year);
             editor.apply();




            }
        });




    }
    public void mainback(View b)
    {
        super.onBackPressed();
    }
}