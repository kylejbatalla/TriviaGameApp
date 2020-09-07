/*
 * File Name: EndGame.java
 * Author: Kyle Batalla
 * Date: 8/30/2020
 * Description: This file serves as ending activity for the app once the user answers all 10
 *              questions. The user has the option to then exit, play again, or view results.
 */
package edu.ucsd.triviagame;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/*
 * Class Name: EndGame
 * Extends: AppCompatActivity
 * Description: This class contains all necessary methods and instances for the EndGame activity
 *
 */
public class EndGame extends AppCompatActivity {
    //TextView instance declarations
    TextView textScore;
    //Button instance declarations
    Button buttonPlayAgain, buttonShowScore, buttonExit;
    //Difficulty instance declarations
    MainActivity obj = new MainActivity();
    MediumDifficulty obj3 = new MediumDifficulty();
    HardDifficulty obj4 = new HardDifficulty();
    StartPage obj2 = new StartPage();

    public static final String PLAY_AGAIN = "Play Again";
    public static final String SHOW_SCORE = "View Results";
    public static final String EXIT_APP = "Exit App";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        //TextView initializations
        textScore = (TextView) findViewById(R.id.textScore);
        //Button initializations
        buttonPlayAgain = (Button) findViewById(R.id.buttonPlayAgain);
        buttonShowScore = (Button) findViewById(R.id.buttonShowScore);
        buttonExit = (Button) findViewById(R.id.buttonExit);
        //Button text setters
        buttonShowScore.setText(SHOW_SCORE);
        buttonPlayAgain.setText(PLAY_AGAIN);
        buttonExit.setText(EXIT_APP);
        //TextView text setters
        textScore.setText(showScore());
        //Button to play again and return user to beginning activity
        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), StartPage.class); //New intent instance
                startActivity(intent); //Calls intent, returns to start page to play game again
            }
        });
        //Button to display score, redirects user to new activity to display score
        buttonShowScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ShowResultsActivity.class); // New intent instance
                startActivity(intent); //Calls intent, returns to start page
            }
        });
        //Button to exit app, kills current activity
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity(); //Kills current activity and ends game
            }
        });
    }
    /*
     * Function Name: showScore
     * Description: Returns a string of correct questions answered out of 10
     * Parameters: None
     * Return Type: String that displays score
     */
    public String showScore() {
        String str;
        int score = 0;
        if(obj2.getLevel() == 1){ //Retrieves score for easy difficulty
            score = obj.getEasyScore();
        }
        else if(obj2.getLevel() == 2){
            score = obj3.getMediumScore(); //Retrieves score for medium difficulty
        }
        else if(obj2.getLevel() == 3){ //Retrieves score for hard difficulty
            score = obj4.getHardScore();
        }
        if (score == 10) {
            str = "Perfect score! You scored 10/10.";
        } else if (score <= 9 && score >= 8) {
            str = "You scored " + score + "/10, great job!";
        } else if (score <= 7 && score >= 6) {
            str = "You scored " + score + "/10, not bad!";
        } else {
            str = "You scored " + score + "/10, you can do better!";
        }
        return str;
    }
}