package ru.savchenko.andrey.deliveryapp;

import net.danlew.android.joda.JodaTimeAndroid;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@Config(constants = BuildConfig.class, sdk = 21, packageName = "ru.savchenko.andrey.deliveryapp")
@RunWith(RobolectricGradleTestRunner.class)
public class ExampleUnitTest {
    @Before
    public void setup(){
        JodaTimeAndroid.init(RuntimeEnvironment.application);
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testTime(){
        DateTime d1 = new DateTime(1504959792964L);
        DateTime d2 = new DateTime();

        long minutes = d2.getMinuteOfDay() - d1.getMinuteOfDay();
        System.out.println(d1);
        System.out.println(d2);
        if(minutes<60){
            System.out.println("minutes " + minutes);
        }else {
            System.out.println("hours " + minutes /60);
        }
//        Date dateCreated = new Date(1504959792964L);
//        Date now = new Date();
//        System.out.println(now.getTime() - dateCreated.getTime());
    }
}