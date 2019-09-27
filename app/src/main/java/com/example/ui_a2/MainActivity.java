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
            String str = String.format("%.2f", balance);
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
            String str = String.format("%.2f", balance);
            t.setText(str);
        } else{
            SharedPreferences.Editor pedit = myPrefs.edit();
            pedit.putFloat("balance", 0);
            pedit.commit();
            String str = "0";
            TextView t = (TextView)findViewById(R.id.RemainBalance);
            t.setText(str);
        }
        EditText mEdit = (EditText)findViewById(R.id.editText);
        mEdit.setText("");
    }

    public void reset(View view){
        Context context = getApplicationContext();
        SharedPreferences myPrefs =
                PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor pedit = myPrefs.edit();
        pedit.putFloat("balance", 0);
        pedit.commit();
        finish();
        startActivity(getIntent());
    }

    public void increase_amount(View view){
        Intent intent = new Intent(this, SaveConfirmationActivity.class);
        EditText mEdit = (EditText)findViewById(R.id.editText);
        String value = mEdit.getText().toString();
        if(value.isEmpty()){
            return;
        }
        intent.putExtra(EXTRA_MESSAGE, value);
        intent.putExtra(ADD_OR_MINUS, "add");
        startActivity(intent);
    }

    public void decrease_amount(View view){
        Intent intent = new Intent(this, SaveConfirmationActivity.class);
        EditText mEdit = (EditText)findViewById(R.id.editText);
        String value = mEdit.getText().toString();
        if(value.isEmpty()){
            return;
        }
        intent.putExtra(EXTRA_MESSAGE, value);
        intent.putExtra(ADD_OR_MINUS, "minus");
        startActivity(intent);
    }

    public void value_1(View view) {
        float value = 1;
        float current_display;
        EditText mEdit = (EditText)findViewById(R.id.editText);
        if(mEdit.getText().toString().isEmpty()){
            current_display = 0;
        }else{
            current_display = Float.parseFloat(mEdit.getText().toString());
        }
        float current_value =  current_display + value;
        mEdit.setText(Float.toString(current_value));
    }

    public void value_5(View view) {
        float value = 5;
        float current_display;
        EditText mEdit = (EditText)findViewById(R.id.editText);
        if(mEdit.getText().toString().isEmpty()){
            current_display = 0;
        }else{
            current_display = Float.parseFloat(mEdit.getText().toString());
        }
        float current_value =  current_display + value;
        mEdit.setText(Float.toString(current_value));
    }

    public void value_10(View view) {
        float value = 10;
        float current_display;
        EditText mEdit = (EditText)findViewById(R.id.editText);
        if(mEdit.getText().toString().isEmpty()){
            current_display = 0;
        }else{
            current_display = Float.parseFloat(mEdit.getText().toString());
        }
        float current_value =  current_display + value;
        mEdit.setText(Float.toString(current_value));
    }

    public void value_001(View view) {
        float value = (float)0.01;
        float current_display;
        EditText mEdit = (EditText)findViewById(R.id.editText);
        if(mEdit.getText().toString().isEmpty()){
            current_display = 0;
        }else{
            current_display = Float.parseFloat(mEdit.getText().toString());
        }
        float current_value =  current_display + value;
        mEdit.setText(Float.toString(current_value));
    }

    public void value_005(View view) {
        float value = (float)0.05;
        float current_display;
        EditText mEdit = (EditText)findViewById(R.id.editText);
        if(mEdit.getText().toString().isEmpty()){
            current_display = 0;
        }else{
            current_display = Float.parseFloat(mEdit.getText().toString());
        }
        float current_value =  current_display + value;
        mEdit.setText(Float.toString(current_value));
    }

    public void value_01(View view) {
        float value = (float)0.1;
        float current_display;
        EditText mEdit = (EditText)findViewById(R.id.editText);
        if(mEdit.getText().toString().isEmpty()){
            current_display = 0;
        }else{
            current_display = Float.parseFloat(mEdit.getText().toString());
        }
        float current_value =  current_display + value;
        mEdit.setText(Float.toString(current_value));
    }

    public void value_025(View view) {
        float value = (float)0.25;
        float current_display;
        EditText mEdit = (EditText)findViewById(R.id.editText);
        if(mEdit.getText().toString().isEmpty()){
            current_display = 0;
        }else{
            current_display = Float.parseFloat(mEdit.getText().toString());
        }
        float current_value =  current_display + value;
        mEdit.setText(Float.toString(current_value));
    }

}
