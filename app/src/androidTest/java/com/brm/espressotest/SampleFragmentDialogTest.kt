package com.brm.espressotest

import androidx.fragment.app.testing.launchFragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.brm.espressotest.samplefragment.SampleDialogFragment
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Rakhimjonov Shokhsulton on 18,июль,2022
 * at Mayasoft LLC,
 * Tashkent, UZB.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class SampleFragmentDialogTest {
    @Test
    fun launchDialogFragmentAndVerifyUi(){
        val scenario = launchFragment<SampleDialogFragment>()

        scenario.onFragment{fragment ->
            assertThat(fragment.dialog).isNotNull()
            assertThat(fragment.requireDialog().isShowing).isTrue()
        }

        Espresso.onView(ViewMatchers.withId(R.id.textView)).inRoot(RootMatchers.isDialog())
            .check(ViewAssertions.matches(ViewMatchers.withText(I_AM_FRAGMENT)))

    }

    @Test
    fun launchDialogFragmentEmbeddedToHostActivityAndVerifyUI(){
        val scenario = launchFragmentInContainer<SampleDialogFragment>()

        scenario.onFragment { fragment ->
            assertThat(fragment.dialog).isNull()
        }

        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText(
            I_AM_FRAGMENT)))
    }

    companion object{
        private const val I_AM_FRAGMENT = "I am fragment"
    }
}