package com.example.weeksixtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    lateinit var name: TextView
    lateinit var phoneNumber: TextView
    lateinit var email: TextView
    lateinit var gender: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        name = findViewById(R.id.name_profile)
        phoneNumber = findViewById(R.id.phone_number_profile)
        email = findViewById(R.id.email_profile)
        gender = findViewById(R.id.gender_profile)

        populateTextViews()
    }

    private fun populateTextViews() {
        /**
         * get Strings that was Passed through intent
         */
     var nameReceived = intent.getStringExtra("NAME").toString()
     var phoneReceived = intent.getStringExtra("PHONE_NUMBER").toString()
     var emailReceived  = intent.getStringExtra("EMAIL").toString()
     var genderReceived = intent.getStringExtra("GENDER").toString()

        /**
         * set the text of corresponding views
         */

        name.text = nameReceived
        phoneNumber.text = phoneReceived
        email.text = emailReceived
        gender.text = genderReceived

    }
}