package com.example.shivam.gamestar;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        TextView highScoreLabel = (TextView) findViewById(R.id.highScoreLabel);

        int score = getIntent().getIntExtra("SCORE", 0);
        int label = getIntent().getIntExtra("label", 0);
        scoreLabel.setText(score + "");
        String llabel="";
        switch(label) {
            case 0:  llabel="ctbh"; break;
            case 1:  llabel="m0h"; break;
            case 2:  llabel="m1h"; break;
            case 3:  llabel="m2h"; break;
            case 4:  llabel="m3h"; break;
            case 5:  llabel="m4h"; break;
            case 6:  llabel="m5h"; break;
            case 7:  llabel="m6h"; break;
        }

        SharedPreferences settings = getSharedPreferences(llabel, Context.MODE_PRIVATE);
        int highScore;
        highScore = settings.getInt(llabel, 0);

        if (label==0) {
            highScore = settings.getInt(llabel, 0);
            if (score > highScore) {
                highScoreLabel.setText("High Score : " + score);

                // Update High Score
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt(llabel, score);
                editor.commit();

            } else {
                highScoreLabel.setText("High Score : " + highScore);

            }
        }
        else {
            highScore = settings.getInt(llabel, 4000);
            if (score < highScore) {
                highScoreLabel.setText("min moves : " + score);

                // Update High Score
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt(llabel, score);
                editor.commit();

            } else {
                highScoreLabel.setText("min moves : " + highScore);

            }
        }

    }


    public void tryAgain(View view) {
        startActivity(new Intent(getApplicationContext(), OptionMenu.class));
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