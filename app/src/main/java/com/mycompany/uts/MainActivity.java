package com.mycompany.uts;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    TextView ind1, ind2, ind3, ind4, ind5;
    static int mode,modes;

    TextView staabr, staname,staabr2, staname2;
    static int sp = 0;
    String date = "16/11/2023";
    boolean isclicked = false;
    RadioButton rb2, rb1, rb3, rb4, rb5, rb6, rb8, rb7;
    LinearLayout bat, bap, qrbooking, joutic, bat2, bap2, quickbooking, platform, bat3, bap3, bat4, bap4, seatic;
    int color = Color.parseColor("#f68849");
    long backPressedTime;
    variables var = new variables();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        staabr = findViewById(R.id.staabr);
        staname = findViewById(R.id.staname);
        staabr2 = findViewById(R.id.staabr2);
        staname2 = findViewById(R.id.staname2);

        if (mode != 0) {

                SharedPreferences sharedPreferences = getSharedPreferences("SourceStation", Context.MODE_PRIVATE);
                staname.setText(sharedPreferences.getString("sourcestationname", "Station Name"));
                staabr.setText(sharedPreferences.getString("sourcestationabr", "STN"));

            if (modes == 4) {
              sharedPreferences = getSharedPreferences("SourceStation", Context.MODE_PRIVATE);
                staname2.setText(sharedPreferences.getString("deststationname", "Station Name"));
                staabr2.setText(sharedPreferences.getString("deststationabr", "STN"));
            }

        }
