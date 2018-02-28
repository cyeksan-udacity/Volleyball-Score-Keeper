package com.example.android.volleyballscorekeeper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Cansu on 25.02.2018.
 */

public class PopAFinish extends Activity {

    String set1A;
    String set2A;
    String set3A;
    String set4A;
    String set5A;
    String set1B;
    String set2B;
    String set3B;
    String set4B;
    String set5B;
    String setTeamA;
    String setTeamB;
    String nameTeamA;
    String nameTeamB;
    String winner;

    TextView A1;
    TextView A2;
    TextView A3;
    TextView A4;
    TextView A5;
    TextView B1;
    TextView B2;
    TextView B3;
    TextView B4;
    TextView B5;
    TextView A;
    TextView B;
    TextView TeamA;
    TextView TeamB;
    TextView Winner;

    ProgressBar progress1;
    ProgressBar progress2;
    ProgressBar progress3;
    ProgressBar progress4;
    ProgressBar progress5;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popa);

        //set layout properties of pop-up window:

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .7), (int) (height * .9));

        //Concatenate:

        A1 = findViewById(R.id.set1_A);
        A2 = findViewById(R.id.set2_A);
        A3 = findViewById(R.id.set3_A);
        A4 = findViewById(R.id.set4_A);
        A5 = findViewById(R.id.set5_A);
        B1 = findViewById(R.id.set1_B);
        B2 = findViewById(R.id.set2_B);
        B3 = findViewById(R.id.set3_B);
        B4 = findViewById(R.id.set4_B);
        B5 = findViewById(R.id.set5_B);
        A = findViewById(R.id.set_team_A);
        B = findViewById(R.id.set_team_B);
        TeamA = findViewById(R.id.name_team_A);
        TeamB = findViewById(R.id.name_team_B);
        Winner = findViewById(R.id.winner);
        progress1 = findViewById(R.id.progress1);
        progress2 = findViewById(R.id.progress2);
        progress3 = findViewById(R.id.progress3);
        progress4 = findViewById(R.id.progress4);
        progress5 = findViewById(R.id.progress5);

        // data is get from Main Activity to PopAFinish.class:

        Intent i = getIntent();
        this.set1A = i.getStringExtra("out_set1A");
        this.set2A = i.getStringExtra("out_set2A");
        this.set3A = i.getStringExtra("out_set3A");
        this.set4A = i.getStringExtra("out_set4A");
        this.set5A = i.getStringExtra("out_set5A");
        this.set1B = i.getStringExtra("out_set1B");
        this.set2B = i.getStringExtra("out_set2B");
        this.set3B = i.getStringExtra("out_set3B");
        this.set4B = i.getStringExtra("out_set4B");
        this.set5B = i.getStringExtra("out_set5B");
        this.setTeamA = i.getStringExtra("out_setTeamA");
        this.setTeamB = i.getStringExtra("out_setTeamB");
        this.nameTeamA = i.getStringExtra("name_team_A");
        this.nameTeamB = i.getStringExtra("name_team_B");

        //Chech the winner:

        if (Integer.parseInt(setTeamB) < Integer.parseInt(setTeamA)) {
            Winner.setText(nameTeamA + " IS THE WINNER!");
            winner = nameTeamA;
        } else if (Integer.parseInt(setTeamB) > Integer.parseInt(setTeamA)) {
            Winner.setText(nameTeamB + " IS THE WINNER!");
            winner = nameTeamB;

        }

        //Write set scores to the cells in the table:

        A1.setText(set1A);
        A2.setText(set2A);
        A3.setText(set3A);
        A4.setText(set4A);
        A5.setText(set5A);
        B1.setText(set1B);
        B2.setText(set2B);
        B3.setText(set3B);
        B4.setText(set4B);
        B5.setText(set5B);
        A.setText(setTeamA);
        B.setText(setTeamB);
        TeamA.setText(nameTeamA);
        TeamB.setText(nameTeamB);

        //Set progress bar color for each set according to the winner's color (Team A --> blue, Team B --> red)
        // If 3 sets are played, colors of 3 progress bars will be changed:

        if (Integer.parseInt(setTeamA) + Integer.parseInt(setTeamB) == 3) {

            if (Integer.parseInt(set1A) > Integer.parseInt(set1B)) {
                Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress1.setProgressDrawable(progressDrawable);
            } else {
                Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress1.setProgressDrawable(progressDrawable);
            }

            if (Integer.parseInt(set2A) > Integer.parseInt(set2B)) {
                Drawable progressDrawable = progress2.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress2.setProgressDrawable(progressDrawable);
            } else {
                Drawable progressDrawable = progress2.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress2.setProgressDrawable(progressDrawable);
            }
            if (Integer.parseInt(set3A) > Integer.parseInt(set3B)) {
                Drawable progressDrawable = progress3.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress3.setProgressDrawable(progressDrawable);
            } else {
                Drawable progressDrawable = progress3.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress3.setProgressDrawable(progressDrawable);
            }

        }

        // If 4 sets are played, colors of 4 progress bars will be changed:

        if (Integer.parseInt(setTeamA) + Integer.parseInt(setTeamB) == 4) {
            if (Integer.parseInt(set1A) > Integer.parseInt(set1B)) {
                Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress1.setProgressDrawable(progressDrawable);
            } else {
                Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress1.setProgressDrawable(progressDrawable);
            }

            if (Integer.parseInt(set2A) > Integer.parseInt(set2B)) {
                Drawable progressDrawable = progress2.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress2.setProgressDrawable(progressDrawable);
            } else {
                Drawable progressDrawable = progress2.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress2.setProgressDrawable(progressDrawable);
            }
            if (Integer.parseInt(set3A) > Integer.parseInt(set3B)) {
                Drawable progressDrawable = progress3.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress3.setProgressDrawable(progressDrawable);
            } else {
                Drawable progressDrawable = progress3.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress3.setProgressDrawable(progressDrawable);
            }
            if (Integer.parseInt(set4A) > Integer.parseInt(set4B)) {
                Drawable progressDrawable = progress4.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress4.setProgressDrawable(progressDrawable);
            } else {
                Drawable progressDrawable = progress4.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress4.setProgressDrawable(progressDrawable);
            }
        }

        // If 5 sets are played, colors of 5 progress bars will be changed:

        if (Integer.parseInt(setTeamA) + Integer.parseInt(setTeamB) == 5) {
            if (Integer.parseInt(set1A) > Integer.parseInt(set1B)) {
                Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress1.setProgressDrawable(progressDrawable);
            } else {
                Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress1.setProgressDrawable(progressDrawable);
            }

            if (Integer.parseInt(set2A) > Integer.parseInt(set2B)) {
                Drawable progressDrawable = progress2.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress2.setProgressDrawable(progressDrawable);
            } else {
                Drawable progressDrawable = progress2.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress2.setProgressDrawable(progressDrawable);
            }
            if (Integer.parseInt(set3A) > Integer.parseInt(set3B)) {
                Drawable progressDrawable = progress3.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress3.setProgressDrawable(progressDrawable);
            } else {
                Drawable progressDrawable = progress3.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress3.setProgressDrawable(progressDrawable);
            }
            if (Integer.parseInt(set4A) > Integer.parseInt(set4B)) {
                Drawable progressDrawable = progress4.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress4.setProgressDrawable(progressDrawable);
            } else {
                Drawable progressDrawable = progress4.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress4.setProgressDrawable(progressDrawable);
            }
            if (Integer.parseInt(set5A) > Integer.parseInt(set5B)) {
                Drawable progressDrawable = progress5.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress5.setProgressDrawable(progressDrawable);
            } else {
                Drawable progressDrawable = progress5.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress5.setProgressDrawable(progressDrawable);
            }
        }
    }

    public void send(View v) {

        //When Send Results button is clicked, this method is triggered:

        String score = "Please find the match results below: \n\n"
                + "• Winner is " + winner + ".\n\n"
                + "• Result: " + setTeamA + " - " + setTeamB + ".\n\n"
                + "• Scores: " + nameTeamA + " - " + nameTeamB + "\n"
                + "  - Set 1: " + set1A + " - " + set1B + "\n"
                + "  - Set 2: " + set2A + " - " + set2B + "\n"
                + "  - Set 3: " + set3A + " - " + set3B + "\n";

        if (Integer.parseInt(setTeamA) + Integer.parseInt(setTeamB) == 4) {
            score = score + "  - Set 4: " + set4A + " - " + set4B + "\n";
        } else if (Integer.parseInt(setTeamA) + Integer.parseInt(setTeamB) == 5) {
            score = score + "  - Set 4: " + set4A + " - " + set4B + "\n" + "  - Set 5: " + set5A + " - " + set5B + "\n";
        }

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, score);
        intent.setType("text/plain");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }
    }
}
