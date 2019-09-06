package com.example.shivam.gamestar;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class Startpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);
        Button help;
        Button start;
            start=findViewById(R.id.start);
            help=findViewById(R.id.help);


            help.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder b=new AlertDialog.Builder(Startpage.this);
                    b.setMessage("This app is developed for hackathon 2018 ITG by shivam pandey "
                    +"for improvements and suggestions mail me at sjtgshivam@gmail.com")
                            .setPositiveButton("0K", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                    AlertDialog alert=b.create();
                    alert.show();

                }
            });


            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Startpage.this,OptionMenu.class));

                }
            });


        }

        // Disable Return Button
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {

            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                switch (event.getKeyCode()) {
                    case KeyEvent.KEYCODE_BACK:
                        return true;
                }
            }

            return super.dispatchKeyEvent(event);
        }
    }

