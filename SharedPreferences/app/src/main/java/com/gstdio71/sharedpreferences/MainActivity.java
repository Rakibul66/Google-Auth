package com.gstdio71.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferenceConfig preferenceConfig;
    private EditText UserName,UserPassword;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferenceConfig=new SharedPreferenceConfig(getApplicationContext());

        UserName=findViewById(R.id.edittext1);
        UserPassword=findViewById(R.id.edittext2);
      //  button=findViewById(R.id.button1);
        if(preferenceConfig.readLoginStatus()){
            startActivity(new Intent(this,SucessActivity.class));
            finish();
        }
    }

    public void loginUser(View view) {
        String username=UserName.getText().toString();
        String userpass=UserPassword.getText().toString();
        if(username.equals(getResources().getString(R.string.user_name))&& userpass.equals(getResources().getString(R.string.user_password))){
            startActivity(new Intent(this,SucessActivity.class));
            preferenceConfig.writeLoginStatus(true);
            finish();
        }
        else {
            Toast.makeText(this,"Login Failed! Try again",Toast.LENGTH_SHORT).show();
            UserName.setText("");
            UserPassword.setText("");
        }
    }
}
