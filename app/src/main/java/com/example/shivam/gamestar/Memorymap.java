package com.example.shivam.gamestar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Memorymap extends AppCompatActivity {


        int avc[]={0,0,0,0,0,0,0,0};   // used for alloting values
        int av[]=new int[16];
        Random k= new Random();
        Button a[]=new Button[16];
        Button rst;
        TextView lvldisplay,hitdisplay;
        int lvlhighnum=2,lvlmult,lvl;
        int count=0;
        int movcount=0;
        int tempnum,tempnum2;
        thelistener xx=new thelistener();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_memorymap);

            lvl = getIntent().getIntExtra("lvl", 0);
            switch(lvl) {
                case 0:
                    lvlhighnum =2;
                    lvlmult = 8;
                    break;
                case 1:
                    lvlhighnum =4;
                    lvlmult = 4;
                    break;
                case 2:
                    lvlhighnum =8;
                    lvlmult = 2;
                    break;
            }
            for (int i=0;i<16;i++) {
                for (int j = 0; ; ) {
                    j = k.nextInt(lvlhighnum);
                    if (avc[j] == lvlmult) continue;
                    av[i] = j;
                    avc[j]++;
                    break;
                }
            }
            lvldisplay=findViewById(R.id.lvldisplay1);
            hitdisplay=findViewById(R.id.hitdisplay1);
            a[0]=(Button)findViewById(R.id.a0);
            a[1]=(Button)findViewById(R.id.a1);
            a[2]=(Button)findViewById(R.id.a2);
            a[3]=(Button)findViewById(R.id.a3);
            a[4]=(Button)findViewById(R.id.a4);
            a[5]=(Button)findViewById(R.id.a5);
            a[6]=(Button)findViewById(R.id.a6);
            a[7]=(Button)findViewById(R.id.a7);
            a[8]=(Button)findViewById(R.id.a8);
            a[9]=(Button)findViewById(R.id.a9);
            a[10]=(Button)findViewById(R.id.a10);
            a[11]=(Button)findViewById(R.id.a11);
            a[12]=(Button)findViewById(R.id.a12);
            a[13]=(Button)findViewById(R.id.a13);
            a[14]=(Button)findViewById(R.id.a14);
            a[15]=(Button)findViewById(R.id.a15);
            for (Button i:a) i.setOnClickListener(xx);
            rst=(Button)findViewById(R.id.rst);
            lvldisplay.setText("lvl :"+lvl);
            rst.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){


                    startActivity(new Intent(getApplicationContext(),OptionMenu.class));
                  /* ton be implemented in fruther transposing stages!
                    Button at=a[10];

                    a[10]=a[0];
                    a[0]=at;
                    if(a[0].isEnabled()&&!a[10].isEnabled()){
                        a[0].setEnabled(false);
                        a[10].setEnabled(true);
                        a[10].setBackgroundResource(R.drawable.crown2);
                        a[0].setText(":)");
                        a[10].setText("");
                        a[0].setBackgroundResource(0);;
                    }

                    if(!a[0].isEnabled()&&a[10].isEnabled()){
                        a[10].setEnabled(false);
                        a[0].setEnabled(true);
                        a[10].setBackgroundResource(R.drawable.crown2);
                        a[10].setText(":)");
                        a[0].setText("");
                        a[0].setBackgroundColor(0);

                    }

                      */
                    //    finish();
                    //    System.exit(0);
                }});

        }
         class thelistener implements View.OnClickListener{
            Button temp,temp1;
            @Override
            public void onClick(View v){
                movcount++;
                temp1=temp;
                temp = (Button)findViewById(v.getId());
                for (int i=0;i<16;i++) {
                    if(temp==a[i]) {
                        temp.setText(av[i] + "");
                        if(temp!=temp1){
                            if (movcount > 1) {
                                if (tempnum == av[i] && !(tempnum2==i)) {
                                    temp.setBackgroundResource(R.drawable.crown2);
                                    temp1.setBackgroundResource(R.drawable.crown2);
                                    temp.setText(":)");
                                    temp1.setText(":)");
                                    temp.setEnabled(false);
                                    temp1.setEnabled(false);
                                    hitdisplay.setText("hit :"+(++count));
                                    if (count == 8) {
                                        for (Button b : a) b.setVisibility(View.INVISIBLE);
                                        Intent intent = new Intent(getApplicationContext(), result.class);
                                        intent.putExtra("SCORE", movcount);
                                        intent.putExtra("label", lvl+1);
                                        startActivity(intent);
                                       // tv1.setText("you win! completed in" + movcount + "moves");
                                        //tv1.setText("you win! completed in 16 moves");
                                    }
                                } else
                                    temp1.setText("");
                            }
                            tempnum = av[i];
                            tempnum2 = i;
                        }
                    }



                }

            }
        }
    }

