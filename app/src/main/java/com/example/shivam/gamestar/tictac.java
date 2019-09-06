package com.example.shivam.gamestar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class tictac extends AppCompatActivity {

    int touchcount;
    Button a[][]=new Button[3][3];//buttons on display
    boolean b[][]=new boolean[3][3];
    boolean c[][]=new boolean[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictac);

        Button rst=findViewById(R.id.rsttt2);//reset Button
        touchcount=0;
        touchlistener xx=new touchlistener();

        for (boolean[] i:b){
            for(boolean j:i){
                j=false;
            }
        }
        for (boolean[] i:c){
            for(boolean j:i){
                j=false;
            }
        }
        a[0][0]=findViewById(R.id.ttf1);
        a[0][1]=findViewById(R.id.ttf2);
        a[0][2]=findViewById(R.id.ttf3);
        a[1][0]=findViewById(R.id.ttf4);
        a[1][1]=findViewById(R.id.ttf5);
        a[1][2]=findViewById(R.id.ttf6);
        a[2][0]=findViewById(R.id.ttf7);
        a[2][1]=findViewById(R.id.ttf8);
        a[2][2]=findViewById(R.id.ttf9);


        for (Button[] i:a){
            for(Button j:i){
                j.setOnClickListener(xx);
            }
        }


        rst.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(),OptionMenu.class));}

           });



    }
    class touchlistener implements View.OnClickListener{
        int m,n;
        Button temp;
        @Override
        public void onClick(View v){
            if(touchcount%2==0){
                temp = (Button)findViewById(v.getId());
                temp.setText("O");
                temp.setEnabled(false);
                for (int i=0;i<3;i++) {
                    for (int j=0;j<3;j++) {
                        if(temp==a[i][j]) {
                            b[i][j]=true;
                        }
                    }
                }
            }
            else{
                temp = (Button)findViewById(v.getId());
                temp.setText("X");
                temp.setEnabled(false);
                for (int i=0;i<3;i++) {
                    for (int j=0;j<3;j++) {
                        if(temp==a[i][j]) {
                            c[i][j]=true;
                        }
                    }
                }

            }

            ++touchcount;
       //digonal
            m=1;
            n=1;
            for(int i=0;i<3;i++){
                if(!b[i][i]){
                    m=0;
                }
                if(!b[2-i][i]){
                    n=0;
                }
                if(i==2){
                    if(m==1||n==1) {
                        Toast.makeText(tictac.this,"O wins",Toast.LENGTH_SHORT).show();
                        for (Button[] ii:a){
                            for(Button jj:ii){
                                jj.setEnabled(false);
                            }
                        }

                    }
                }
            }
            //rows and coloumns for zeros
            m=1;
            n=1;
            //int passrow=0,passcoloumn=0;
            for(int i=0; i<3; i++) {
                m=1;
                n=1;
                for(int j=0; j<3; j++) {
                    if(m==1){
                        if(!b[i][j]){
                            m=0;
                        }
                        if(j==2 && m==1){
                            Toast.makeText(tictac.this,"O wins",Toast.LENGTH_SHORT).show();
                            for (Button[] ii:a){
                                for(Button jj:ii){
                                    jj.setEnabled(false);
                                }
                            }

                        }
                    }
                    if(n==1){
                        if(!b[j][i]){
                            n=0;
                        }
                        if(j==2 && n==1){
                            Toast.makeText(tictac.this,"O wins",Toast.LENGTH_SHORT).show();
                            for (Button[] ii:a){
                                for(Button jj:ii){
                                    jj.setEnabled(false);
                                }
                            }

                        }
                    }
                    if(m==0&&n==0){
                        break;
                    }
                }



            }


            for(int i=0; i<3; i++) {
                m=1;
                n=1;
                for(int j=0; j<3; j++) {
                    if(m==1){
                        if(!c[i][j]){
                            m=0;
                        }
                        if(j==2 && m==1){
                            Toast.makeText(tictac.this,"X wins",Toast.LENGTH_SHORT).show();
                            for (Button[] ii:a){
                                for(Button jj:ii){
                                    jj.setEnabled(false);
                                }
                            }

                        }
                    }
                    if(n==1){
                        if(!c[j][i]){
                            n=0;
                        }
                        if(j==2 && n==1){
                            Toast.makeText(tictac.this,"X wins",Toast.LENGTH_SHORT).show();
                            for (Button[] ii:a){
                                for(Button jj:ii){
                                    jj.setEnabled(false);
                                }
                            }

                        }
                    }
                    if(m==0&&n==0){
                        break;
                    }
                }



            }

            //digonal
            m=1;
            n=1;
            for(int i=0;i<3;i++){
                if(!c[i][i]){
                    m=0;
                }
                if(!c[2-i][i]){
                    n=0;
                }
                if(i==2){
                    if(m==1||n==1) {
                        Toast.makeText(tictac.this,"X wins",Toast.LENGTH_SHORT).show();
                        for (Button[] ii:a){
                            for(Button jj:ii){
                                jj.setEnabled(false);
                            }
                        }


                    }
                }
            }

        }
    }
}
