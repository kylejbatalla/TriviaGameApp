/*
 * File Name: ShowResultsActivty.java
 * Author: Kyle Batalla
 * Date: 8/30/2020
 * Description: This file serves as the ShowResults activity for the app
 */
package edu.ucsd.triviagame;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
/*
 * Class Name: ShowResultsActivity
 * Extends: AppCompatActivity
 * Description: This class contains all necessary methods and instances for ShowResultsActivity
 *              The class will display all answers selected as well as correct answers if answered
 *              wrong by the user.
 */
public class ShowResultsActivity extends AppCompatActivity {
    //TextView instance declarations
    TextView answerList, textShowScore;
    //Button instance declarations
    Button buttonExit, buttonPlayAgain;
    //ArrayList declarations
    ArrayList<String> answerSelectedList;
    //Difficulty instance declarations
    MainActivity obj;
    MediumDifficulty obj2;
    HardDifficulty obj3;
    EndGame obj4;
    StartPage start;
    Questions questions;

    public int level;
    public static final String EXIT_APP = "Exit App";
    public static final String PLAY_AGAIN = "Play Again";
    public static int counter; //Keeps track of questions displayed
    /*
     * Function Name: onCreate
     * Description: Function that runs when activity is initialized
     * Parameters: Bundle savedInstanceState, where activity data is stored
     * Return Type: void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results);

        counter = 1;//Sets question counter to 1
        //ArrayList initialization, contains user selected answers
        answerSelectedList = new ArrayList<>();
        //Difficulty instance intializations
        start = new StartPage();
        obj = new MainActivity();
        obj2 = new MediumDifficulty();
        obj3 = new HardDifficulty();
        obj4 = new EndGame();
        questions = new Questions();
        //Initializes level. Retrieves level difficulty the user chose
        level = getLevel();
        //Button initializations
        buttonExit = (Button) findViewById(R.id.buttonExit);
        buttonPlayAgain = (Button) findViewById(R.id.buttonPlayAgain);
        //TextView initializations
        answerList = (TextView) findViewById(R.id.answerList);
        textShowScore = (TextView) findViewById(R.id.textShowScore);
        //Button text setters
        buttonPlayAgain.setText(PLAY_AGAIN);
        buttonExit.setText(EXIT_APP);
        //TextView text setters
        answerList.setText(printResults());
        textShowScore.setText(obj4.showScore());
        //Exit button listener, kills activity and ends game
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity(); //Kills activity and ends app
            }
        });
        //Button listener to play again, returns to start page
        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), StartPage.class); //New intent instance
                startActivity(intent); //Calls intent, returns to start page
            }
        });

    }
    /*
     * Function Name: getLevel
     * Description: Retrieves level difficulty user chose. 1 = easy, 2 = medium, 3 = hard
     * Parameters: none
     * Return Type: int, numeric level difficulty
     */
    public int getLevel(){
        level = start.getLevel(); //retrieves level, which is initialized in StartPage.java
        if(level < 1 || level > 3){ //Makes sure level is in range of 1 <= x <= 3
            System.err.println("Level Not Found");
            finishAffinity(); //Kills activity
        }
            return level;
    }
    /*
     * Function Name: printResults
     * Description: Displays all questions asked as well as answers chose. Displays correct answers
     *              for all questions answered wrong
     * Parameters: none
     * Return Type: String of all questions and answers
     */
    public String printResults(){
        String str = "";
        if(level == 1){ //If the user chose easy
            answerSelectedList = obj.getListResults(); //Retrieves answers selected
            for(int i = 0; i < 10; i++){
                str = str + counter + ": " + obj.getListQuestions(i) + "\n" + //Displays question
                        "You answered: " + answerSelectedList.get(i) + "\n" + //Displays answer chosen
                        "Correct Answer: " + obj.getAnswers(i) + "\n\n"; //Displays correct answer
                counter++;
            }
        }
        else if(level == 2){ //If the user chose medium
            answerSelectedList = obj2.getListResults(); //Retrieves answers selected
            for(int i = 0; i < 10; i++){
                str = str + counter + ": " + obj2.getListQuestions(i) + "\n" + //Displays question
                        "You answered: " + answerSelectedList.get(i) + "\n" + //Displays answer chosen
                        "Correct Answer: " + obj2.getAnswers(i) + "\n\n"; //Displays correct answer
                counter++;
            }
        }
        else{ //If the user chose hard
            answerSelectedList = obj3.getListResults(); //Retrieves answers selected
            for(int i = 0; i < 10; i++){
                str = str + counter + ": " + obj3.getListQuestions(i) + "\n" + //Displays question
                        "You answered: " + answerSelectedList.get(i) + "\n" + //Displays answer chosen
                        "Correct Answer: " + obj3.getAnswers(i) + "\n\n"; //Displays correct answer
                counter++;
            }
        }
        return str;
    }
}