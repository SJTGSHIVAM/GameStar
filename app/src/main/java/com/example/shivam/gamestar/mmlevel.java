package com.example.shivam.gamestar;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mmlevel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmlevel);
        llistener xx=new llistener();
        Button l[]=new Button[8];
        l[0]=findViewById(R.id.mml0);
        l[1]=findViewById(R.id.mml1);
        l[2]=findViewById(R.id.mml2);
        l[3]=findViewById(R.id.mml3);
        l[4]=findViewById(R.id.mml4);
        l[5]=findViewById(R.id.mml5);
        l[6]=findViewById(R.id.mml6);
        l[7]=findViewById(R.id.mml7);
        for (Button i:l) i.setOnClickListener(xx);
    }
    Intent intent;
    public class llistener implements View.OnClickListener{
        @Override
        public void onClick(View v){
           switch (v.getId()){
               case R.id.mml0 :
                   intent =new Intent(getApplicationContext(),Memorymap.class);
                   intent.putExtra("lvl", 0);
                   startActivity(intent);
                   break;
               case R.id.mml1 :
                   intent =new Intent(getApplicationContext(),Memorymap.class);
                   intent.putExtra("lvl", 1);
                   startActivity(intent);
                   break;
               case R.id.mml2 :
                   intent =new Intent(getApplicationContext(),Memorymap.class);
                   intent.putExtra("lvl", 2);
                   startActivity(intent);
                   break;
               case R.id.mml3 :
                   intent =new Intent(getApplicationContext(),mmap2.class);
                   intent.putExtra("lvl", 3);
                   startActivity(intent);
                   break;
               case R.id.mml4 :
                   intent =new Intent(getApplicationContext(),mmap2.class);
                   intent.putExtra("lvl", 4);
                   startActivity(intent);
                   break;
               case R.id.mml5 :
                   intent =new Intent(getApplicationContext(),mmap2.class);
                   intent.putExtra("lvl", 5);
                   startActivity(intent);
                   break;
               case R.id.mml6 :
                   intent =new Intent(getApplicationContext(),mmap2.class);
                   intent.putExtra("lvl", 6);
                   startActivity(intent);
                   break;
               case R.id.mml7 :
                   AlertDialog.Builder b=new AlertDialog.Builder(mmlevel.this);
                   b.setMessage("Tap on two button with similar value and win,in earlier stages if you "
                   +"click on 3 buttons with same walue then that will help you decrease your over all moves" +
                           "and then you won't have to open all the button!" +
                           "break the minimum moves!")
                           .setPositiveButton("0K", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog, int which) {

                               }
                           });
                   AlertDialog alert=b.create();
                   alert.show();
                   break;
           }
        }
    }
}
