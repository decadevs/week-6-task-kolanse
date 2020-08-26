package com.example.weeksixtask

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.filters.LargeTest
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import org.junit.Rule
import org.junit.Test

class SearchScreenTwo : Screen<SearchScreenTwo>() {

    val profile_name = KTextView{withId(R.id.name_profile)  }
    val profile_email = KTextView{ withId(R.id.email_profile) }
    val profile_gender = KTextView{withId(R.id.gender_profile)}
    val profile_phone = KTextView{withId(R.id.phone_number_profile)}
    val profile_image = KImageView{withId(R.id.profile_image)}
    val image_email = KImageView{withId(R.id.email_image)}
    val image_person = KImageView{withId(R.id.person_image)}
    val image_phone_now = KImageView{withId(R.id.image_phone_new)}

}

@LargeTest
class ProfileActivityTest{


    @Rule
    @JvmField
    var intentRule = IntentsTestRule(ProfileActivity::class.java)

    private val screen = SearchScreenTwo()

    /**
     * check whether all views are visible or displayed
     */

    @Test
    fun are_all_views_visible(){
        screen{
            profile_name{isVisible()}
            profile_email{isVisible()}
            profile_gender{isVisible()}
            profile_phone{isVisible()}
            profile_image{isVisible()}
            image_email{isVisible()}
            image_person{isVisible()}
            image_phone_now{isVisible()}
        }
    }



}