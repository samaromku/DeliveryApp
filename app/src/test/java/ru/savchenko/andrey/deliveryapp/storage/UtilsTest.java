package ru.savchenko.andrey.deliveryapp.storage;

import net.danlew.android.joda.JodaTimeAndroid;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import ru.savchenko.andrey.deliveryapp.BuildConfig;

/**
 * Created by Andrey on 09.09.2017.
 */
@Config(constants = BuildConfig.class, sdk = 21, packageName = "ru.savchenko.andrey.deliveryapp")
@RunWith(RobolectricGradleTestRunner.class)
public class UtilsTest {
    @Before
    public void setUp() throws Exception {
        JodaTimeAndroid.init(RuntimeEnvironment.application);
    }

    @Test
    public void getDifferenceString() throws Exception {
//        assertEquals(0, Utils.getDifferenceString(new DateTime(), new DateTime()));
    }

}