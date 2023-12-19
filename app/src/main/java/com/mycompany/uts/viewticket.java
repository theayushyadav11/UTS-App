package com.mycompany.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.*;
import android.widget.TextView;

public class viewticket extends AppCompatActivity {
TextView date1;
MainActivity mainActivity=new MainActivity();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewticket);
        date1=findViewById(R.id.date1);
        SharedPreferences sharedPreferences=getSharedPreferences("Shared Preferences",Context.MODE_PRIVATE);
        date1.setText(sharedPreferences.getString("sharedate",new MainActivity().date));
        TextView source=findViewById(R.id.source),dest=findViewById(R.id.dest);



        SharedPreferences sharedPreference = getSharedPreferences("SourceStation", Context.MODE_PRIVATE);
        source.setText(sharedPreference.getString("sourcestationname", "Station Name"));



            sharedPreference = getSharedPreferences("SourceStation", Context.MODE_PRIVATE);
            dest.setText(sharedPreference.getString("deststationname", "Station Name"));



    }
    public void back(View v)
    {
//        Intent i=new Intent(this, MainActivity.class);
//        startActivity(i);
        super.onBackPressed();
    }
    public void vt(View v)
    {
       Intent i=new Intent(this, ticket.class);
        startActivity(i);

    }
}