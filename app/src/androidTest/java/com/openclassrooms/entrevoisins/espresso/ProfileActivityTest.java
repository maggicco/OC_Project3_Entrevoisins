package com.openclassrooms.entrevoisins.espresso;


import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
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

import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
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
    public ActivityTestRule<ListNeighbourActivity> activityTestRule =
            new ActivityTestRule<>(ListNeighbourActivity.class,true,false);

    @Test
    public void onClickRecyclerView(){
        Espresso.onView(withId(R.id.main_content)).
                perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));
    }

    @Test
    public void customizeIntent(){

        Intent intent = new Intent(Intent.ACTION_PICK);
        activityTestRule.launchActivity(intent);
    }

//    // This is fixed
//    private static int ITEMS_COUNT = 12;
//
//    private ListNeighbourActivity mActivity;
//
//    @Rule
//    public ActivityTestRule<ListNeighbourActivity> mainActivityActivityTestRule =
//            new ActivityTestRule<ListNeighbourActivity>(ListNeighbourActivity.class);
//
//    @Test
//    public void TestDetail() {
//        onView(withId(R.id.list_neighbours)).perform(NavigationViewActions.navigateTo(R.id.profile_details_activity));
//    }

//    @Rule
//    public IntentsTestRule<ListNeighbourActivity> intentsTestRule =
//            new IntentsTestRule<>(ListNeighbourActivity.class);

//    @Rule
//    public ActivityTestRule<NeighbourProfileDetailsActivity> mActivityRule =
//            new ActivityTestRule<>(NeighbourProfileDetailsActivity.class, false, false);
//


//    @Test
//    public void TestNeighbourProfileActivityStarted(){
//
//        //checking if activity starts
//        Intent intent = new Intent(Intent.ACTION_PICK);
//        intentsTestRule.launchActivity(intent);
        //>>> check it <<<<<<<
//        onView(Matchers.allOf(withId(R.id.list_neighbours),isDisplayed()))
//                .perform(actionOnItemAtPosition(position, click()));
        //onData(allOf(is(instanceOf(NeighbourProfileDetailsActivity.class)), is("Carolina"))).perform(click());




        //onData(anything()).inAdapterView(withId(R.id.list_neighbours)).atPosition(0).perform(click());

        //check data matches<<<<<<<<<<<<<<<<<<
//        public void testListViewPeople() {
//            List<Person> listPeople = DataProvider.getMockPeopleSet1();
//            for (int position = 0; position < listPeople.size(); position++) {
//                onData(is(instanceOf(Person.class)))
//                        .inAdapterView(withId(R.id.list_view))
//                        .atPosition(position)
//                        .onChildView(withText(listPeople.get(position).getName()))
//                        .check(matches(isDisplayed()));
//            }
//        }

        //click on item <<<<<<<<<<<<<<<<<
//        EspressoTestUtils.clickAdapterViewItem(...)
///**
// * Performs a click on an item in an adapter view, such as GridView or ListView
// * @param position
// * @param resourceId of adapter view holding the item that should be clicked
// */
//        public static void clickAdapterViewItem(int position, int resourceId) {
//            onData(anything()).inAdapterView(allOf(withId(resourceId), isDisplayed()))
//                    .atPosition(position).perform(click());
//        }


    }


