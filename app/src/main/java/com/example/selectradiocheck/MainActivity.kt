package com.example.selectradiocheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editName = findViewById<EditText>(R.id.editName)
        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val checkCoding = findViewById<CheckBox>(R.id.checkCoding)
        val checkReading = findViewById<CheckBox>(R.id.checkReading)
        val checkWorkout = findViewById<CheckBox>(R.id.checkWorkout)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            val name = editName.text.toString()
            val gender = when (radioGroupGender.checkedRadioButtonId) {
                R.id.radioMale -> "Male"
                R.id.radioFemale -> "Female"
                else -> "Undefined"
            }

            val hobbies = mutableListOf<String>()
            if (checkCoding.isChecked) hobbies.add("Coding")
            if (checkReading.isChecked) hobbies.add("Reading")
            if (checkWorkout.isChecked) hobbies.add("Workout")

            val hobbyText = if (hobbies.isNotEmpty()) {
                "Hobbies: " + hobbies.joinToString(", ")
            } else {
                "No hobbies selected"
            }

            val message = "Name: $name\nGender: $gender\n$hobbyText"

            // Display the message not as a Toast but as a Snackbar instead
            // Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show()
        }
    }
}