/*
 * File Name: StartPage.java
 * Author: Kyle Batalla
 * Date: 8/30/2020
 * Description: This file serves as starting activity for the app
 */
package edu.ucsd.triviagame;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/*
 * Class Name: StartPage
 * Extends: AppCompatActivity
 * Description: This class contains all necessary methods and instances for StartPage
 */
public class StartPage extends AppCompatActivity {

    //String instances
    public static final String WELCOME = "Welcome to Kyle's Ultimate Trivia Game";
    public static final String PROMPT = "Choose your difficulty";

    public static int level; //Keeps track of what difficulty user selects
                             //1 = easy, 2 = medium, 3 = hard

    TextView textTitle, textPrompt; //Text instance declarations
    Button buttonEasy, buttonMedium, buttonHard, buttonExit; //Button instance declarations
    /*
     * Function Name: onCreate
     * Description: Function that runs when activity is initialized
     * Parameters: Bundle savedInstanceState, where activity data is stored
     * Return Type: void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        //Text instance definitions
        textTitle = (TextView) findViewById(R.id.textTitle);
        textPrompt = (TextView) findViewById(R.id.textPrompt);
        //Button instance definitions
        buttonEasy = (Button) findViewById(R.id.buttonEasy);
        buttonMedium = (Button) findViewById(R.id.buttonMedium);
        buttonHard = (Button) findViewById(R.id.buttonHard);
        buttonExit = (Button) findViewById(R.id.buttonExit);

        //Text Setters
        textTitle.setText(WELCOME);
        textPrompt.setText(PROMPT);
        buttonEasy.setText("Easy");
        buttonMedium.setText("Medium");
        buttonHard.setText("Hard");
        buttonExit.setText("Exit");

        //Exits button to exit app
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

        //Starts easy difficulty activity (MainActivity.java)
        buttonEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level = 1; //Initializes level to 1 equaling easy
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent); //Starts new activity
            }
        });

        //Starts medium diffuculty activity (MediumDifficulty.java)
        buttonMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level = 2; //Initializes level to 2 equaling medium
                Intent intent = new Intent(view.getContext(), MediumDifficulty.class);
                startActivity(intent); //Starts new activity
            }
        });
        buttonHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level = 3; //Initializes level to 3 equaling hard
                Intent intent = new Intent(view.getContext(), HardDifficulty.class);
                startActivity(intent); //Starts new activity
            }
        });

    }
    /*
     * Function Name: getLevel
     * Description: Returns which level the user chooses.
     * 1 = easy, 2 = medium, 3 = hard
     * Parameters: None
     * Return Value: int level, the level the user chooses
     */
    public int getLevel(){
        return level;
    }
}