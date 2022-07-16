package com.brm.espressotest;

import android.view.View;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.widget.EditText;
import androidx.test.espresso.matcher.BoundedMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * Created by Rakhimjonov Shokhsulton on 16,июль,2022
 * at Mayasoft LLC,
 * Tashkent, UZB.
 */
public class HintMatcher {

    static Matcher<View> withHint(final String substring){
        return withHint(is(substring));
    }

    static Matcher<View> withHint(final Matcher<String> stringMatcher){
        checkNotNull(stringMatcher);
        return new BoundedMatcher<View, EditText>(EditText.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("with hint: ");
                stringMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(EditText item) {
                final CharSequence hint = item.getHint();
                return hint != null && stringMatcher.matches(hint.toString());
            }
        };
    }
}
