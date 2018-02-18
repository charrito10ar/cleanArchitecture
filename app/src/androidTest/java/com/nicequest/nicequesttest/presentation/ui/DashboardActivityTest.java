package com.nicequest.nicequesttest.presentation.ui;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.nicequest.nicequesttest.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DashboardActivityTest {

    @Rule
    public ActivityTestRule<DashboardActivity> mActivityTestRule = new ActivityTestRule<>(DashboardActivity.class);

    @Test
    public void showRecyclerViewTest() {
        ViewInteraction viewGroup = onView(withId(R.id.recycler_view_items));
        viewGroup.check(matches(isDisplayed()));
    }

    @Test
    public void showToolbarTest() {
        ViewInteraction viewGroup = onView(withId(R.id.toolbar));
        viewGroup.check(matches(isDisplayed()));
    }

    @Test
    public void recyclerViewShowItemPositionTest(){
        onView(withRecyclerView(R.id.recycler_view_items).atPosition(3))
                .check(matches(hasDescendant(isDisplayed())));
    }

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }



}
