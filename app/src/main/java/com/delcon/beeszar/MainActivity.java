package com.delcon.beeszar;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button   checkButton;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkButton = (Button)findViewById(R.id.button);
        password = (EditText)findViewById(R.id.password1);

        checkButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
//                if (isNetworkConnected()) {
//
//                } else {
//                    checkpassoff(String.valueOf(password.getText()));
//                }
//            }
        });
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public boolean checkpassoff(String pass){
        Authenticator authenticator = new Authenticator();
        return authenticator.auth(pass) > 0;
    }

    public boolean checkpasson(String pass){
        Authenticator authenticator = new Authenticator();
        return authenticator.auth(pass) > 0;
    }
}