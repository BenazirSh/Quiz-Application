package com.example.android.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int correctAnswer;
    int wrongAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkCapital() {
        EditText capitalText = findViewById(R.id.capitalText);
        String capital = capitalText.getText().toString();
        if (capital.equals("Oslo")) {
            correctAnswer += 1;
        } else {
            wrongAnswer += 1;
        }

    }

    public void itemChecked() {
        CheckBox countryF = findViewById(R.id.countryFrance);
        CheckBox countryN = findViewById(R.id.countryHolland);
        CheckBox countryR = findViewById(R.id.countryRussia);
        CheckBox countryS = findViewById(R.id.countryS);
        //if the options France and Netherlands checked, Russia and Singapore are not checked
        if (countryF.isChecked() && countryN.isChecked() && !countryR.isChecked() && !countryR.isChecked()) {
            correctAnswer += 1;
        } else {
            wrongAnswer += 1;
        }
    }

    public void checkOcean() {
        EditText oceanText = findViewById(R.id.oceanText);
        String ocean = oceanText.getText().toString();
        //making capital letters, because text is set to allCaps in xml file
        if (ocean.equals("PACIFIC") || ocean.equals("PACIFIC OCEAN")) {
            correctAnswer += 1;
        } else {
            wrongAnswer += 1;
        }

    }

    public void numberOfOceans() {

        RadioButton option = findViewById(R.id.correctOption);
        if (option.isChecked()) {
            correctAnswer += 1;
        } else {
            wrongAnswer += 1;
        }
    }

    public void checkOptions() {
        CheckBox option1 = findViewById(R.id.rightOption1);
        CheckBox option2 = findViewById(R.id.rightOption2);
        CheckBox option3 = findViewById(R.id.wrongOption1);
        CheckBox option4 = findViewById(R.id.wrongOption2);
        //condition that only correct options are checked, while incorrect ones are unchecked
        if (option1.isChecked() && option2.isChecked() && !option3.isChecked() && !option4.isChecked()) {
            correctAnswer += 1;
        } else {
            wrongAnswer += 1;
        }
    }

    public void checkQuiz(View view) {
        correctAnswer = 0; //setting the value of var to 0, in case the button is pressed several times
        checkCapital();
        checkOcean();
        checkOptions();
        itemChecked();
        numberOfOceans();


        if (correctAnswer > 1) {
            String answers = String.valueOf(correctAnswer);
            Toast toast = Toast.makeText(getApplicationContext(), answers + " correct answers", Toast.LENGTH_SHORT);
            toast.show();
        } else if (correctAnswer == 0) {
            Toast toast = Toast.makeText(getApplicationContext(), " No correct answers, you lost!", Toast.LENGTH_SHORT);
            toast.show();

        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Only " + correctAnswer + " correct answer", Toast.LENGTH_SHORT);
            toast.show();

        }

    }
}
