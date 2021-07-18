package com.openclassrooms.entrevoisins.espresso;


import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.app.PendingIntent.getActivity;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.ui.neighbour_list.NeighbourProfileDetailsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static java.util.EnumSet.allOf;
import static java.util.regex.Pattern.matches;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class ProfileActivityTest {

    @Rule
    public ActivityTestRule<NeighbourProfileDetailsActivity> mActivityRule =
            new ActivityTestRule<>(NeighbourProfileDetailsActivity.class, false, false);



    @Test
    public void TestNeighbourProfileActivityStarted(){


        //checking if activity starts
        Intent intent = new Intent(Intent.ACTION_PICK);
        mActivityRule.launchActivity(intent);
        //onData(anything()).atPosition(0).perform(click());
        //onData(allOf(is(instanceOf(NeighbourProfileDetailsActivity.class)), is("Americano"))).perform(click());




        //onData(anything()).inAdapterView(withId(R.id.list_neighbours)).atPosition(0).perform(click());

    }

}
