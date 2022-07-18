package com.brm.espressotest;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;

import com.brm.espressotest.dataadaptersample.LongListActivity;

/**
 * Created by Rakhimjonov Shokhsulton on 18,июль,2022
 * at Mayasoft LLC,
 * Tashkent, UZB.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LongListActivityTest {
    private static final String TEXT_ITEM_30 = "item: 30";
    private static final String TEXT_ITEM_30_SELECTED = "30";
    private static final String TEXT_ITEM_60 = "item: 60";
    private static final String LAST_ITEM_ID = "item: 99";

    @Rule
    public ActivityScenarioRule<LongListActivity> rule =
            new ActivityScenarioRule<>(LongListActivity.class);

    @Test
    public void lastItem_NotDisplayed(){
        onView(withText(LAST_ITEM_ID)).check(doesNotExist());
    }

}
