package com.mycompany.uts;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class station extends AppCompatActivity {
ListView listView;
TextView st;

String staname[]={
        "JAUNPUR CITY",
        "LUCKNOW JN.",
        "JAUNPUR JN.",
        "PRAGRAJ SANGAM",
        "PRAYAGRAJ JN.",
        "KUNDA",
        "LUCKNOW CITY",
        "BHARATPUR"
};
String abr[]=
    {
           "JOP",
           "LJN",
           "JNU",
           "PYGS",
           "PRYJ",
           "KUN",
           "LC",
           "BTE"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);
        listView = (ListView) findViewById(R.id.listview);

        final ArrayList<String> arrayList = new ArrayList<>();
st=findViewById(R.id.st);
        for(int i=0;i<8;i++)
        {
            arrayList.add(staname[i]+"-"+abr[i]);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "country: " + arrayList.get(position), Toast.LENGTH_SHORT).show();










                st.setText(arrayList.get(position));


                Intent i=getIntent();
                int ver=i.getIntExtra("sta",0);
                if(ver==0) {
                    SharedPreferences sharedPreferences=getSharedPreferences("SourceStation", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("sourcestationname", staname[position]);
                    editor.putString("sourcestationabr", abr[position]);
                    editor.apply();
                    Intent iw = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(iw);
                }
                if(ver==1) {
                    SharedPreferences sharedPreferences=getSharedPreferences("SourceStation", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("deststationname", staname[position]);
                    editor.putString("deststationabr", abr[position]);
                    editor.apply();
                    Intent iw = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(iw);
                }



            }
        });
    }
}