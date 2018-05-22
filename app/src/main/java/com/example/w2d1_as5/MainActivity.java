package com.example.w2d1_as5;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nameET;
    private SharedPreferences nameLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    //Set up EditText and SharedPref
    private void init(){
        nameET = findViewById(R.id.etName);

    }

    public void writeToPrefs(View view){
        nameLog = this.getPreferences(Context.MODE_PRIVATE);
        String inputName = nameET.getText().toString();
        if (inputName != null){
            SharedPreferences.Editor edit = nameLog.edit();
            edit.putString(getString(R.string.saved_name_key), inputName);
            edit.commit();
        }
    }

    public void printName(View view){
        nameLog = this.getPreferences(Context.MODE_PRIVATE);
        String defaultString = getString(R.string.name_not_found);
        String outputString = nameLog.getString(getString(R.string.saved_name_key), defaultString);

        Log.d("lastNameEntered", outputString);
    }


}
