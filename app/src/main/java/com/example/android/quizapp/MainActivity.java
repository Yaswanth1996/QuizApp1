package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

// global variable used for different methods.
    String Answer;
    int ScoreCorrect = 0;
    int ScoreIncorrect = 0;
    boolean modiPressed;
    boolean kovindPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // method for button Submit
    public void submitAnswer(View view) {
        // methods calling
        answerForQuestion1();
        answerForQuestion2();
        answerForQuestion3();
        setScoreView();
        answerForQuestion4();
        // sets scores to zero so that if submit button is pressed multiple times it doesn't keep on increasing the scores.
        ScoreIncorrect = 0;
        ScoreCorrect = 0;
    }

    /*
    * checks wether answer for question 1 is correct or not
     */
    public void answerForQuestion1() {
        TextView Explanation = (TextView) findViewById(R.id.Question1_Explanation);
        //getText from text field
        EditText Ans = findViewById(R.id.answer_for_question1);

        //storing user input from text field
            Answer = Ans.getText().toString();
        // converting String into Integer
        // checking wether answer is correct or incorrect
        if (Answer=="8") {
            Explanation.setText("correct");
            //increasing score correct by one if answer is right
            ScoreCorrect = ScoreCorrect + 1;
        } else if(Answer=="08"){
            Explanation.setText("correct");
            //increasing score correct by one if answer is right
            ScoreCorrect = ScoreCorrect + 1;
        }else {
            Explanation.setText("You are wrong.\n Explanation : \n If you increase the price by 20% and decrease by 10% then there will be a overall increase of 8%. ");

            // increasing ScoreIncorrect by one if answer is wrong
            ScoreIncorrect = ScoreIncorrect + 1;
        }
    }
    /*
    * Checks wether answer for question 2 is correct or not.
    */
    public void answerForQuestion2() {
        // modify's text view after quiz is submitted.
        TextView Explanation = (TextView) findViewById(R.id.Question2_Explanation);
        // Radio button of correct answer.
        RadioButton RadioButtonCorrect = (RadioButton) findViewById(R.id.Radio_Button_Correct);
        // checks correct radio button is checked or not
        boolean RadioButtonCorrectBoo = RadioButtonCorrect.isChecked();
        // Radio button for incorrect answer.
        RadioButton RadioButtonInCorrect = (RadioButton) findViewById(R.id.Radio_Button_Incorrect);
        // checks wether incorrect radio button is checked or not.
        boolean RadioButtonIncorrectBoo = RadioButtonInCorrect.isChecked();
        // evaluates and changes textview based on radio button checked or not.
        if (RadioButtonCorrectBoo == true) {
            // if answer is true it changes text view to following and increases correct score.
            Explanation.setText("you are right");
            ScoreCorrect = ScoreCorrect + 1;
        } else if (RadioButtonIncorrectBoo == true) {
            // if answer is not true it changes text view to following and increases incorrect score.
            ScoreIncorrect = ScoreIncorrect + 1;
            Explanation.setText("2x4 = 8 not 4");
        } else {
            // if no option is selected it displays below text.
            Explanation.setText("You haven't selected any options");
        }

    }

    /*
     * Checks wether answer for question 3 is correct or not.
     */
    public void answerForQuestion3() {
        // gets checkbox ids
        CheckBox India = (CheckBox) findViewById(R.id.India);
        CheckBox USA = (CheckBox) findViewById(R.id.USA);
        CheckBox China = (CheckBox) findViewById(R.id.China);
        // stores the boolean values for above check boxes.
        Boolean IndiaChecked = India.isChecked();
        Boolean USAChecked = USA.isChecked();
        Boolean ChinaChecked = China.isChecked();
        // textview to display explanation for question 3.
        TextView Question3Explanation = (TextView) findViewById(R.id.Question3_Explanation);
        // checks based on the option selected by user.
        // multiple responses that a user can give.
        if(IndiaChecked==true && ChinaChecked== true && USAChecked== true){
            Question3Explanation.setText("You are Incorrect");
            ScoreIncorrect = ScoreIncorrect + 1;
        }
        else if (IndiaChecked == true && ChinaChecked == true) {
            Question3Explanation.setText("You are correct");
            ScoreCorrect = ScoreCorrect + 1;
        } else if (USAChecked == true) {
            Question3Explanation.setText("You are wrong \n United States of Americs does not belong to Asia");
            ScoreIncorrect = ScoreIncorrect + 1;
        } else if (ChinaChecked == true && IndiaChecked == false) {
            Question3Explanation.setText("you have missed another country belonging to Asia");
            ScoreIncorrect = ScoreIncorrect + 1;
        } else if (IndiaChecked == true && ChinaChecked == false) {
            Question3Explanation.setText("you have missed another country belonging to Asia");
            ScoreIncorrect = ScoreIncorrect + 1;
        } else {
            Question3Explanation.setText("you haven't selected your response");
        }
    }
/*
        *method for image buttons on Click.
 */
    public void imageButtonOnClick(View view) {
        ImageButton modi = (ImageButton) findViewById(R.id.Modi_Image);
        ImageButton kovind = (ImageButton) findViewById(R.id.Kovind_Image);

        modiPressed = modi.isPressed();
        kovindPressed = kovind.isPressed();
        // if button is pressed multiple time it stops increasing and  starts from current score values.
        ScoreCorrect = ScoreCorrect;
        ScoreIncorrect = ScoreIncorrect;
        // evaluates which image button is pressed.
        if (modiPressed == true) {
            ScoreIncorrect = ScoreIncorrect + 1;
        }
        if (kovindPressed == true) {
            ScoreCorrect = ScoreCorrect + 1;
        }

    }
/*
* method for evaluating questoin 4
 */
    public void answerForQuestion4() {
        // its sets the text for question 4 explanation based on the response from the user.
        TextView Question4Explanation = (TextView) findViewById(R.id.Question4_Explanation);
        if (modiPressed == true) {
            Question4Explanation.setText("Modi is Prime Minister of India not President of India");

        } else if (kovindPressed == true) {
            Question4Explanation.setText("you are right Ramnath Kovind is President of India");

        } else {
            Question4Explanation.setText("You haven't selected anyone");
        }
    }

/*
*method to set Score view.
 */
    public void setScoreView() {
        TextView scoreView = (TextView) findViewById(R.id.scoreView);
        scoreView.setText("your score is : " + (ScoreCorrect - ScoreIncorrect) + "\n number of correct is " + ScoreCorrect + "\n number of incorrect is " + ScoreIncorrect);
        // makes toast appear on completion of quiz.
        Toast.makeText(getApplicationContext(), "Your have completed the Quiz.", Toast.LENGTH_SHORT).show();
    }
}
