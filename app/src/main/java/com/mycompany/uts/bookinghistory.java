
package com.mycompany.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.*;
import android.widget.TextView;

public class bookinghistory  extends AppCompatActivity {
    TextView date1;
    MainActivity mainActivity = new MainActivity();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookinghistory);
        date1 = findViewById(R.id.date1);
        SharedPreferences sharedPreferences = getSharedPreferences("Shared Preferences", Context.MODE_PRIVATE);
        date1.setText(giveDate(sharedPreferences.getString("sharedate", new MainActivity().date).toString()));
        TextView source = findViewById(R.id.source), dest = findViewById(R.id.dest), via = findViewById(R.id.via);


        SharedPreferences sharedPreference = getSharedPreferences("SourceStation", Context.MODE_PRIVATE);
        source.setText(sharedPreference.getString("sourcestationname", "Station Name"));
        dest.setText(sharedPreference.getString("deststationname", "Station Name"));
        if (dest.getText().toString().equals("LUCKNOW JN."))
            via.setText("LKO");
        else
            via.setText("-");


    }

    public void back(View v) {
//        Intent i=new Intent(this, MainActivity.class);
//        startActivity(i);
        super.onBackPressed();
    }
    String giveDate(String n)
    {
        String s="",d="",m="",y="";n+="/";
        int a=0,b=0;
        for(int i=0;i<n.length();i++)
        {
            if(n.charAt(i)=='/')
            {
                if(a==0)
                {
                    d=n.substring(b,i).trim();
                    b=i+1;
                    a++;
                }
                else if(a==1)
                {
                    m=n.substring(b,i).trim();
                    b=i+1;
                    a++;
                }
                else if(a==2)
                {
                    y=n.substring(b,i).trim();
                    b=i+1;
                    a++;
                }





            }
        }

        int day=Integer.parseInt(d),month=Integer.parseInt(m);
        String mname[]={"","JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC",""};
        s=mname[month]+ " "+day+ ", "+y;


       return s;
    }
}