package com.example.android.speedwaycounter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.speedwaycounter.R;

import java.lang.reflect.Method;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {
    int roundNumber = 1;
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int extraPointsTeamA = 0;
    int extraPointsTeamB = 0;
    int totalTeamA = 0;
    int totalTeamB = 0;
    boolean threePointsARed = false;
    boolean twoPointsARed = false;
    boolean onePointARed = false;
    boolean threePointsABlue = false;
    boolean twoPointsABlue = false;
    boolean onePointABlue = false;
    boolean threePointsBWhite = false;
    boolean twoPointsBWhite = false;
    boolean onePointBWhite = false;
    boolean threePointsBYellow = false;
    boolean twoPointsBYellow = false;
    boolean onePointBYellow = false;
    boolean gameOver = false;

    private static final String STATE_TOTALTEAMA = "StateOfTotalTeamA";
    private static final String STATE_TOTALTEAMB = "StateOfTotalTeamB";
    private static final String STATE_BASICTEAMA = "StateOfBasicTeamA";
    private static final String STATE_BASICTEAMB = "StateOfBasicTeamB";
    private static final String STATE_BONUSTEAMA = "StateOfBonusTeamA";
    private static final String STATE_BONUSTEAMB = "StateOfBonusTeamB";
    private static final String STATE_ROUNDNUMBER = "StateOfRoundNumber";
    private static final String STATE_THREEPOINTSARED = "StateofThreePointsARed";
    private static final String STATE_TWOPOINTSARED = "StateofTwoPointsARed";
    private static final String STATE_ONEPOINTARED = "StateofOnePointARed";
    private static final String STATE_THREEPOINTSABLUE = "StateofThreePointsABlue";
    private static final String STATE_TWOPOINTSABLUE = "StateofTwoPointsABlue";
    private static final String STATE_ONEPOINTABLUE = "StateofOnePointABlue";
    private static final String STATE_THREEPOINTSBWHITE = "StateofThreePointsBWhite";
    private static final String STATE_TWOPOINTSBWHITE = "StateofTwoPointsBWhite";
    private static final String STATE_ONEPOINTBWHITE = "StateofOnePointBWhite";
    private static final String STATE_THREEPOINTSBYELLOW = "StateofThreePointsBYellow";
    private static final String STATE_TWOPOINTSBYELLOW = "StateofTwoPointsBYellow";
    private static final String STATE_ONEPOINTBYELLOW = "StateofOnePointBYellow";
    private static final String STATE_GAMEOVER = "StateofGameOver";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_TOTALTEAMA, totalTeamA);
        savedInstanceState.putInt(STATE_TOTALTEAMB, totalTeamB);
        savedInstanceState.putInt(STATE_BASICTEAMA, scoreTeamA);
        savedInstanceState.putInt(STATE_BASICTEAMB, scoreTeamB);
        savedInstanceState.putInt(STATE_BONUSTEAMA, extraPointsTeamA);
        savedInstanceState.putInt(STATE_BONUSTEAMB, extraPointsTeamB);
        savedInstanceState.putInt(STATE_ROUNDNUMBER, roundNumber);
        savedInstanceState.putBoolean(STATE_THREEPOINTSARED, (threePointsARed));
        savedInstanceState.putBoolean(STATE_TWOPOINTSARED, twoPointsARed);
        savedInstanceState.putBoolean(STATE_ONEPOINTARED, onePointARed);
        savedInstanceState.putBoolean(STATE_THREEPOINTSABLUE, threePointsABlue);
        savedInstanceState.putBoolean(STATE_TWOPOINTSABLUE, twoPointsABlue);
        savedInstanceState.putBoolean(STATE_ONEPOINTABLUE, onePointABlue);
        savedInstanceState.putBoolean(STATE_THREEPOINTSBWHITE, threePointsBWhite);
        savedInstanceState.putBoolean(STATE_TWOPOINTSBWHITE, twoPointsBWhite);
        savedInstanceState.putBoolean(STATE_ONEPOINTBWHITE, onePointBWhite);
        savedInstanceState.putBoolean(STATE_THREEPOINTSBYELLOW, threePointsBYellow);
        savedInstanceState.putBoolean(STATE_TWOPOINTSBYELLOW, twoPointsBYellow);
        savedInstanceState.putBoolean(STATE_ONEPOINTBYELLOW, onePointBYellow);
        savedInstanceState.putBoolean(STATE_GAMEOVER, gameOver);


        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        totalTeamA = savedInstanceState.getInt(STATE_TOTALTEAMA);
        totalTeamB = savedInstanceState.getInt(STATE_TOTALTEAMB);
        scoreTeamA = savedInstanceState.getInt(STATE_BASICTEAMA);
        scoreTeamB = savedInstanceState.getInt(STATE_BASICTEAMB);
        extraPointsTeamA = savedInstanceState.getInt(STATE_BONUSTEAMA);
        extraPointsTeamB = savedInstanceState.getInt(STATE_BONUSTEAMB);
        roundNumber = savedInstanceState.getInt(STATE_ROUNDNUMBER);
        threePointsARed = savedInstanceState.getBoolean(STATE_THREEPOINTSARED);
        twoPointsARed = savedInstanceState.getBoolean(STATE_TWOPOINTSARED);
        onePointARed = savedInstanceState.getBoolean(STATE_ONEPOINTARED);
        threePointsABlue = savedInstanceState.getBoolean(STATE_THREEPOINTSABLUE);
        twoPointsABlue = savedInstanceState.getBoolean(STATE_TWOPOINTSABLUE);
        onePointABlue = savedInstanceState.getBoolean(STATE_ONEPOINTABLUE);
        threePointsBWhite = savedInstanceState.getBoolean(STATE_THREEPOINTSBWHITE);
        twoPointsBWhite = savedInstanceState.getBoolean(STATE_TWOPOINTSBWHITE);
        onePointBWhite = savedInstanceState.getBoolean(STATE_ONEPOINTBWHITE);
        threePointsBYellow = savedInstanceState.getBoolean(STATE_THREEPOINTSBYELLOW);
        twoPointsBYellow = savedInstanceState.getBoolean(STATE_TWOPOINTSBYELLOW);
        onePointBYellow = savedInstanceState.getBoolean(STATE_ONEPOINTBYELLOW);
        gameOver = savedInstanceState.getBoolean(STATE_GAMEOVER);

        /* Display values after restoring */
        displayTotalForTeamA(totalTeamA);
        displayTotalForTeamB(totalTeamB);
        displayBasicForTeamA(scoreTeamA);
        displayBasicForTeamB(scoreTeamB);
        displayBonusForTeamA(extraPointsTeamA);
        displayBonusForTeamB(extraPointsTeamB);
        displayRoundNumber(roundNumber);
    }

    /**
     * Displays the total score for Team A.
     */
    public void displayTotalForTeamA(int scoreTotal) {
        TextView scoreTotalView = (TextView) findViewById(R.id.team_a_score);
        scoreTotalView.setText(String.valueOf(scoreTotal));
    }

    /**
     * Displays the basic score for Team A.
     */
    public void displayBasicForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score_basic);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the bonus score for Team A.
     */
    public void displayBonusForTeamA(int scoreBonus) {
        TextView scoreBonusView = (TextView) findViewById(R.id.team_a_score_bonus);
        scoreBonusView.setText(String.valueOf(scoreBonus));
    }

    /**
     * Method checks if game is over & if points for this player are valid.
     * If ok then adds 3 points for Team A red player.
     */

    public void threePointsTeamARed(View view) {
        if (gameOver) {
            // Show an error message on a toast (game is over, player can't add more points) & exit the method
            Toast.makeText(this, R.string.toast_message_game_over, Toast.LENGTH_SHORT).show();
            return;
        }
        if (threePointsARed || threePointsABlue || threePointsBWhite || threePointsBYellow) {
            // Show an error message on a toast (3 points can occur only one time) & exit the method
            Toast.makeText(this, R.string.toast_message_3_points, Toast.LENGTH_SHORT).show();
            return;
        }
        if (twoPointsARed || onePointARed) {
            //Show an error message on a toast (Red player can only score once) & exit the method
            Toast.makeText(this, R.string.toast_message_red_team, Toast.LENGTH_SHORT).show();
            return;
        }
        threePointsARed = true;
        scoreTeamA = scoreTeamA + 3;
        displayBasicForTeamA(scoreTeamA);
    }

    /**
     * Method checks if game is over & if points for this player are valid.
     * If ok then adds 2 points for Team A red player.
     */
    public void twoPointsTeamARed(View view) {
        if (gameOver) {
            // Show an error message on a toast (game is over, player can't add more points) & exit the method
            Toast.makeText(this, R.string.toast_message_game_over, Toast.LENGTH_SHORT).show();
            return;
        }
        if (twoPointsARed || twoPointsABlue || twoPointsBWhite || twoPointsBYellow) {
            // Show an error message on a toast (2 points can occur only one time) & exit the method
            Toast.makeText(this, R.string.toast_message_2_points, Toast.LENGTH_SHORT).show();
            return;
        }
        if (threePointsARed || onePointARed) {
            //Show an error message on a toast (Red player can only score once) & exit the method
            Toast.makeText(this, R.string.toast_message_red_team, Toast.LENGTH_SHORT).show();
            return;
        }
        twoPointsARed = true;
        scoreTeamA = scoreTeamA + 2;
        displayBasicForTeamA(scoreTeamA);
    }

    /**
     * Method checks if game is over & if points for this player are valid.
     * If ok then adds 1 point for Team A red player.
     */
    public void onePointTeamARed(View view) {
        if (gameOver) {
            // Show an error message on a toast (game is over, player can't add more points) & exit the method
            Toast.makeText(this, R.string.toast_message_game_over, Toast.LENGTH_SHORT).show();
            return;
        }
        if (onePointARed || onePointABlue || onePointBWhite || onePointBYellow) {
            // Show an error message on a toast (1 point can occur only one time) & exit the method
            Toast.makeText(this, R.string.toast_message_1_point, Toast.LENGTH_SHORT).show();
            return;
        }
        if (threePointsARed || twoPointsARed) {
            //Show an error message on a toast (Red player can only score once) & exit the method
            Toast.makeText(this, R.string.toast_message_red_team, Toast.LENGTH_SHORT).show();
            return;
        }
        onePointARed = true;
        scoreTeamA = scoreTeamA + 1;
        displayBasicForTeamA(scoreTeamA);
    }

    /**
     * Method checks if game is over & if points for this player are valid.
     * If ok then adds 3 points for Team A blue player.
     */
    public void threePointsTeamABlue(View view) {
        if (gameOver) {
            // Show an error message on a toast (game is over, player can't add more points) & exit the method
            Toast.makeText(this, R.string.toast_message_game_over, Toast.LENGTH_SHORT).show();
            return;
        }
        if (threePointsARed || threePointsABlue || threePointsBWhite || threePointsBYellow) {
            // Show an error message on a toast (3 points can occur only one time) & exit the method
            Toast.makeText(this, R.string.toast_message_3_points, Toast.LENGTH_SHORT).show();
            return;
        }
        if (twoPointsABlue || onePointABlue) {
            //Show an error message on a toast (Blue player can only score once) & exit the method
            Toast.makeText(this, R.string.toast_message_blue_team, Toast.LENGTH_SHORT).show();
            return;
        }
        threePointsABlue = true;
        scoreTeamA = scoreTeamA + 3;
        displayBasicForTeamA(scoreTeamA);
    }

    /**
     * Method checks if game is over & if points for this player are valid.
     * If ok then adds 2 points for Team A blue player.
     */
    public void twoPointsTeamABlue(View view) {
        if (gameOver) {
            // Show an error message on a toast (game is over, player can't add more points) & exit the method
            Toast.makeText(this, R.string.toast_message_game_over, Toast.LENGTH_SHORT).show();
            return;
        }
        if (twoPointsARed || twoPointsABlue || twoPointsBWhite || twoPointsBYellow) {
            // Show an error message on a toast (2 points can occur only one time) & exit the method
            Toast.makeText(this, R.string.toast_message_2_points, Toast.LENGTH_SHORT).show();
            return;
        }
        if (threePointsABlue || onePointABlue) {
            //Show an error message on a toast (Blue player can only score once) & exit the method
            Toast.makeText(this, R.string.toast_message_blue_team, Toast.LENGTH_SHORT).show();
            return;
        }
        twoPointsABlue = true;
        scoreTeamA = scoreTeamA + 2;
        displayBasicForTeamA(scoreTeamA);
    }

    /**
     * Method checks if game is over & if points for this player are valid.
     * If ok then adds 1 point for Team A blue player.
     */
    public void onePointTeamABlue(View view) {
        if (gameOver) {
            // Show an error message on a toast (game is over, player can't add more points) & exit the method
            Toast.makeText(this, R.string.toast_message_game_over, Toast.LENGTH_SHORT).show();
            return;
        }
        if (onePointARed || onePointABlue || onePointBWhite || onePointBYellow) {
            // Show an error message on a toast (1 point can occur only one time) & exit the method
            Toast.makeText(this, R.string.toast_message_1_point, Toast.LENGTH_SHORT).show();
            return;
        }
        if (threePointsABlue || twoPointsABlue) {
            //Show an error message on a toast (Blue player can only score once) & exit the method
            Toast.makeText(this, R.string.toast_message_blue_team, Toast.LENGTH_SHORT).show();
            return;
        }
        onePointABlue = true;
        scoreTeamA = scoreTeamA + 1;
        displayBasicForTeamA(scoreTeamA);
    }

    /**
     * Displays the total score for Team B.
     */
    public void displayTotalForTeamB(int scoreTotal) {
        TextView scoreTotalView = (TextView) findViewById(R.id.team_b_score);
        scoreTotalView.setText(String.valueOf(scoreTotal));
    }

    /**
     * Displays the basic score for Team B.
     */
    public void displayBasicForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score_basic);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the bonus score for Team B.
     */
    public void displayBonusForTeamB(int scoreBonus) {
        TextView scoreBonusView = (TextView) findViewById(R.id.team_b_score_bonus);
        scoreBonusView.setText(String.valueOf(scoreBonus));
    }

    /**
     * Method checks if game is over & if points for this player are valid.
     * If ok then adds 3 points for Team B white player.
     */
    public void threePointsTeamBWhite(View view) {
        if (gameOver) {
            // Show an error message on a toast (game is over, player can't add more points) & exit the method
            Toast.makeText(this, R.string.toast_message_game_over, Toast.LENGTH_SHORT).show();
            return;
        }
        if (threePointsARed || threePointsABlue || threePointsBWhite || threePointsBYellow) {
            // Show an error message on a toast (3 points can occur only one time) & exit the method
            Toast.makeText(this, R.string.toast_message_3_points, Toast.LENGTH_SHORT).show();
            return;
        }
        if (twoPointsBWhite || onePointBWhite) {
            //Show an error message on a toast (White player can only score once)  & exit the method
            Toast.makeText(this, R.string.toast_message_white_team, Toast.LENGTH_SHORT).show();
            return;
        }
        threePointsBWhite = true;
        scoreTeamB = scoreTeamB + 3;
        displayBasicForTeamB(scoreTeamB);
    }

    /**
     * Method checks if game is over & if points for this player are valid.
     * If ok then adds 2 points for Team B white player.
     */
    public void twoPointsTeamBWhite(View view) {
        if (gameOver) {
            // Show an error message on a toast (game is over, player can't add more points) & exit the method
            Toast.makeText(this, R.string.toast_message_game_over, Toast.LENGTH_SHORT).show();
            return;
        }
        if (twoPointsARed || twoPointsABlue || twoPointsBWhite || twoPointsBYellow) {
            // Show an error message on a toast (2 points can occur only one time) & exit the method
            Toast.makeText(this, R.string.toast_message_2_points, Toast.LENGTH_SHORT).show();
            return;
        }
        if (threePointsBWhite || onePointBWhite) {
            //Show an error message on a toast (White player can only score once) & exit the method
            Toast.makeText(this, R.string.toast_message_white_team, Toast.LENGTH_SHORT).show();
            return;
        }
        twoPointsBWhite = true;
        scoreTeamB = scoreTeamB + 2;
        displayBasicForTeamB(scoreTeamB);
    }

    /**
     * Method checks if game is over & if points for this player are valid.
     * If ok then adds 1 point for Team B white player.
     */
    public void onePointTeamBWhite(View view) {
        if (gameOver) {
            // Show an error message on a toast (game is over, player can't add more points) & exit the method
            Toast.makeText(this, R.string.toast_message_game_over, Toast.LENGTH_SHORT).show();
            return;
        }
        if (onePointARed || onePointABlue || onePointBWhite || onePointBYellow) {
            // Show an error message on a toast (1 point can occur only one time)
            Toast.makeText(this, R.string.toast_message_1_point, Toast.LENGTH_SHORT).show();
            // Exit the method early, nothing left to do here
            return;
        }
        if (threePointsBWhite || twoPointsBWhite) {
            //Show an error message on a toast (White player can only score once)
            Toast.makeText(this, R.string.toast_message_white_team, Toast.LENGTH_SHORT).show();
            // Exit the method early, nothing left to do here
            return;
        }
        onePointBWhite = true;
        scoreTeamB = scoreTeamB + 1;
        displayBasicForTeamB(scoreTeamB);
    }

    /**
     * Method checks if game is over & if points for this player are valid.
     * If ok then adds 3 points for Team B yellow player.
     */
    public void threePointsTeamBYellow(View view) {
        if (gameOver) {
            // Show an error message on a toast (game is over, player can't add more points) & exit the method
            Toast.makeText(this, R.string.toast_message_game_over, Toast.LENGTH_SHORT).show();
            return;
        }
        if (threePointsARed || threePointsABlue || threePointsBWhite || threePointsBYellow) {
            // Show an error message on a toast (3 points can occur only one time)
            Toast.makeText(this, R.string.toast_message_3_points, Toast.LENGTH_SHORT).show();
            // Exit the method early, nothing left to do here
            return;
        }
        if (twoPointsBYellow || onePointBYellow) {
            //Show an error message on a toast (Yellow player can only score once)
            Toast.makeText(this, R.string.toast_message_yellow_team, Toast.LENGTH_SHORT).show();
            // Exit the method early, nothing left to do here
            return;
        }
        threePointsBYellow = true;
        scoreTeamB = scoreTeamB + 3;
        displayBasicForTeamB(scoreTeamB);
    }

    /**
     * Method checks if game is over & if points for this player are valid.
     * If ok then adds 2 points for Team B yellow player.
     */
    public void twoPointsTeamBYellow(View view) {
        if (gameOver) {
            // Show an error message on a toast (game is over, player can't add more points) & exit the method
            Toast.makeText(this, R.string.toast_message_game_over, Toast.LENGTH_SHORT).show();
            return;
        }
        if (twoPointsARed || twoPointsABlue || twoPointsBWhite || twoPointsBYellow) {
            // Show an error message on a toast (2 points can occur only one time)
            Toast.makeText(this, R.string.toast_message_2_points, Toast.LENGTH_SHORT).show();
            // Exit the method early, nothing left to do here
            return;
        }
        if (threePointsBYellow || onePointBYellow) {
            //Show an error message on a toast (Yellow player can only score once)
            Toast.makeText(this, R.string.toast_message_yellow_team, Toast.LENGTH_SHORT).show();
            // Exit the method early, nothing left to do here
            return;
        }
        twoPointsBYellow = true;
        scoreTeamB = scoreTeamB + 2;
        displayBasicForTeamB(scoreTeamB);
    }

    /**
     * Method checks if game is over & if points for this player are valid.
     * If ok then adds 1 point for Team B yellow player.
     */
    public void onePointTeamBYellow(View view) {
        if (gameOver) {
            // Show an error message on a toast (game is over, player can't add more points) & exit the method
            Toast.makeText(this, R.string.toast_message_game_over, Toast.LENGTH_SHORT).show();
            return;
        }
        if (onePointARed || onePointABlue || onePointBWhite || onePointBYellow) {
            // Show an error message on a toast (1 point can occur only one time)
            Toast.makeText(this, R.string.toast_message_1_point, Toast.LENGTH_SHORT).show();
            // Exit the method early, nothing left to do here
            return;
        }
        if (threePointsBYellow || twoPointsBYellow) {
            //Show an error message on a toast (Yellow player can only score once)
            Toast.makeText(this, R.string.toast_message_yellow_team, Toast.LENGTH_SHORT).show();
            // Exit the method early, nothing left to do here
            return;
        }
        onePointBYellow = true;
        scoreTeamB = scoreTeamB + 1;
        displayBasicForTeamB(scoreTeamB);
    }

    /**
     * Method checks if game is over, if not - if teams got any bonus points in given round.
     * Displays bonus points and total points.
     * Displays next round number.
     */
    public void rounds(View v) {
        if (gameOver) {
            // Show an error message on a toast & exit the method
            Toast.makeText(this, R.string.toast_message_game_over, Toast.LENGTH_SHORT).show();
            return;
        }

        if ((threePointsARed && twoPointsABlue) || (threePointsABlue && twoPointsARed)) {
            extraPointsTeamA = extraPointsTeamA + 2;
            displayBonusForTeamA(extraPointsTeamA);
        }
        if ((twoPointsARed && onePointABlue) || (twoPointsABlue && onePointARed)) {
            extraPointsTeamA = extraPointsTeamA + 1;
            displayBonusForTeamA(extraPointsTeamA);
        }
        if ((threePointsBWhite && twoPointsBYellow) || (threePointsBYellow && twoPointsBWhite)) {
            extraPointsTeamB = extraPointsTeamB + 2;
            displayBonusForTeamB(extraPointsTeamB);
        }
        if ((twoPointsBWhite && onePointBYellow) || (twoPointsBYellow && onePointBWhite)) {
            extraPointsTeamB = extraPointsTeamB + 1;
            displayBonusForTeamB(extraPointsTeamB);
        }
        totalTeamA = scoreTeamA + extraPointsTeamA;
        displayTotalForTeamA(totalTeamA);

        totalTeamB = scoreTeamB + extraPointsTeamB;
        displayTotalForTeamB(totalTeamB);

        threePointsARed = false;
        twoPointsARed = false;
        onePointARed = false;
        threePointsABlue = false;
        twoPointsABlue = false;
        onePointABlue = false;
        threePointsBWhite = false;
        twoPointsBWhite = false;
        onePointBWhite = false;
        threePointsBYellow = false;
        twoPointsBYellow = false;
        onePointBYellow = false;

        roundNumber = roundNumber + 1;
        displayRoundNumber(roundNumber);
    }

    /**
     * Method checks if game if over. If not, sets next round.
     */
    public void displayRoundNumber(int roundNumbers) {
        if (roundNumber == 16) {
            gameOver = true;
            if (totalTeamA > totalTeamB) {
                TextView whichTeamWon = (TextView) findViewById(R.id.who_won);
                whichTeamWon.setText(R.string.end_message_teamA);
                return;
            } else if (totalTeamA < totalTeamB) {
                TextView whichTeamWon = (TextView) findViewById(R.id.who_won);
                whichTeamWon.setText(R.string.end_message_teamB);
                return;
            } else {
                TextView whichTeamWon = (TextView) findViewById(R.id.who_won);
                whichTeamWon.setText(R.string.end_message_dead_heat);
                return;
            }
        }
        TextView roundNumberValue = (TextView) findViewById(R.id.round_number);
        roundNumberValue.setText(String.valueOf(roundNumbers));
    }

    /**
     * Method resets all points.
     */
    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        extraPointsTeamA = 0;
        extraPointsTeamB = 0;
        totalTeamA = 0;
        totalTeamB = 0;
        threePointsARed = false;
        twoPointsARed = false;
        onePointARed = false;
        threePointsABlue = false;
        twoPointsABlue = false;
        onePointABlue = false;
        threePointsBWhite = false;
        twoPointsBWhite = false;
        onePointBWhite = false;
        threePointsBYellow = false;
        twoPointsBYellow = false;
        onePointBYellow = false;
        roundNumber = 1;
        displayTotalForTeamA(totalTeamA);
        displayTotalForTeamB(totalTeamB);
        displayBasicForTeamB(scoreTeamB);
        displayBasicForTeamA(scoreTeamA);
        displayBonusForTeamA(extraPointsTeamA);
        displayBonusForTeamB(extraPointsTeamB);
        displayRoundNumber(roundNumber);
        TextView whichTeamWon = (TextView) findViewById(R.id.who_won);
        whichTeamWon.setText("");
        gameOver = false;
    }
}
