package com.brm.espressotest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.brm.espressotest.basicexample.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by Rakhimjonov Shokhsulton on 16,июль,2022
 * at Mayasoft LLC,
 * Tashkent, UZB.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class BasicEspressoTest {
    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun changeText_sameActivity(){
        onView(withId(R.id.editTextUserInput)).perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt)).perform(click())
        onView(withId(R.id.textToBeChanged)).check(matches(withText(STRING_TO_BE_TYPED)))
    }

    @Test
    fun changeText_newActivity(){
        onView(withId(R.id.editTextUserInput)).perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard())
        onView(withId(R.id.activityChangeTextBtn)).perform(click())
        onView(withId(R.id.second_text_view)).check(matches(withText(STRING_TO_BE_TYPED)))
    }

    companion object{
        private const val STRING_TO_BE_TYPED = "Espresso"
    }
}