//        staname.setText("Station Name");
//        staabr.setText("STN");


        ind1 = findViewById(R.id.ind1);
        ind2 = findViewById(R.id.ind2);
        ind3 = findViewById(R.id.ind3);
        ind4 = findViewById(R.id.ind4);
        ind5 = findViewById(R.id.ind5);

        bat = findViewById(R.id.bat);
        bap = findViewById(R.id.bap);

        bat3 = findViewById(R.id.bat3);
        bap3 = findViewById(R.id.bap3);

        bat4 = findViewById(R.id.bat4);
        bap4 = findViewById(R.id.bap4);

        bat2 = findViewById(R.id.bat2);
        bap2 = findViewById(R.id.bap2);


        rb2 = findViewById(R.id.rb2);
        rb1 = findViewById(R.id.rb1);

        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);

        rb5 = findViewById(R.id.rb5);
        rb6 = findViewById(R.id.rb6);

        rb7 = findViewById(R.id.rb7);
        rb8 = findViewById(R.id.rb8);

        qrbooking = findViewById(R.id.qrbooking);
        joutic = findViewById(R.id.joutic);
        quickbooking = findViewById(R.id.quickbooking);
        platform = findViewById(R.id.platform);
        seatic = findViewById(R.id.seatic);

        setheight(platform, 0);
        setheight(seatic, 0);
        setheight(qrbooking, 0);
        setheight(quickbooking, 0);
        setheight(bat, 0);
        setheight(bap, 0);

        setheight(bat3, 0);
        setheight(bap3, 0);
        setheight(bat4, 0);
        setheight(bap4, 0);
        setheight(bat2, 0);
        setheight(bap2, 0);
        if (mode == 1) {

            batv(rb1);
        }
        if(mode ==2)
        {
            bapv(rb2);
        }

    }

    public void cli1(View b) {
        if (!isclicked)
            setheight(joutic, 500);
        else
            setheight(joutic, 750);
        setheight(qrbooking, 0);
        setheight(quickbooking, 0);
        setheight(platform, 0);
        setheight(seatic, 0);

        ind1.setBackgroundColor(color);
        ind2.setBackgroundColor(Color.TRANSPARENT);
        ind3.setBackgroundColor(Color.TRANSPARENT);
        ind4.setBackgroundColor(Color.TRANSPARENT);
        ind5.setBackgroundColor(Color.TRANSPARENT);
    }

    public void cli2(View b) {
        setheight(joutic, 0);
        setheight(qrbooking, 550);
        setheight(quickbooking, 0);
        setheight(platform, 0);
        setheight(seatic, 0);
        ind2.setBackgroundColor(color);
        ind1.setBackgroundColor(Color.TRANSPARENT);
        ind3.setBackgroundColor(Color.TRANSPARENT);
        ind4.setBackgroundColor(Color.TRANSPARENT);
        ind5.setBackgroundColor(Color.TRANSPARENT);
    }
    public void getfare(View g){
        Intent i=new Intent(this, viewticket.class);
        startActivity(i);
    }

    public void cli3(View b) {
        setheight(joutic, 0);
        setheight(qrbooking, 0);
        setheight(quickbooking, 600);
        setheight(platform, 0);
        setheight(seatic, 0);
        ind3.setBackgroundColor(color);
        ind2.setBackgroundColor(Color.TRANSPARENT);
        ind1.setBackgroundColor(Color.TRANSPARENT);
        ind4.setBackgroundColor(Color.TRANSPARENT);
        ind5.setBackgroundColor(Color.TRANSPARENT);
    }

    public void cli4(View b) {
        setheight(joutic, 0);
        setheight(qrbooking, 0);
        setheight(quickbooking, 0);
        setheight(platform, 850);
        setheight(seatic, 0);
        ind4.setBackgroundColor(color);
        ind2.setBackgroundColor(Color.TRANSPARENT);
        ind3.setBackgroundColor(Color.TRANSPARENT);
        ind1.setBackgroundColor(Color.TRANSPARENT);
        ind5.setBackgroundColor(Color.TRANSPARENT);
    }

    public void cli5(View b) {
        setheight(joutic, 0);
        setheight(qrbooking, 0);
        setheight(quickbooking, 0);
        setheight(platform, 0);
        setheight(seatic, 600);
        ind5.setBackgroundColor(color);
        ind2.setBackgroundColor(Color.TRANSPARENT);
        ind3.setBackgroundColor(Color.TRANSPARENT);
        ind4.setBackgroundColor(Color.TRANSPARENT);
        ind1.setBackgroundColor(Color.TRANSPARENT);
    }

    public void show(View b) {
        Intent i = new Intent(this, viewticket.class);
        startActivity(i);
    }

    public void batv2(View b) {
        rb4.setChecked(false);
        setheight(bat2, 220);
        setheight(bap2, 0);
    }

    public void bapv2(View b) {
        rb3.setChecked(false);
        setheight(bap2, 220);
        setheight(bat2, 0);
    }

    public void batv4(View b) {
        rb8.setChecked(false);
        setheight(bat4, 100);
        setheight(bap4, 0);
    }

    public void bapv4(View b) {
        rb7.setChecked(false);
        setheight(bap4, 220);
        setheight(bat4, 0);
    }

    public void batv3(View b) {
        rb6.setChecked(false);
        setheight(bat3, 220);
        setheight(bap3, 0);
    }

    public void bapv3(View b) {
        rb5.setChecked(false);
        setheight(bap3, 220);
        setheight(bat3, 0);
    }

    public void batv(View b) {
        mode = 1;
        rb2.setChecked(false);
        rb1.setChecked(true);
        isclicked = true;
        setheight(joutic, 750);
        setheight(bat, 220);
        setheight(bap, 0);
    }

    //mera app ban gya
    public void bapv(View b) {
        mode = 2;
        rb1.setChecked(false);
        rb2.setChecked(true);
        isclicked = true;
        setheight(joutic, 750);
        setheight(bap, 220);
        setheight(bat, 0);
    }

    public void setheight(LinearLayout l, int size) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, size);
        l.setLayoutParams(layoutParams);
    }

    public void setdate(View b) {

        Intent i = new Intent(this, datepick.class);
        startActivity(i);
    }

    public void setdatetotextview(TextView textView) {
        textView.setText(date);
    }


    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finishAffinity();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();

            backPressedTime = System.currentTimeMillis();


        }
    }

    public void selsource(View b) {
        if (mode != 0) {
            modes=3;
            sp = 0;
            Intent i = new Intent(this, station.class);
            i.putExtra("sta",0);
            startActivity(i);
        } else {
            Toast.makeText(this, "Please select the mode for booking", Toast.LENGTH_SHORT).show();
        }
    }
    public void seldest(View b) {
        if (mode != 0) {
            sp = 1;
            modes=4;
            Intent i = new Intent(this, station.class);
            i.putExtra("sta",1);
            startActivity(i);
        } else {
            Toast.makeText(this, "Please select the mode for booking", Toast.LENGTH_SHORT).show();
        }
    }

}
