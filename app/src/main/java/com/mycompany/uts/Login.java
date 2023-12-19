package com.mycompany.uts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    public void  log(View v)
    {
        EditText text=findViewById(R.id.phone);
        SharedPreferences Preferences=getSharedPreferences("SourceStation", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=Preferences.edit();
        editor.putString("phone", text.getText().toString());
        editor.apply();
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
