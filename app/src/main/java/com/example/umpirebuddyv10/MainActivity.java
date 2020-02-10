package com.example.umpirebuddyv10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int ballCount = 0;
    private int strikeCount = 0;
    private Button ballbtn, strikebtn, resetbtn, exitbtn, aboutbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         ballbtn =  findViewById(R.id.addBallBtn);
         strikebtn = findViewById(R.id.addStrikeBtn);
         resetbtn = findViewById(R.id.resetbtn);
         exitbtn = findViewById(R.id.exitButton);
         aboutbtn = findViewById(R.id.aboutButton);

        ballbtn.setOnClickListener(this);
        strikebtn.setOnClickListener(this);
        resetbtn.setOnClickListener(this);
        exitbtn.setOnClickListener(this);
        aboutbtn.setOnClickListener(this);

    }

    private void updateBalldisplay() {
        TextView updateBallcnt = findViewById(R.id.ballCounter);
        String dispcount = getString(R.string.current_count_ball);
        dispcount += ballCount;
        updateBallcnt.setText(dispcount);
    }

    private void updateStrikedisplay() {
        TextView updateStrikecnt = findViewById(R.id.strikeCounter);
        String dispcount = getString(R.string.current_count_strike);
        dispcount += strikeCount;
        updateStrikecnt.setText(dispcount);
    }

    private void ballDialog() {
        AlertDialog.Builder ballpopup = new AlertDialog.Builder(MainActivity.this);
        ballpopup.setTitle("Walk!");
        ballpopup.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ballpopup.show();
    }

    private void strikeDialog() {
        AlertDialog.Builder strikepopup = new AlertDialog.Builder(MainActivity.this);
        strikepopup.setTitle("Out!");
        strikepopup.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        strikepopup.show();
    }

    private void disableButtons(){
        ballbtn.setEnabled(false);
        strikebtn.setEnabled(false);
    }

    private void enableButtons(){
        ballbtn.setEnabled(true);
        strikebtn.setEnabled(true);
    }

    public void switchActivity(){
        Intent intentAbout = new Intent(this, AboutActivity.class);
        startActivity(intentAbout);
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.addBallBtn:

                if (ballCount >= 3) {
                    ballCount++;
                    updateBalldisplay();
                    ballDialog();
                    disableButtons();

                }
                else {
                    ballCount++;
                    updateBalldisplay();
                }
                break;

            case R.id.addStrikeBtn:
                if (strikeCount >= 2) {
                    strikeCount++;
                    updateStrikedisplay();
                    strikeDialog();
                    disableButtons();
                }
                else {
                    strikeCount++;
                    updateStrikedisplay();
                }
                break;

            case R.id.resetbtn:
                ballCount = 0;
                strikeCount = 0;
                updateBalldisplay();
                updateStrikedisplay();
                enableButtons();
                break;

            case R.id.exitButton:
                finish();
                System.exit(0);

            case R.id.aboutButton:
                switchActivity();
                break;




        }

    }
}
