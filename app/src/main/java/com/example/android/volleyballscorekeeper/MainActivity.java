package com.example.android.volleyballscorekeeper;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static int scoreTeamA = 0;
    private static int scoreTeamB = 0;
    private static int set1_A = 0;
    private static int set2_A = 0;
    private static int set3_A = 0;
    private static int set4_A = 0;
    private static int set5_A = 0;
    private static int set1_B = 0;
    private static int set2_B = 0;
    private static int set3_B = 0;
    private static int set4_B = 0;
    private static int set5_B = 0;
    private static int set_team_A = 0;
    private static int set_team_B = 0;
    ProgressBar progress1;
    ProgressBar progress2;
    ProgressBar progress3;
    ProgressBar progress4;
    ProgressBar progress5;
    TextView set1A;
    TextView set2A;
    TextView set3A;
    TextView set4A;
    TextView set5A;
    TextView set1B;
    TextView set2B;
    TextView set3B;
    TextView set4B;
    TextView set5B;
    EditText enterNameA;
    EditText enterNameB;
    TextView nameTeamA;
    TextView nameTeamB;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("SCORE_TEAM_A", scoreTeamA);
        outState.putInt("SCORE_TEAM_B", scoreTeamB);
        outState.putInt("A1_GET", set1_A);
        outState.putInt("A2_GET", set2_A);
        outState.putInt("A3_GET", set3_A);
        outState.putInt("A4_GET", set4_A);
        outState.putInt("A5_GET", set5_A);
        outState.putInt("B1_GET", set1_B);
        outState.putInt("B2_GET", set2_B);
        outState.putInt("B3_GET", set3_B);
        outState.putInt("B4_GET", set4_B);
        outState.putInt("B5_GET", set5_B);
        outState.putInt("SET_TEAM_A_GET", set_team_A);
        outState.putInt("SET_TEAM_B_GET", set_team_B);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress1 = findViewById(R.id.progress1);
        progress2 = findViewById(R.id.progress2);
        progress3 = findViewById(R.id.progress3);
        progress4 = findViewById(R.id.progress4);
        progress5 = findViewById(R.id.progress5);
        enterNameA = findViewById(R.id.enter_name_A);
        enterNameB = findViewById(R.id.enter_name_B);
        nameTeamA = findViewById(R.id.name_team_A);
        nameTeamB = findViewById(R.id.name_team_B);
        enterNameA.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!TextUtils.isEmpty(s)) {
                    s.toString();
                    nameTeamA.setText(s); // Team names entered by user are displayed.
                    enterNameA.setCursorVisible(false);

                    if (count >= 4) {

                        enterNameA.clearFocus();
                        enterNameA.setFocusableInTouchMode(false); // When 5 character (max length) is entered by the user, focusability is removed.
                    }

                } else {
                    nameTeamA.setText("Team A");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        enterNameB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!TextUtils.isEmpty(s)) {
                    s.toString();
                    nameTeamB.setText(s); // Team names entered by user are displayed.
                    enterNameB.setCursorVisible(false);

                    if (count >= 4) {

                        enterNameB.clearFocus();
                        enterNameB.setFocusableInTouchMode(false); // When 5 character (max length) is entered by the user, focusability is removed.
                    }

                } else {
                    nameTeamB.setText("Team B");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        displayForTeamA(scoreTeamA); // displays current score for team A
        displayForTeamB(scoreTeamB); // displays current score for team B
        displaySetA(set_team_A); // displays set score for team A
        displaySetB(set_team_B); // displays set score for team B
        displaySet1(); // displays scores of both teams in the first set
        displaySet2(); // displays scores of both teams in the second set
        displaySet3(); // displays scores of both teams in the third set
        displaySet4(); // displays scores of both teams in the fourth set
        displaySet5(); // displays scores of both teams in the fifth se

        // Before a set is completed, no score is shown on the table.

        if (set_team_A == 0 && set_team_B == 0) {
            String emp = " ";
            set1A = findViewById(R.id.set1_A);
            set2A = findViewById(R.id.set2_A);
            set3A = findViewById(R.id.set3_A);
            set4A = findViewById(R.id.set4_A);
            set5A = findViewById(R.id.set5_A);
            set1B = findViewById(R.id.set1_B);
            set2B = findViewById(R.id.set2_B);
            set3B = findViewById(R.id.set3_B);
            set4B = findViewById(R.id.set4_B);
            set5B = findViewById(R.id.set5_B);
            set1A.setText(emp);
            set2A.setText(emp);
            set3A.setText(emp);
            set4A.setText(emp);
            set5A.setText(emp);
            set1B.setText(emp);
            set2B.setText(emp);
            set3B.setText(emp);
            set4B.setText(emp);
            set5B.setText(emp);
        }

        // Save the state when orientation is changed:

        if (savedInstanceState != null)

        {
            savedInstanceState.getInt("SCORE_TEAM_A", scoreTeamA);
            savedInstanceState.getInt("SCORE_TEAM_B", scoreTeamB);
            savedInstanceState.getInt("SET_TEAM_A_GET", set_team_A);
            savedInstanceState.getInt("SET_TEAM_B_GET", set_team_B);

            // After set 1 is completed:

            if (set_team_A + set_team_B == 1) {

                // save scores in set1:
                savedInstanceState.getInt("A1_GET", set1_A);
                savedInstanceState.getInt("B1_GET", set1_B);
                String emp = "";
                set2A = findViewById(R.id.set2_A);
                set3A = findViewById(R.id.set3_A);
                set4A = findViewById(R.id.set4_A);
                set5A = findViewById(R.id.set5_A);
                set2B = findViewById(R.id.set2_B);
                set3B = findViewById(R.id.set3_B);
                set4B = findViewById(R.id.set4_B);
                set5B = findViewById(R.id.set5_B);
                set2A.setText(emp);
                set3A.setText(emp);
                set4A.setText(emp);
                set5A.setText(emp);
                set2B.setText(emp);
                set3B.setText(emp);
                set4B.setText(emp);
                set5B.setText(emp);

                // save progress bar color(s) in set1:

                if (set1_A > set1_B) {
                    Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress1.setProgressDrawable(progressDrawable);
                } else {
                    Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress1.setProgressDrawable(progressDrawable);
                }
            }

            // After set2 is completed:

            else if (set_team_A + set_team_B == 2) {

                // save scores in set2:

                savedInstanceState.getInt("A1_GET", set1_A);
                savedInstanceState.getInt("B1_GET", set1_B);
                savedInstanceState.getInt("A2_GET", set2_A);
                savedInstanceState.getInt("B2_GET", set2_B);
                String emp = "";
                set3A = findViewById(R.id.set3_A);
                set4A = findViewById(R.id.set4_A);
                set5A = findViewById(R.id.set5_A);
                set3B = findViewById(R.id.set3_B);
                set4B = findViewById(R.id.set4_B);
                set5B = findViewById(R.id.set5_B);
                set3A.setText(emp);
                set4A.setText(emp);
                set5A.setText(emp);
                set3B.setText(emp);
                set4B.setText(emp);
                set5B.setText(emp);

                // save progress bar color(s) in set2:

                if (set1_A > set1_B) {
                    Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress1.setProgressDrawable(progressDrawable);
                } else {
                    Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress1.setProgressDrawable(progressDrawable);
                }

                if (set2_A > set2_B) {
                    Drawable progressDrawable = progress2.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress2.setProgressDrawable(progressDrawable);
                } else {
                    Drawable progressDrawable = progress2.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress2.setProgressDrawable(progressDrawable);
                }
            }

            // After set3 is completed:

            else if (set_team_A + set_team_B == 3) {

                //save scores in set3:

                savedInstanceState.getInt("A1_GET", set1_A);
                savedInstanceState.getInt("B1_GET", set1_B);
                savedInstanceState.getInt("A2_GET", set2_A);
                savedInstanceState.getInt("B2_GET", set2_B);
                savedInstanceState.getInt("A3_GET", set3_A);
                savedInstanceState.getInt("B3_GET", set3_B);
                String emp = "";
                set4A = findViewById(R.id.set4_A);
                set5A = findViewById(R.id.set5_A);
                set4B = findViewById(R.id.set4_B);
                set5B = findViewById(R.id.set5_B);
                set4A.setText(emp);
                set5A.setText(emp);
                set4B.setText(emp);
                set5B.setText(emp);

                // save progress bar color(s) in set3;

                if (set1_A > set1_B) {
                    Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress1.setProgressDrawable(progressDrawable);
                } else {
                    Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress1.setProgressDrawable(progressDrawable);
                }

                if (set2_A > set2_B) {
                    Drawable progressDrawable = progress2.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress2.setProgressDrawable(progressDrawable);
                } else {
                    Drawable progressDrawable = progress2.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress2.setProgressDrawable(progressDrawable);
                }
                if (set3_A > set3_B) {
                    Drawable progressDrawable = progress3.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress3.setProgressDrawable(progressDrawable);
                } else {
                    Drawable progressDrawable = progress3.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress3.setProgressDrawable(progressDrawable);
                }
            }

            // After set4 is completed:

            else if (set_team_A + set_team_B == 4) {

                // save scores in set4:

                savedInstanceState.getInt("A1_GET", set1_A);
                savedInstanceState.getInt("B1_GET", set1_B);
                savedInstanceState.getInt("A2_GET", set2_A);
                savedInstanceState.getInt("B2_GET", set2_B);
                savedInstanceState.getInt("A3_GET", set3_A);
                savedInstanceState.getInt("B3_GET", set3_B);
                savedInstanceState.getInt("A4_GET", set4_A);
                savedInstanceState.getInt("B4_GET", set4_B);
                String emp = "";
                set5A = findViewById(R.id.set5_A);
                set5B = findViewById(R.id.set5_B);
                set5A.setText(emp);
                set5B.setText(emp);

                // save progress bar colors in set4:

                if (set1_A > set1_B) {
                    Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress1.setProgressDrawable(progressDrawable);
                } else {
                    Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress1.setProgressDrawable(progressDrawable);
                }

                if (set2_A > set2_B) {
                    Drawable progressDrawable = progress2.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress2.setProgressDrawable(progressDrawable);
                } else {
                    Drawable progressDrawable = progress2.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress2.setProgressDrawable(progressDrawable);
                }
                if (set3_A > set3_B) {
                    Drawable progressDrawable = progress3.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress3.setProgressDrawable(progressDrawable);
                } else {
                    Drawable progressDrawable = progress3.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress3.setProgressDrawable(progressDrawable);
                }

                if (set4_A > set4_B) {
                    Drawable progressDrawable = progress4.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress4.setProgressDrawable(progressDrawable);
                } else {
                    Drawable progressDrawable = progress4.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress4.setProgressDrawable(progressDrawable);
                }
            }

            // After set5 is completed:

            else if (set_team_A + set_team_B == 5) {

                // save scores in set5:

                savedInstanceState.getInt("A5_GET", set5_A);
                savedInstanceState.getInt("B5_GET", set5_B);

                // save progress bar color(s) in set5:

                if (set1_A > set1_B) {
                    Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress1.setProgressDrawable(progressDrawable);
                } else {
                    Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress1.setProgressDrawable(progressDrawable);
                }

                if (set2_A > set2_B) {
                    Drawable progressDrawable = progress2.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress2.setProgressDrawable(progressDrawable);
                } else {
                    Drawable progressDrawable = progress2.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress2.setProgressDrawable(progressDrawable);
                }
                if (set3_A > set3_B) {
                    Drawable progressDrawable = progress3.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress3.setProgressDrawable(progressDrawable);
                } else {
                    Drawable progressDrawable = progress3.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress3.setProgressDrawable(progressDrawable);
                }

                if (set4_A > set4_B) {
                    Drawable progressDrawable = progress4.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress4.setProgressDrawable(progressDrawable);
                } else {
                    Drawable progressDrawable = progress4.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress4.setProgressDrawable(progressDrawable);
                }

                if (set5_A > set5_B) {
                    Drawable progressDrawable = progress5.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress5.setProgressDrawable(progressDrawable);
                } else {
                    Drawable progressDrawable = progress5.getProgressDrawable().mutate();
                    progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                    progress5.setProgressDrawable(progressDrawable);
                }
            } else
                return;

        }
    }


    public void displayForTeamA(int scoreTeamA) {

        //displays current score for team A

        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreTeamA));
    }

    public void incrementTeamA(View view) {

        // increases current score for Team A when + button is pressed.

        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
        controlAndSetScoreTableForTeamA();

    }

    public void decrementTeamA(View view) {

        // decreases current score for Team A when - button is pressed.

        scoreTeamA = scoreTeamA - 1;
        if (scoreTeamA < 0) {
            scoreTeamA = 0;
            Toast.makeText(MainActivity.this,
                    "Score cannot be negative!", Toast.LENGTH_SHORT).show(); // Toast screen warns user about negative number
            return;

        }
        displayForTeamA(scoreTeamA);
        controlAndSetScoreTableForTeamA();

    }

    public void displayForTeamB(int scoreTeamB) {

        //displays current score for team B

        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreTeamB));
    }

    public void incrementTeamB(View view) {

        // increases current score for Team B when + button is pressed.

        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
        controlAndSetScoreTableForTeamB();
    }

    public void decrementTeamB(View view) {

        // decreases current score for Team B when - button is pressed.

        scoreTeamB = scoreTeamB - 1;
        if (scoreTeamB < 0) {
            scoreTeamB = 0;
            Toast.makeText(MainActivity.this,
                    "Score cannot be negative!", Toast.LENGTH_SHORT).show(); // Toast screen warns user about negative number
            return;

        }
        displayForTeamB(scoreTeamB);
        controlAndSetScoreTableForTeamB();

    }

    public void displaySet1() {

        // displays set1 scores in a table:

        TextView set1A = findViewById(R.id.set1_A);
        set1A.setText(String.valueOf(set1_A));
        TextView set1B = findViewById(R.id.set1_B);
        set1B.setText(String.valueOf(set1_B));
    }

    public void displaySet2() {

        // displays set2 scores in a table:

        TextView set2A = findViewById(R.id.set2_A);
        set2A.setText(String.valueOf(set2_A));
        TextView set2B = findViewById(R.id.set2_B);
        set2B.setText(String.valueOf(set2_B));
    }

    public void displaySet3() {

        // displays set3 scores in a table:

        TextView set3A = findViewById(R.id.set3_A);
        set3A.setText(String.valueOf(set3_A));
        TextView set3B = findViewById(R.id.set3_B);
        set3B.setText(String.valueOf(set3_B));
    }

    public void displaySet4() {

        // displays set4 scores in a table:

        TextView set4A = findViewById(R.id.set4_A);
        set4A.setText(String.valueOf(set4_A));
        TextView set4B = findViewById(R.id.set4_B);
        set4B.setText(String.valueOf(set4_B));
    }

    public void displaySet5() {

        // displays set5 scores in a table:

        TextView set5A = findViewById(R.id.set5_A);
        set5A.setText(String.valueOf(set5_A));
        TextView set5B = findViewById(R.id.set5_B);
        set5B.setText(String.valueOf(set5_B));
    }

    public void controlAndSetScoreTableForTeamA() {

        int limit = 24;
        if (progress4.getProgress() == 100) {
            limit = 14; // taybrek set for 2-2 case.
        }
        if (scoreTeamA > limit && scoreTeamA > scoreTeamB + 1) {
            if (progress1.getProgress() == 0) {

                // progress bar color change to blue (color of Team A) for set 1:
                progress1.setProgress(100);
                Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress1.setProgressDrawable(progressDrawable);

                //set1 scores are equalized to the score displayed:
                set1_A = scoreTeamA;
                set1_B = scoreTeamB;
                displaySet1(); //set1 scores on the table

                // set score is incremented for team A:
                set_team_A = set_team_A + 1;

                // set score is displayed next to the current score for team A:
                displaySetA(set_team_A);

            } else if (progress2.getProgress() == 0) {

                // progress bar color change to blue (color of Team A) for set 2:
                progress2.setProgress(100);
                Drawable progressDrawable = progress2.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress2.setProgressDrawable(progressDrawable);

                //set2 scores are equalized to the score displayed:
                set2_A = scoreTeamA;
                set2_B = scoreTeamB;
                displaySet2(); //set2 scores on the table

                // set score is incremented for team A:
                set_team_A = set_team_A + 1;

                // set score is displayed next to the current score for team A (in the blue box):
                displaySetA(set_team_A);
            } else if (progress3.getProgress() == 0) {

                // progress bar color change to blue (color of Team A) for set 3:
                progress3.setProgress(100);
                Drawable progressDrawable = progress3.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress3.setProgressDrawable(progressDrawable);

                //set3 scores are equalized to the score displayed:
                set3_A = scoreTeamA;
                set3_B = scoreTeamB;
                displaySet3(); //set3 scores on the table

                // set score is incremented for team A:
                set_team_A = set_team_A + 1;

                // set score is displayed next to the current score for team A (in the blue box):
                displaySetA(set_team_A);
            } else if (progress4.getProgress() == 0) {

                // progress bar color change to blue (color of Team A) for set 4:
                progress4.setProgress(100);
                Drawable progressDrawable = progress4.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress4.setProgressDrawable(progressDrawable);

                //set4 scores are equalized to the score displayed:
                set4_A = scoreTeamA;
                set4_B = scoreTeamB;
                displaySet4(); //set4 scores on the table

                // set score is incremented for team A:
                set_team_A = set_team_A + 1;

                // set score is displayed next to the current score for team A (in the blue box):
                displaySetA(set_team_A);

            } else if (progress5.getProgress() == 0) {

                // progress bar color change to blue (color of Team A) for set 5:
                progress5.setProgress(100);
                Drawable progressDrawable = progress5.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
                progress5.setProgressDrawable(progressDrawable);

                //set5 scores are equalized to the score displayed:
                set5_A = scoreTeamA;
                set5_B = scoreTeamB;
                displaySet5(); //set5 scores on the table

                // set score is incremented for team A:
                set_team_A = set_team_A + 1;

                // set score is displayed next to the current score for team A (in the blue box):
                displaySetA(set_team_A);


            }
            resetScoreTables(); // current scores are reseted at the end of each set is won.
        }

    }

    public void controlAndSetScoreTableForTeamB() {

        int limit = 24;
        if (progress4.getProgress() == 100) {
            limit = 14; //for taybrek series (2-2 case)
        }
        if (scoreTeamB > limit && scoreTeamB > scoreTeamA + 1) {
            if (progress1.getProgress() == 0) {

                // progress bar color change to red (color of Team B) for set 1:
                progress1.setProgress(100);
                Drawable progressDrawable = progress1.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress1.setProgressDrawable(progressDrawable);

                //set1 scores are equalized to the score displayed:
                set1_A = scoreTeamA;
                set1_B = scoreTeamB;
                displaySet1(); //set5 scores on the table

                // set score is incremented for team B:
                set_team_B = set_team_B + 1;

                // set score is displayed next to the current score for team B (in the red box):
                displaySetB(set_team_B);

            } else if (progress2.getProgress() == 0) {

                // progress bar color change to red (color of Team B) for set 2:
                progress2.setProgress(100);
                Drawable progressDrawable = progress2.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress2.setProgressDrawable(progressDrawable);

                //set2 scores are equalized to the score displayed:
                set2_A = scoreTeamA;
                set2_B = scoreTeamB;
                displaySet2(); //set2 scores on the table

                // set score is incremented for team B:
                set_team_B = set_team_B + 1;

                // set score is displayed next to the current score for team B (in the red box):
                displaySetB(set_team_B);

            } else if (progress3.getProgress() == 0) {

                // progress bar color change to red (color of Team B) for set 3:
                progress3.setProgress(100);
                Drawable progressDrawable = progress3.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress3.setProgressDrawable(progressDrawable);

                //set3 scores are equalized to the score displayed:
                set3_A = scoreTeamA;
                set3_B = scoreTeamB;
                displaySet3(); //set3 scores on the table

                // set score is incremented for team B:
                set_team_B = set_team_B + 1;

                // set score is displayed next to the current score for team B (in the red box):
                displaySetB(set_team_B);
            } else if (progress4.getProgress() == 0) {

                // progress bar color change to red (color of Team B) for set 4:
                progress4.setProgress(100);
                Drawable progressDrawable = progress4.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress4.setProgressDrawable(progressDrawable);

                //set4 scores are equalized to the score displayed:
                set4_A = scoreTeamA;
                set4_B = scoreTeamB;
                displaySet4(); //set4 scores on the table

                // set score is incremented for team B:
                set_team_B = set_team_B + 1;

                // set score is displayed next to the current score for team B (in the red box):
                displaySetB(set_team_B);
            } else if (progress5.getProgress() == 0) {

                // progress bar color change to red (color of Team B) for set 5:
                progress5.setProgress(100);
                Drawable progressDrawable = progress5.getProgressDrawable().mutate();
                progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                progress5.setProgressDrawable(progressDrawable);

                //set5 scores are equalized to the score displayed:
                set5_A = scoreTeamA;
                set5_B = scoreTeamB;
                displaySet5(); //set5 scores on the table

                // set score is incremented for team B:
                set_team_B = set_team_B + 1;

                // set score is displayed next to the current score for team B (in the red box):
                displaySetB(set_team_B);
            }

            resetScoreTables(); // current scores are reseted at the end of each set is won.
        }
    }

    public void displaySetA(int set_team_A) {

        TextView setTeamA = findViewById(R.id.set_team_A);
        setTeamA.setText(String.valueOf(set_team_A));
        displayWinner();
    }


    public void displaySetB(int set_team_B) {

        TextView setTeamB = findViewById(R.id.set_team_B);
        setTeamB.setText(String.valueOf(set_team_B));
        displayWinner();
    }

    public void displayWinner() {

        // when one of the teams has set score of 3, game finishes.
        // When game finishes, a new pop-up screen which shows winner, match result and set score table is displayed.

        if (((set_team_A == 3) && (set_team_B < set_team_A)) || ((set_team_B == 3) && (set_team_A < set_team_B))) {

            Intent i = new Intent();
            i.setClass(MainActivity.this, PopAFinish.class); // Pop-up intent class

            // data is outed from Main Activity to PopAFinish.class:

            TextView nameTeamA = findViewById(R.id.name_team_A);
            i.putExtra("name_team_A", nameTeamA.getText().toString());
            TextView nameTeamB = findViewById(R.id.name_team_B);
            i.putExtra("name_team_B", nameTeamB.getText().toString());
            TextView setTeamA = findViewById(R.id.set_team_A);
            i.putExtra("out_setTeamA", setTeamA.getText().toString());
            TextView setTeamB = findViewById(R.id.set_team_B);
            i.putExtra("out_setTeamB", setTeamB.getText().toString());
            TextView set1A = findViewById(R.id.set1_A);
            i.putExtra("out_set1A", set1A.getText().toString());
            TextView set2A = findViewById(R.id.set2_A);
            i.putExtra("out_set2A", set2A.getText().toString());
            TextView set3A = findViewById(R.id.set3_A);
            i.putExtra("out_set3A", set3A.getText().toString());
            TextView set4A = findViewById(R.id.set4_A);
            i.putExtra("out_set4A", set4A.getText().toString());
            TextView set5A = findViewById(R.id.set5_A);
            i.putExtra("out_set5A", set5A.getText().toString());
            TextView set1B = findViewById(R.id.set1_B);
            i.putExtra("out_set1B", set1B.getText().toString());
            TextView set2B = findViewById(R.id.set2_B);
            i.putExtra("out_set2B", set2B.getText().toString());
            TextView set3B = findViewById(R.id.set3_B);
            i.putExtra("out_set3B", set3B.getText().toString());
            TextView set4B = findViewById(R.id.set4_B);
            i.putExtra("out_set4B", set4B.getText().toString());
            TextView set5B = findViewById(R.id.set5_B);
            i.putExtra("out_set5B", set5B.getText().toString());

            startActivity(i);

            reset();

        }
    }

    public void resetScoreTables() {

        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    public void reset() {

        // When game finishes and pop-up screen which shows results is displayed, data in the main screen is reseted.

        //Reset scores and set scores:
        scoreTeamA = 0;
        scoreTeamB = 0;
        set_team_A = 0;
        set_team_B = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displaySetA(set_team_A);
        displaySetB(set_team_B);

        //Reset progress bar colors

        //Reset progress bar1:
        progress1.setProgress(0);
        Drawable progressDrawable1 = progress1.getProgressDrawable().mutate();
        progressDrawable1.setColorFilter(Color.LTGRAY, android.graphics.PorterDuff.Mode.SRC_IN);
        progress1.setProgressDrawable(progressDrawable1);

        //Reset progress bar2:
        progress2.setProgress(0);
        Drawable progressDrawable2 = progress2.getProgressDrawable().mutate();
        progressDrawable2.setColorFilter(Color.LTGRAY, android.graphics.PorterDuff.Mode.SRC_IN);
        progress2.setProgressDrawable(progressDrawable2);

        //Reset progress bar3:
        progress3.setProgress(0);
        Drawable progressDrawable3 = progress3.getProgressDrawable().mutate();
        progressDrawable3.setColorFilter(Color.LTGRAY, android.graphics.PorterDuff.Mode.SRC_IN);
        progress3.setProgressDrawable(progressDrawable3);

        //Reset progress bar4:
        progress4.setProgress(0);
        Drawable progressDrawable4 = progress4.getProgressDrawable().mutate();
        progressDrawable4.setColorFilter(Color.LTGRAY, android.graphics.PorterDuff.Mode.SRC_IN);
        progress4.setProgressDrawable(progressDrawable4);

        //Reset progress bar5:
        progress5.setProgress(0);
        Drawable progressDrawable5 = progress5.getProgressDrawable().mutate();
        progressDrawable5.setColorFilter(Color.LTGRAY, android.graphics.PorterDuff.Mode.SRC_IN);
        progress5.setProgressDrawable(progressDrawable5);

        //Reset team names
        //Reset team name A:
        enterNameA = findViewById(R.id.enter_name_A);
        enterNameA.setText("");
        nameTeamA = findViewById(R.id.name_team_A);
        nameTeamA.setText("Team A");
        //Reset team name B:
        enterNameB = findViewById(R.id.enter_name_B);
        enterNameB.setText("");
        nameTeamB = findViewById(R.id.name_team_B);
        nameTeamB.setText("Team B");

        //Reset scores belonging to each set in the table:
        String emp = " ";
        set1A = findViewById(R.id.set1_A);
        set2A = findViewById(R.id.set2_A);
        set3A = findViewById(R.id.set3_A);
        set4A = findViewById(R.id.set4_A);
        set5A = findViewById(R.id.set5_A);
        set1B = findViewById(R.id.set1_B);
        set2B = findViewById(R.id.set2_B);
        set3B = findViewById(R.id.set3_B);
        set4B = findViewById(R.id.set4_B);
        set5B = findViewById(R.id.set5_B);
        set1A.setText(emp);
        set2A.setText(emp);
        set3A.setText(emp);
        set4A.setText(emp);
        set5A.setText(emp);
        set1B.setText(emp);
        set2B.setText(emp);
        set3B.setText(emp);
        set4B.setText(emp);
        set5B.setText(emp);

        //Reset focusability of EditTexts:

        enterNameA.setFocusableInTouchMode(true);
        enterNameB.setFocusableInTouchMode(true);

    }


    public void resetGame(View view) {

        // If Reset button is clicked, this method is triggered.

        //Reset scores and set scores:
        scoreTeamA = 0;
        scoreTeamB = 0;
        set_team_A = 0;
        set_team_B = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displaySetA(set_team_A);
        displaySetB(set_team_B);

        //Reset progress bar colors

        //Reset progress bar1:
        progress1.setProgress(0);
        Drawable progressDrawable1 = progress1.getProgressDrawable().mutate();
        progressDrawable1.setColorFilter(Color.LTGRAY, android.graphics.PorterDuff.Mode.SRC_IN);
        progress1.setProgressDrawable(progressDrawable1);

        //Reset progress bar2:
        progress2.setProgress(0);
        Drawable progressDrawable2 = progress2.getProgressDrawable().mutate();
        progressDrawable2.setColorFilter(Color.LTGRAY, android.graphics.PorterDuff.Mode.SRC_IN);
        progress2.setProgressDrawable(progressDrawable2);

        //Reset progress bar3:
        progress3.setProgress(0);
        Drawable progressDrawable3 = progress3.getProgressDrawable().mutate();
        progressDrawable3.setColorFilter(Color.LTGRAY, android.graphics.PorterDuff.Mode.SRC_IN);
        progress3.setProgressDrawable(progressDrawable3);

        //Reset progress bar4:
        progress4.setProgress(0);
        Drawable progressDrawable4 = progress4.getProgressDrawable().mutate();
        progressDrawable4.setColorFilter(Color.LTGRAY, android.graphics.PorterDuff.Mode.SRC_IN);
        progress4.setProgressDrawable(progressDrawable4);

        //Reset progress bar5:
        progress5.setProgress(0);
        Drawable progressDrawable5 = progress5.getProgressDrawable().mutate();
        progressDrawable5.setColorFilter(Color.LTGRAY, android.graphics.PorterDuff.Mode.SRC_IN);
        progress5.setProgressDrawable(progressDrawable5);

        //Reset team names
        //Reset team name A:
        enterNameA = findViewById(R.id.enter_name_A);
        enterNameA.setText("");
        nameTeamA = findViewById(R.id.name_team_A);
        nameTeamA.setText("Team A");
        //Reset team name B:
        enterNameB = findViewById(R.id.enter_name_B);
        enterNameB.setText("");
        nameTeamB = findViewById(R.id.name_team_B);
        nameTeamB.setText("Team B");

        //Reset scores belonging to each set in the table:
        String emp = " ";
        set1A = findViewById(R.id.set1_A);
        set2A = findViewById(R.id.set2_A);
        set3A = findViewById(R.id.set3_A);
        set4A = findViewById(R.id.set4_A);
        set5A = findViewById(R.id.set5_A);
        set1B = findViewById(R.id.set1_B);
        set2B = findViewById(R.id.set2_B);
        set3B = findViewById(R.id.set3_B);
        set4B = findViewById(R.id.set4_B);
        set5B = findViewById(R.id.set5_B);
        set1A.setText(emp);
        set2A.setText(emp);
        set3A.setText(emp);
        set4A.setText(emp);
        set5A.setText(emp);
        set1B.setText(emp);
        set2B.setText(emp);
        set3B.setText(emp);
        set4B.setText(emp);
        set5B.setText(emp);

        //Reset focusability of EditTexts:

        enterNameA.setFocusableInTouchMode(true);
        enterNameB.setFocusableInTouchMode(true);

    }
}
