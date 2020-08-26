package com.example.weeksixtask

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.provider.ContactsContract.Directory.PACKAGE_NAME
import android.view.View
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.intent.KIntent
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import org.hamcrest.CoreMatchers.`is`
import org.junit.Rule
import org.junit.Test
import java.util.regex.Matcher
import java.util.regex.Pattern.matches


class SearchScreen : Screen<SearchScreen>() {
    val registerButton = KButton { withId(R.id.button) }
    val editName = KEditText{withId(R.id.name_profile)}
    val editEmail = KEditText{withId(R.id.email_profile)}
    val editPhone = KEditText{withId(R.id.phone)}
    val spinnerEdit = KTextView{
        withParent { withId(R.id.gender_profile) }}
    val errorCheck = KTextView{ withId(R.id.error_text)    }
    val profile_name = KTextView{ withId(R.id.name_profile) }
    val profile_email = KTextView{ withId(R.id.email_profile) }
    val profile_gender = KTextView{withId(R.id.gender_profile)}
    val profile_phone = KTextView{withId(R.id.phone_number_profile)}

    }

@LargeTest
class MainActivityTest{
    private val correctName = "samuel"
    private val correctEmail = "esam@gmail.com"
    private val correctPhone = "08025292940"

    private val inCorrectName = "232"
    private val inCorrectEmail = "esam"
    private val inCorrectPhone = "08025292"




    @Rule
    @JvmField
    var intentRule = IntentsTestRule(MainActivity::class.java)

    private val screen = SearchScreen()


    /**
     * Checks Whether button is clickable
     */
    @Test
    fun is_button_clickable(){
        screen{
            registerButton{isClickable()}
        }
    }

    /**
     * Checks whether editTexts are visible
     */

    @Test
    fun is_edit_texts_visible(){
        screen{
            editName{isVisible()}
            editEmail{isVisible()}
            editPhone{isVisible()}
            spinnerEdit{isVisible()}
        }
    }

    /**
     * check whether after correct Input my button click goes to the next activity
     */

    @Test
    fun does_correct_input_signify_next_activity(){
        screen{
            editName.typeText(correctName)
            closeSoftKeyboard()
            editPhone.typeText(correctPhone)
            closeSoftKeyboard()
            editEmail.typeText(correctEmail)
            closeSoftKeyboard()
            spinnerEdit.perform { click()  }
            onData(`is`("Male")).perform(click())
            registerButton.click()

            intended(hasComponent(ProfileActivity::class.java!!.name))

        }
    }

    /**
     * Checks Whether incorrect email signifies error
     */

    @Test
    fun does_incorrect_email_signify_error_text(){
        screen{
            editName.typeText(correctName)
            closeSoftKeyboard()
            editPhone.typeText(correctPhone)
            closeSoftKeyboard()
            editEmail.typeText(inCorrectEmail)
            closeSoftKeyboard()
            spinnerEdit.perform { click()  }
            onData(`is`("Male")).perform(click())
            registerButton.click()

            errorCheck?.isDisplayed()



        }

    }

    /**
     * Checks Whether incorrect phone signifies error
     */

    @Test
    fun does_incorrect_number_signify_error_text(){
        screen{
            editName.typeText(correctName)
            closeSoftKeyboard()
            editPhone.typeText(inCorrectPhone)
            closeSoftKeyboard()
            editEmail.typeText(correctEmail)
            closeSoftKeyboard()
            spinnerEdit.perform { click()  }
            onData(`is`("Male")).perform(click())
            registerButton.click()

            errorCheck?.isDisplayed()



        }

    }

    /**
     * Checks Whether incorrect name signifies error
     */

    @Test
    fun does_incorrect_name_signify_error_text(){
        screen{
            editName.typeText(inCorrectName)
            closeSoftKeyboard()
            editPhone.typeText(inCorrectPhone)
            closeSoftKeyboard()
            editEmail.typeText(correctEmail)
            closeSoftKeyboard()
            spinnerEdit.perform { click()  }
            onData(`is`("Male")).perform(click())
            registerButton.click()

            errorCheck?.isDisplayed()



        }

    }

    /**
     * Checks Whether incorrect gender signifies error
     */

    @Test
    fun does_incorrect_gender_signify_error_text(){
        screen{
            editName.typeText(correctName)
            closeSoftKeyboard()
            editPhone.typeText(inCorrectPhone)
            closeSoftKeyboard()
            editEmail.typeText(correctEmail)
            closeSoftKeyboard()
            registerButton.click()

            errorCheck?.isDisplayed()
        }
    }

    /**
     * Checks whether the string put in intent is passed to the next activity
     */

    @Test
    fun is_intent_extra_passed(){
        val resultData = Intent()
        screen{
            editName.typeText(correctName)
            closeSoftKeyboard()
            editPhone.typeText(correctPhone)
            closeSoftKeyboard()
            editEmail.typeText(correctEmail)
            closeSoftKeyboard()
            spinnerEdit.perform { click()  }
            onData(`is`("Male")).perform(click())
            registerButton.click()

            val searchResultsIntent = KIntent {
                hasComponent(ProfileActivity::class.java.name)
                hasExtra("Name", correctName)
                hasExtra("Email", correctEmail)
                hasExtra("PhoneNumber", correctPhone)
                hasExtra("Gender", "Male")
            }

            searchResultsIntent.intended()

        }

    }


    /**
     * check whether test results are displayed
     */

    @Test
    fun are_intents_data_showing(){
        screen{
            editName.typeText(correctName)
            closeSoftKeyboard()
            editPhone.typeText(correctPhone)
            closeSoftKeyboard()
            editEmail.typeText(correctEmail)
            closeSoftKeyboard()
            spinnerEdit.perform { click()  }
            onData(`is`("Male")).perform(click())
            registerButton.click()

            profile_name.containsText(correctName)
            profile_email.containsText(correctEmail)
            profile_gender.containsText("Male")
            profile_phone.containsText(correctPhone)


        }
    }

}