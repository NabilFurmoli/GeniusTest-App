package com.example.android.geniustest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int num_correct_answers;
    private int num_wrong_answers = 5;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitButton(View view) {
        RadioButton q1_fri_RButton = (RadioButton) findViewById(R.id.quest_1_fri_button); // initiate a radio button
        Boolean RadioButtonStateq1 = q1_fri_RButton.isChecked(); // check current state of a radio button (true or false).

        if (RadioButtonStateq1) {
            incrementCorrAns();
            decremntwrongAns();
        }

        RadioButton q2_third_RButton = (RadioButton) findViewById(R.id.quest_2_45_Radbutton); // initiate a radio button
        Boolean RadioButtonStateq2 = q2_third_RButton.isChecked(); // check current state of a radio button (true or false).

        if (RadioButtonStateq2) {
            incrementCorrAns();
            decremntwrongAns();
        }

        CheckBox q3_first_checkbx = (CheckBox) findViewById(R.id.q3_checkbx_1); // initiate a radio button
        Boolean isFirstChbx = q3_first_checkbx.isChecked(); // check current state of a radio button (true or false).

        CheckBox q3_second_checkbx = (CheckBox) findViewById(R.id.q3_checkbx_2); // initiate a radio button
        Boolean isSecondChbx = q3_second_checkbx.isChecked(); // check current state of a radio button (true or false).

        CheckBox q3_third_checkbx = (CheckBox) findViewById(R.id.q3_checkbx_3); // initiate a radio button
        Boolean isThirdChbx = q3_third_checkbx.isChecked(); // check current state of a radio button (true or false).

        CheckBox q3_fourth_checkbx = (CheckBox) findViewById(R.id.q3_checkbx_4); // initiate a radio button
        Boolean isFourthChbx = q3_fourth_checkbx.isChecked(); // check current state of a radio button (true or false).
        q3_result(isFirstChbx, isSecondChbx, isThirdChbx, isFourthChbx);// I call the result function

        RadioButton q1_mon_RButton = (RadioButton) findViewById(R.id.quest_4_snake); // initiate a radio button
        Boolean RadioButtonStateq4 = q1_mon_RButton.isChecked(); // check current state of a radio button (true or false).

        if (RadioButtonStateq4) {
            incrementCorrAns();
            decremntwrongAns();
        }

        EditText nameField = (EditText) findViewById(R.id.inputTxt_field);
        Editable txtEditable = nameField.getText();
        String inputAns = txtEditable.toString().trim();

        if (inputAns.toString().equalsIgnoreCase("All")) {
            incrementCorrAns();
            decremntwrongAns();
        }

        String display = "Correct Answers:  " + num_correct_answers;
        display += "\n" + "Worng Answres:   " + num_wrong_answers;
        Toast.makeText(MainActivity.this,
                display, Toast.LENGTH_SHORT).show();
        TextView resultPrmpt = (TextView) findViewById(R.id.result_prompt);
        if (num_correct_answers > 3) {
            resultPrmpt.setText(getString(R.string.well_done));
        } else {
            resultPrmpt.setText(getString(R.string.poor_result));

        }

        num_correct_answers = 0;
        num_wrong_answers = 5;
    }

    public void q3_result(boolean isFirstChecked, boolean isSecondCheked, boolean isThirdChecked, boolean isFourthCheked) {
        if (isFirstChecked && !isSecondCheked && isThirdChecked && !isFourthCheked) {
            incrementCorrAns();
            decremntwrongAns();
        }
    }

    private void incrementCorrAns() {
        if (num_correct_answers < 5) {
            num_correct_answers++;
        }
    }

    private void decremntwrongAns() {
        if (num_wrong_answers > 0) {
            num_wrong_answers--;
        }
    }

}