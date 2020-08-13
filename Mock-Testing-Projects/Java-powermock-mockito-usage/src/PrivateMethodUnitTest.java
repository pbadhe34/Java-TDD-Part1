

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.data.ClassWithPrivateMethods;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.data.ClassWithPrivateMethods")
public class PrivateMethodUnitTest {

    @Test
    public final void testPrivateMethodMockWithoutArgs() throws Exception {
        ClassWithPrivateMethods mock = PowerMockito.spy(new ClassWithPrivateMethods());

        PowerMockito.when(mock, "getDefaultNumber").thenReturn(300);

        int result = mock.getDataNumber(null);

        assertEquals(300, result);
    }

    @Test
    public final void testPrivateMethodMockWithArgumentAndReturn() throws Exception {
        ClassWithPrivateMethods mock = PowerMockito.spy(new ClassWithPrivateMethods());

       // doReturn(1).when(mock, "getComputedNumber", ArgumentMatchers.anyInt());
        PowerMockito.when(mock, "getComputedNumber", ArgumentMatchers.anyInt()).thenReturn(1);

        int result = mock.getDataNumber("Moraya");

        assertEquals(1, result);
    }

    @Test
    public final void testPrivateMethodMockWithNoArgumentAndReturn() throws Exception {
        ClassWithPrivateMethods mock = spy(new ClassWithPrivateMethods());

        int result = mock.getDataNumber("Dianosourous");

        PowerMockito.verifyPrivate(mock).invoke("saveIntoDatabase", ArgumentMatchers.anyString());
        assertEquals(10000, result);
    }

}
