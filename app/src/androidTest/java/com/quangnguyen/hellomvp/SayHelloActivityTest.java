package com.quangnguyen.hellomvp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Integration UI tests in main screen
 *
 * @author Quang Nguyen.
 */
@RunWith(AndroidJUnit4.class) public class SayHelloActivityTest {
  private final String FIRST = "Quang";
  private final String LAST = "Nguyen";

  private String message = "Hi " + FIRST + " " + LAST + "!";

  @Rule
  public ActivityTestRule<SayHelloActivity> testRule =
      new ActivityTestRule<>(SayHelloActivity.class);

  @Test
  public void showMessage() {
    // Enter name to name edit texts
    onView(withId(R.id.firstName)).perform(replaceText(FIRST), closeSoftKeyboard());
    onView(withId(R.id.lastName)).perform(replaceText(LAST), closeSoftKeyboard());
    // Click update button
    onView(withId(R.id.update)).perform(click());
    // Click show button
    onView(withId(R.id.showMessage)).perform(click());
    // Verify message shown on screen
    onView(withText(message)).check(matches(isDisplayed()));
  }
}