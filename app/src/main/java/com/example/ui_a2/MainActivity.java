package com.example.ui_a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "extra_message";
    public static final String ADD_OR_MINUS = "add_or_minus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        SharedPreferences myPrefs =
                PreferenceManager.getDefaultSharedPreferences(context);
        float balance = myPrefs.getFloat("balance", -1);
        if(balance != -1){
            TextView t = (TextView)findViewById(R.id.RemainBalance);
            String str = new Float(balance).toString();
            t.setText(str);
        } else{
            SharedPreferences.Editor pedit = myPrefs.edit();
            pedit.putFloat("balance", 0);
            pedit.commit();
            String str = "0";
            TextView t = (TextView)findViewById(R.id.RemainBalance);
            t.setText(str);
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        Context context = getApplicationContext();
        SharedPreferences myPrefs =
                PreferenceManager.getDefaultSharedPreferences(context);
        float balance = myPrefs.getFloat("balance", -1);
        if(balance != -1){
            TextView t = (TextView)findViewById(R.id.RemainBalance);
            String str = new Float(balance).toString();
            t.setText(str);
        } else{
            SharedPreferences.Editor pedit = myPrefs.edit();
            pedit.putFloat("balance", 0);
            pedit.commit();
            String str = "0";
            TextView t = (TextView)findViewById(R.id.RemainBalance);
            t.setText(str);
        }
    }

    public void increase_amount(View view){
        Intent intent = new Intent(this, SaveConfirmationActivity.class);
        EditText mEdit = (EditText)findViewById(R.id.editText);
        String value = mEdit.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, value);
        intent.putExtra(ADD_OR_MINUS, "add");
        startActivity(intent);
    }

    public void decrease_amount(View view){
        Intent intent = new Intent(this, SaveConfirmationActivity.class);
        EditText mEdit = (EditText)findViewById(R.id.editText);
        String value = mEdit.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, value);
        intent.putExtra(ADD_OR_MINUS, "minus");
        startActivity(intent);
    }

    public void value_1(View view) {
        int value = 1;
        Intent intent = new Intent(this, SaveConfirmationActivity.class);
        intent.putExtra(EXTRA_MESSAGE, value);
        startActivity(intent);
    }

    public void value_5(View view) {
        int value = 10;
        Intent intent = new Intent(this, SaveConfirmationActivity.class);
        intent.putExtra(EXTRA_MESSAGE, value);
        startActivity(intent);
    }

    public void value_10(View view) {
        int value = 10;
        Intent intent = new Intent(this, SaveConfirmationActivity.class);
        intent.putExtra(EXTRA_MESSAGE, value);
        startActivity(intent);
    }

}
