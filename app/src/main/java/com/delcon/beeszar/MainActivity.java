package com.delcon.beeszar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button   checkButton;
    EditText password;

    public boolean checkpassoff(String pass){
        Authenticator authenticator = new Authenticator();
        return authenticator.auth(pass) > 0;
    }


    private void alert(String str){
        AlertDialog create = new AlertDialog.Builder(this).create();
        create.setTitle(str);
        create.setMessage("The app is under construction.\r\n\r\nFound us on http://hippiehacking.org");
        create.setButton(-3, "OK", new DialogInterface.OnClickListener() {
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        });
        create.setCancelable(false);
        create.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkButton = (Button)findViewById(R.id.button);
        password = (EditText)findViewById(R.id.password1);

        checkButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                if(checkpassoff(String.valueOf(password.getText()))){
                    alert("Correct Serial!");
                }
            }
        });
    }
}