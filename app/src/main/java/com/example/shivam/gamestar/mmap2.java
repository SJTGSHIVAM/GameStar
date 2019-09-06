package com.example.shivam.gamestar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class mmap2 extends AppCompatActivity {


    int avc[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};   // used for alloting values
    int av[]=new int[36];
    Random k= new Random();
    Button a[]=new Button[36];
    TextView lvldisplay,hitdisplay;
    Button rst;
    int lvlhighnum,lvlmult;
    int count=0;
    int lvl;
    int movcount=0;
    int tempnum,tempnum2;
    thelistener xx=new thelistener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmap2);
        lvl = getIntent().getIntExtra("lvl", 3);
        switch(lvl){
            case 3:
                lvlhighnum=3;
                lvlmult=12;
                break;
            case 4:
                lvlhighnum=6;
                lvlmult=6;
                break;
            case 5:
                lvlhighnum=9;
                lvlmult=4;
                break;
            case 6:
                lvlhighnum=18;

                lvlmult=2;
                break;
        }
        for (int i=0;i<36;i++){
            for (int j = 0; ;){
                j = k.nextInt(lvlhighnum);
                if (avc[j] == lvlmult) continue;
                av[i] = j;
                avc[j]++;
                break;
            }

        }
        lvldisplay=findViewById(R.id.lvldisplay);
        hitdisplay=findViewById(R.id.hitdisplay);
        a[0]=(Button)findViewById(R.id.aa0);
        a[1]=(Button)findViewById(R.id.aa1);
        a[2]=(Button)findViewById(R.id.aa2);
        a[3]=(Button)findViewById(R.id.aa3);
        a[4]=(Button)findViewById(R.id.aa4);
        a[5]=(Button)findViewById(R.id.aa5);
        a[6]=(Button)findViewById(R.id.aa6);
        a[7]=(Button)findViewById(R.id.aa7);
        a[8]=(Button)findViewById(R.id.aa8);
        a[9]=(Button)findViewById(R.id.aa9);
        a[10]=(Button)findViewById(R.id.aa10);
        a[11]=(Button)findViewById(R.id.aa11);
        a[12]=(Button)findViewById(R.id.aa12);
        a[13]=(Button)findViewById(R.id.aa13);
        a[14]=(Button)findViewById(R.id.aa14);
        a[15]=(Button)findViewById(R.id.aa15);
        a[16]=(Button)findViewById(R.id.aa16);
        a[17]=(Button)findViewById(R.id.aa17);
        a[18]=(Button)findViewById(R.id.aa18);
        a[19]=(Button)findViewById(R.id.aa19);
        a[20]=(Button)findViewById(R.id.aa20);
        a[21]=(Button)findViewById(R.id.aa21);
        a[22]=(Button)findViewById(R.id.aa22);
        a[23]=(Button)findViewById(R.id.aa23);
        a[24]=(Button)findViewById(R.id.aa24);
        a[25]=(Button)findViewById(R.id.aa25);
        a[26]=(Button)findViewById(R.id.aa26);
        a[27]=(Button)findViewById(R.id.aa27);
        a[28]=(Button)findViewById(R.id.aa28);
        a[29]=(Button)findViewById(R.id.aa29);
        a[30]=(Button)findViewById(R.id.aa30);
        a[31]=(Button)findViewById(R.id.aa31);
        a[32]=(Button)findViewById(R.id.aa32);
        a[33]=(Button)findViewById(R.id.aa33);
        a[34]=(Button)findViewById(R.id.aa34);
        a[35]=(Button)findViewById(R.id.aa35);

        lvldisplay.setText("lvl :"+lvl);
        for (Button i:a) i.setOnClickListener(xx);
        rst=(Button)findViewById(R.id.rst3);
        rst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mmap2.this,OptionMenu.class));
            }
        });

    }
    public class thelistener implements View.OnClickListener{
        Button temp,temp1;
        @Override
        public void onClick(View v){
            movcount++;
            temp1=temp;
            temp = (Button)findViewById(v.getId());
            for (int i=0;i<36;i++) {
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
                                if (count == 18) {
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

