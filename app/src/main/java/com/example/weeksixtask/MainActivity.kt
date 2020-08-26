package com.example.weeksixtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.weeksixtask.validation.Validator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var phoneNumber: EditText
    lateinit var email: EditText
    lateinit var gender: Spinner
    lateinit var registerBtn: Button
    lateinit var errorGotten: TextView
    var validator = Validator()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        error_text.visibility = View.INVISIBLE
        /**
         * get the view reference
         */

        name = findViewById(R.id.name_profile)
        phoneNumber = findViewById(R.id.phone)
        email = findViewById(R.id.email_profile)
        gender = findViewById(R.id.gender_profile)
        registerBtn = findViewById(R.id.button)
        errorGotten = findViewById<TextView>(R.id.error_text)


        /**
         * Register Button Clicks Handler
         */
        registerBtn.setOnClickListener {

            var gottenName = name.text.toString()
            var gottenEmail = email.text.toString()
            var gottenNumber = phoneNumber.text.toString()
            var gottenGender = gender.selectedItem.toString()






           var isEmail =   validator.isEmailValid(gottenEmail)
           var isGender =    validator.isGenderValid(gottenGender)
            var isName = validator.isNameValid(gottenName)
           var isPhone =   validator.isPhoneNumberValid(gottenNumber)



            if (validator.isAllValid()){
                openProfileActivity()
            } else{
                errorGotten.visibility = View.VISIBLE
                setErrorText(isEmail, isGender, isName, isPhone)

            }


        }

    }

    /**
     * Sets the error text to be shown
     */
    private fun setErrorText(email: Boolean, gender: Boolean, name: Boolean, phone: Boolean) {
         if (!email){
             errorGotten.text = "Check Your Email Address Input"
         } else if(!gender){
             errorGotten.text = "Check Your Gender Input"
         } else if (!name){
             errorGotten.text = "Check Your Name Input"
         } else if (!phone){
             errorGotten.text = "Check Your Phone Number Input"
         }

    }

    private fun openProfileActivity(){

        var intent = Intent(this, ProfileActivity::class.java)


          /**
           * get the values from the edit texts
           */

          var gottenName = name.text.toString()
          var gottenEmail = email.text.toString()
          var gottenNumber = phoneNumber.text.toString()
          var gottenGender = gender.selectedItem.toString()



          /**
           * Put gotten Strings in the extra
           */

          intent.putExtra("NAME", gottenName)
          intent.putExtra("EMAIL", gottenEmail)
          intent.putExtra("PHONE_NUMBER", gottenNumber)
          intent.putExtra("GENDER", gottenGender)

        startActivity(intent)
        
    }


}