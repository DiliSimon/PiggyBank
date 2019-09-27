package com.example.ui_a2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SaveConfirmationActivity extends AppCompatActivity {
    private float cache_value = 0;
    private float current_balance = 0;
    private boolean ifadd = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_confirmation);

        Context context = getApplicationContext();
        SharedPreferences myPrefs =
                PreferenceManager.getDefaultSharedPreferences(context);
        current_balance = myPrefs.getFloat("balance", 0);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String A_M = intent.getStringExtra(MainActivity.ADD_OR_MINUS);

        float temp_balance;
        if(A_M.equals("add")){
            String hint = message + "$ will be deposited to your account";
            TextView t = (TextView)findViewById(R.id.hint);
            t.setText(hint);
            ifadd = true;
            temp_balance = Float.parseFloat(message) + current_balance;
        }else{
            String hint = message + "$ will be drawn from your account";
            TextView t = (TextView)findViewById(R.id.hint);
            t.setText(hint);
            ifadd = false;
            temp_balance = current_balance - Float.parseFloat(message);
        }
        TextView t = (TextView)findViewById(R.id.confirmvalue);
        t.setText(String.format("%.2f", temp_balance));
        cache_value = Float.parseFloat(message);
    }

    public void confirm(View view){
        Context context = getApplicationContext();
        SharedPreferences myPrefs =
                PreferenceManager.getDefaultSharedPreferences(context);
        float balance = myPrefs.getFloat("balance", 0);
        SharedPreferences.Editor pedit = myPrefs.edit();
        float current;
        if(ifadd){
            current = cache_value + balance;
        }else{
            current = balance - cache_value;
        }
        pedit.putFloat("balance", current);
        pedit.commit();
        finish();
    }

    public void cancel(View view){
        finish();
    }

}
