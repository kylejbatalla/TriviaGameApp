/*
 * File Name: HardDifficulty.java
 * Author: Kyle Batalla
 * Date: 8/30/2020
 * Description: This file serves as hard difficulty activity for the trivia game app
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
 * Class Name: MediumDifficulty
 * Extends: AppCompatActivity
 * Description: This class contains all necessary methods and instances for HardDifficulty
 */
public class HardDifficulty extends AppCompatActivity {

    //Button instance declarations
    Button button1, button2, button3, button4, stopButton;

    //TextView instance declarations
    TextView questionText, questionCounter;

    //ArrayList declarations
    public static ArrayList<String> answerList;
    public static ArrayList<String> answerSelectedList;
    public static ArrayList<String> questionsList;
    private static final String EXIT = "Exit";

    public Questions questions;
    public static int score; //Keeps track of score
    public int counter; //Keeps track of index
    /*
     * Function Name: onCreate
     * Description: Function that runs when activity is initialized
     * Parameters: Bundle savedInstanceState, where activity data is stored
     * Return Type: void
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Questions instance initialization
        questions = new Questions();

        //ArrayList initializations
        answerList = new ArrayList<>();
        questionsList = new ArrayList<>();
        answerSelectedList = new ArrayList<>();

        //Question instance declarations
        questions.populateArray();
        questions.populateHardQuestions();
        questions.populateHardChoices();
        questions.populateHardAnswers();

        counter = 0; //Initializes score to 0
        score = 0; //Initializes question counter to 0

        //Button initializations
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        stopButton = (Button) findViewById(R.id.stopButton);

        //TextView initializations
        questionText = (TextView) findViewById(R.id.questionText);
        questionCounter = (TextView) findViewById(R.id.questionCounter);

        //Button text setters
        stopButton.setText(EXIT);

        //Calls 1st question with corresponding answer choices
        updateQuestion(counter);

        //Exit button listener to return to start page
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), StartPage.class); //New intent instance
                startActivity(intent); //Calls intent, returns to start page
            }
        });
        //Answer 1 button listener
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button1.getText().equals(questions.getHardAnswers(counter)) == true) {
                    incrementScore(); //Increments score if answer is correct
                }
                answerList.add(questions.getHardAnswers(counter)); //Increments score if answer is correct
                answerSelectedList.add((String) button1.getText()); //Adds selected answer to arrayList
                counter++; //Increments counter index
                updateQuestion(counter); //Updates next question and answers
            }
        });
        //Answer 2 button listener
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button2.getText().equals(questions.getHardAnswers(counter)) == true) {
                    incrementScore(); //Increments score if answer is correct
                }
                answerList.add(questions.getHardAnswers(counter)); //Adds correct answer to arrayList
                answerSelectedList.add((String) button2.getText()); //Adds selected answer to arrayList
                counter++;  //Increments counter index
                updateQuestion(counter); //Updates next question and answers
            }
        });
        //Answer 3 button listener
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button3.getText().equals(questions.getHardAnswers(counter)) == true) {
                    incrementScore(); //Increments score if answer is correct
                }
                answerList.add(questions.getHardAnswers(counter)); //Adds correct answer to arrayList
                answerSelectedList.add((String) button3.getText()); //Adds selected answer to arrayList
                counter++; //Increments counter index
                updateQuestion(counter); //Updates next question and answers
            }
        });
        //Answer 4 button listener
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button4.getText().equals(questions.getHardAnswers(counter)) == true) {
                    incrementScore(); //Increments score if answer is correct
                }
                answerList.add(questions.getHardAnswers(counter)); //Adds correct answer to arrayList
                answerSelectedList.add((String) button4.getText()); //Adds selected answer to arrayList
                counter++; //Increments counter index
                updateQuestion(counter); //Updates next question and answers
            }
        });
    }
    /*
     * Function Name: updateQuestion
     * Description: Updates next question with corresponding answer choices
     * Parameters: int num, the number of questions index
     * Return Type: void
     */
    public void updateQuestion(int num) {
        if (num == 10) {
            openEndGame(); //Goes to end game activity if counter is 10
        } else {
            questionText.setText(questions.getHardQuestions(num)); //Sets question number
            questionCounter.setText(questionCounter()); //Sets question number
            questionsList.add(questions.getHardQuestions(num)); //Adds question to arrayList

            button1.setText(questions.getHardChoices1(num)); //Sets answer choice 1
            button2.setText(questions.getHardChoices2(num)); //Sets answer choice 2
            button3.setText(questions.getHardChoices3(num)); //Sets answer choice 3
            button4.setText(questions.getHardChoices4(num)); //Sets answer choice 4
        }

    }
    /*
     * Function Name: getHardScore
     * Description: Returns number of questions answered correctly
     * Parameters: None
     * Return Type: int score, the score returned
     */
    public int getHardScore() {
        return score;
    }
    /*
     * Function Name: incrementScore
     * Description: Increments score variable if question is answered correctly
     * Parameters: None
     * Return Type: void
     */
    public void incrementScore() {
        score++;
    }
    /*
     * Function Name: getListResults
     * Description: Returns array list of total selected answers
     * Parameters: None
     * Return Type: ArrayList<String>, array list of answers selected for each question
     */
    public ArrayList<String> getListResults() { return answerSelectedList; }
    /*
     * Function Name: getListQuestions
     * Description: Returns array list of questions that were asked
     * Parameters: int num, question index counter
     * Return Type: String, the question asked
     */
    public String getListQuestions(int num) {return questionsList.get(num);}
    /*
     * Function Name: getAnswers
     * Description: Returns correct answer for corresponding question
     * Parameters: int num, question index counter
     * Return Type: String, the correct answer for corresponding question
     */
    public String getAnswers(int num) {return answerList.get(num);}
    /*
     * Function Name: questionCounter
     * Description: Returns string of what current question the user is on
     * Parameters: None
     * Return Type: String, displays current question number
     */
    public String questionCounter() {
        String str = "Hard Question " + (counter + 1) + "/10";
        return str;
    }
    /*
     * Function Name: openEndGame
     * Description: Kills activity and ends game
     * Parameters: None
     * Return Type: None
     */
    public void openEndGame() {
        Intent intent = new Intent(this, EndGame.class); //New intent instance
        startActivity(intent); //Calls intent, returns to start page
    }

}




