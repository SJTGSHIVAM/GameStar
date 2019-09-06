package com.example.shivam.gamestar;


import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class bingo extends AppCompatActivity {

    //declarations

    Handler h =new Handler();
    Button fix,rst2,temp;
    EditText opid;
    int counter=1,f1=0,f2=0,f3=0,ts=0,rotateBingo=0;
    Button a[][]=new Button[5][5];
    boolean b[][]=new boolean[5][5];
    TextView checkStack,uniqueNo,tv1,tv2,tv3,tv4,tv5,tv6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bingo);

        //mapping

        fix =findViewById(R.id.fix);
        opid =findViewById(R.id.opid);
        rst2=findViewById(R.id.rst2);
        checkStack=findViewById(R.id.checkstack);
        uniqueNo=findViewById(R.id.uniqueNo);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        tv5=findViewById(R.id.tv5);
        tv6=findViewById(R.id.tv6);

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                String buttonID = "a" + ((i*4)+i+j);
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                a[i][j] =findViewById(resID);
                // Toast.makeText(this,""+buttonID,Toast.LENGTH_LONG).show();
                (a[i][j]).setOnClickListener(new controller());
            }
        }

        //setting a unique /random id

        uniqueNo.setText(""+ new java.util.Random().nextInt(9999));

        //rotating bingo call
        new rotrate().run();

        //actionlisteners

        fix.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!opid.getText().toString().isEmpty())
                    opid.setEnabled(false);
            }});

        rst2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(bingo.this,OptionMenu.class));
            }
        });
    }

    //controller definition basically the heart of the code

    public class controller implements View.OnClickListener{
        @Override
        public void onClick(View v){
            temp=findViewById(v.getId());

            //initial filling phase

            if(counter<26 && temp.getText().toString().isEmpty()){
                temp=findViewById(v.getId());
                temp.setText(""+counter);
                counter++;
            }

            //after filling

            else if(counter>=26){
                checkStack.append(""+temp.getText().toString()+" ");
                temp.setText("");
                temp.setBackgroundResource(R.drawable.crown2);

                //loop for setting the boolean value true

                for(int i=0; i<5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (temp == a[i][j]) {
                            b[i][j] = true;
                        }

                    }
                }

                //loop for checking the dead points and overall crosses
                //for rows and coloumns

                int passrow=0,passcoloumn=0,m,n;
                for(int i=0; i<5; i++) {
                    m=1;
                    n=1;
                    for(int j=0; j<5; j++) {
                        if(m==1){
                            if(!b[i][j]){
                                m=0;
                            }
                            if(j==4 && m==1){
                                passrow++;
                            }
                        }
                        if(n==1){
                            if(!b[j][i]){
                                n=0;
                            }
                            if(j==4 && n==1){
                                passcoloumn++;
                            }
                        }
                        if(m==0&&n==0){
                            break;
                        }
                    }
                    if(i==4){
                        f1=passrow;
                        f2=passcoloumn;
                    }


                }

                //for both diagonals

                m=1;
                n=1;
                for(int i=0;i<5;i++){
                    if(!b[i][i]){
                        m=0;
                    }
                    if(!b[4-i][i]){
                        n=0;
                    }
                    if(i==4){
                        if(m==1&&n==1){
                            f3=2;
                        }
                        else if(m==1){
                            f3=1;
                        }
                        else if(n==1){
                            f3=1;
                        }
                    }
                }
                ts=f1+f2+f3;
                switch(ts){
                    case 0:
                        break;
                    case 1:
                        tv1.setText("B");
                        tv1.setTextColor(0xffff0000);
                        break;
                    case 2:
                        tv1.setText("B");
                        tv1.setTextColor(0xffff0000);
                        tv2.setText("I");
                        tv2.setTextColor(0xffff0000);
                        break;
                    case 3:
                        tv1.setText("B");
                        tv1.setTextColor(0xffff0000);
                        tv2.setText("I");
                        tv2.setTextColor(0xffff0000);
                        tv3.setText("N");
                        tv3.setTextColor(0xffff0000);
                        break;
                    case 4:
                        tv1.setText("B");
                        tv1.setTextColor(0xffff0000);
                        tv2.setText("I");
                        tv2.setTextColor(0xffff0000);
                        tv3.setText("N");
                        tv3.setTextColor(0xffff0000);
                        tv4.setText("G");
                        tv4.setTextColor(0xffff0000);
                        break;
                    default :

                        //here player wins

                        Toast.makeText(bingo.this,"you win",Toast.LENGTH_SHORT).show();
                        for(int i=0; i<5; i++) {
                            for(int j=0; j<5; j++) {
                                if(!b[i][j])
                                    a[i][j].setEnabled(false);
                            }
                        }
                        tv1.setText("B");
                        tv1.setTextColor(0xffff0000);
                        tv2.setText("I");
                        tv2.setTextColor(0xffff0000);
                        tv3.setText("N");
                        tv3.setTextColor(0xffff0000);
                        tv4.setText("G");
                        tv4.setTextColor(0xffff0000);
                        tv5.setText("O");
                        tv5.setTextColor(0xffff0000);
                        tv6.setText("!");
                        tv6.setTextColor(0xffff0000);

                }

            }

        }

    }

    //rotating bingo

    public class rotrate implements Runnable{
        @Override
        public void run(){
            rotateBingo=(++rotateBingo)%6;
            if(ts<5) {
                switch (rotateBingo) {
                    case 0:
                        setnull();
                        tv1.setText("B");
                        break;
                    case 1:
                        setnull();
                        tv2.setText("I");
                        break;
                    case 2:
                        setnull();
                        tv3.setText("N");
                        break;
                    case 3:
                        setnull();
                        tv4.setText("G");
                        break;
                    case 4:
                        setnull();
                        tv5.setText("O");
                        break;
                    case 5:
                        setnull();
                        tv6.setText("!");
                        break;

                }
                h.postDelayed(this, (500-(ts*100)));
            }


        }
        private void setnull(){
            if(ts<1)
                tv1.setText("");
            if(ts<2)
                tv2.setText("");
            if(ts<3)
                tv3.setText("");
            if(ts<4)
                tv4.setText("");

            tv5.setText("");
            tv6.setText("");
        }
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