package com.delcon.beeszar;

import com.delcon.beeszar.Authenticator;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    public boolean checkpass(String pass){
        Authenticator authenticator = new Authenticator();
        return authenticator.auth(pass) > 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}