package com.brm.espressotest;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.not;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.brm.espressotest.custommatcher.SecondMainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.annotation.LooperMode;
import org.robolectric.annotation.TextLayoutMode;

/**
 * Created by Rakhimjonov Shokhsulton on 16,июль,2022
 * at Mayasoft LLC,
 * Tashkent, UZB.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
@TextLayoutMode(TextLayoutMode.Mode.REALISTIC)
@LooperMode(LooperMode.Mode.PAUSED)
@Config(manifest = Config.NONE)
public class HintMatchersTest {
    private static final String INVALID_STRING_TO_BE_TYPED = "Earl grey";
    private static final String COFFEE_ENDING = "coffee?";
    private static final String COFFEE_INVALID_ENDING = "tea?";

    private String mStringWithValidEnding;
    private String mValidStringToBeTyped;

    @Rule public ActivityScenarioRule<SecondMainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(SecondMainActivity.class);
    @Before
    public void initValidString(){
        mStringWithValidEnding = "Random " + SecondMainActivity.VALID_ENDING;
        mValidStringToBeTyped = SecondMainActivity.Companion.getCOFFEE_PREPARATIONS().get(0);
    }

    @Test
    public void hint_isDisplayedInEditText(){
        String hintText = getApplicationContext().getResources().getString(R.string.hint);
        onView(withId(R.id.editText)).check(matches(HintMatcher.withHint(hintText)));
    }

    @Test
    public void hint_endWith(){
        onView(withId(R.id.editText)).check(
                matches(HintMatcher.withHint(anyOf(endsWith(COFFEE_ENDING), endsWith(COFFEE_INVALID_ENDING)))));
    }

    @Test
    public void editText_canBeTypedInto(){
        onView(withId(R.id.editText))
                .perform(typeText(mValidStringToBeTyped), closeSoftKeyboard())
                .check(matches(withText(mValidStringToBeTyped)));
    }

}
