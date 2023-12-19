package com.mycompany.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ticket extends AppCompatActivity {
    TextView date2, date3, date4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);


        TextView textView = findViewById(R.id.your_textview_id), under1 = findViewById(R.id.under1), under2 = findViewById(R.id.under2);
        underline(under1);
        underline(under2);
        if (textView != null) {
            // Load the animation from the XML resource
            TranslateAnimation animation = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, 1.5f,
                    Animation.RELATIVE_TO_SELF, -1.5f,
                    Animation.RELATIVE_TO_SELF, 0f,
                    Animation.RELATIVE_TO_SELF, 0f
            );

            // Set the animation properties
            animation.setDuration(5000); // Animation duration in milliseconds (5 seconds in this case)
            animation.setInterpolator(new LinearInterpolator()); // Use a linear interpolator for smooth animation
            animation.setRepeatCount(Animation.INFINITE);
            animation.setRepeatCount(Animation.INFINITE);
            // Check if animation is not null
            if (animation != null) {
                // Set the animation to the TextView

                textView.startAnimation(animation);
                date2 = findViewById(R.id.date2);
                date3 = findViewById(R.id.date3);
                date4 = findViewById(R.id.date4);
                SharedPreferences sharedPreferences=getSharedPreferences("Shared Preferences", Context.MODE_PRIVATE);
                date2.setText(sharedPreferences.getString("sharedate",new MainActivity().date));
                date3.setText(sharedPreferences.getString("sharedate",new MainActivity().date));
                date4.setText(sharedPreferences.getString("sharedate",new MainActivity().date));


            }
        }
    }


    public void underline(TextView textView) {


        // Create a SpannableString with the desired text
        String text = textView.getText().toString();
        SpannableString spannableString = new SpannableString(text);

        // Apply UnderlineSpan to make the text underlined
        UnderlineSpan underlineSpan = new UnderlineSpan();
        spannableString.setSpan(underlineSpan, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Optionally, you can set a different text color
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#f78848"));
        spannableString.setSpan(colorSpan, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Set the SpannableString to the TextView
        textView.setText(spannableString);
    }
}