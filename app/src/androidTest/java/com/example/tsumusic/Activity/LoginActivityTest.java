package com.example.tsumusic.Activity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.test.rule.ActivityTestRule;

import com.example.tsumusic.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    private LoginActivity loginActivity;

    @Before
    public void setUp() throws Exception {
        loginActivity = loginActivityActivityTestRule.getActivity();

    }

    @Test
    public void testLoginCorrectly() throws InterruptedException {

        onView(withId(R.id.Username1)).perform(typeText("letrongnhan123"),closeSoftKeyboard());
        onView(withId(R.id.PassWord)).perform(typeText("Letrongnhan123@"),closeSoftKeyboard());
        onView(withId(R.id.btnsignin)).perform(click());

        Thread.sleep(5000);
    }
    //
    @Test
    public void testInCorrectUsernameOrPassword() throws InterruptedException {

        onView(withId(R.id.Username1)).perform(typeText("letrongnhan123"),closeSoftKeyboard());
        onView(withId(R.id.PassWord)).perform(typeText("ahdhdhryerhr"),closeSoftKeyboard());
        onView(withId(R.id.btnsignin)).perform(click());

        Thread.sleep(5000);
    }

    @Test
    public void testPassWordNull() throws InterruptedException {

        onView(withId(R.id.Username1)).perform(typeText("letrongnhan123"),closeSoftKeyboard());
        onView(withId(R.id.PassWord)).perform(closeSoftKeyboard());
        onView(withId(R.id.btnsignin)).perform(click());

        Thread.sleep(5000);
    }

    @Test
    public void testUserNameNull() throws InterruptedException {

        onView(withId(R.id.Username1)).perform(closeSoftKeyboard());
        onView(withId(R.id.PassWord)).perform(typeText("Letrongnhan123@"),closeSoftKeyboard());
        onView(withId(R.id.btnsignin)).perform(click());

        Thread.sleep(5000);
    }

    @Test
    public void testUserNamePassWordNull() throws InterruptedException {

        onView(withId(R.id.Username1)).perform(closeSoftKeyboard());
        onView(withId(R.id.PassWord)).perform(closeSoftKeyboard());
        onView(withId(R.id.btnsignin)).perform(click());

        Thread.sleep(5000);
    }


    @After
    public void tearDown() throws Exception {
        loginActivity = null;

    }
}