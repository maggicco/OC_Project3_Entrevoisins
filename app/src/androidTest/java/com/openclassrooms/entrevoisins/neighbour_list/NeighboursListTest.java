
package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsNull.notNullValue;



/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static int ITEMS_COUNT = 12;
    private ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We remove the element at position 2
        onView(ViewMatchers.withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(ViewMatchers.withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(ViewMatchers.withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT-1));
    }

    /**
     * Check if activity NeighbourProfileDetail starts
     */
    @Test
    public void neighbourProfileDetailActivityStarts() {
        onView(withId(R.id.list_neighbours))
                .perform(actionOnItemAtPosition(1, click()));
        onView(allOf(withId(R.id.profile_details_activity), isDisplayed()));
    }

    /**
     * Check if name match in NeighbourProfileDetail textView
     * from list_neighbour recycler view
     */
    @Test
    public void matchNeighbourProfileDetailName() {
        onView(withId(R.id.list_neighbours))
                .perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.cardViewProfileName))
                .check(matches(withText("Caroline")));
    }

    /**
     * Check if from NeighbourProfileDetailActivity
     * setDisplayHomeAsUpEnabled works
     */
    @Test
    public void goBackFromNeighbourProfileDetailActivity() {
        onView(withId(R.id.list_neighbours))
                .perform(actionOnItemAtPosition(0, click()));
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());
    }

    /**
     * We ensure that our recyclerview is displaying only favorites
     * means should be empty
     * Check if  favorite button in NeighbourProfileDetailActivity works
     * Checking if back arrow button works
     */
    @Test
    public void checkFavoriteButtonAndDisplayFavorites() {
        onView(ViewMatchers.withId(R.id.fav_recyclerview))
                .check(withItemCount(0));

        onView(withId(R.id.list_neighbours))
                .perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.floatingActionButton)).perform(click());
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());

        onView(withContentDescription("Favorites")).perform(click());
        onView(withId(R.id.fav_recyclerview)).check(withItemCount(1));

        onView(withContentDescription("My neighbours")).perform(click());
        onView(withId(R.id.list_neighbours))
                .perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.floatingActionButton)).perform(click());
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());

        onView(withContentDescription("Favorites")).perform(click());
        onView(withId(R.id.fav_recyclerview)).check(withItemCount(0));

    }

}