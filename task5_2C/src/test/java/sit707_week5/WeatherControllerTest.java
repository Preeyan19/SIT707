package sit707_week5;

import org.junit.Assert;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherControllerTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "223960129"; 
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Preeyan"; 
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");
        WeatherController wController = WeatherController.getInstance();
        int nHours = wController.getTotalHours();
        double minTemperature = 1000;
        for (int i = 0; i < nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i + 1);
            if (minTemperature > temperatureVal) {
                minTemperature = temperatureVal;
            }
        }
        Assert.assertEquals(minTemperature, wController.getTemperatureMinFromCache(), 0.001);
        wController.close();
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");
        WeatherController wController = WeatherController.getInstance();
        int nHours = wController.getTotalHours();
        double maxTemperature = -1;
        for (int i = 0; i < nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i + 1);
            if (maxTemperature < temperatureVal) {
                maxTemperature = temperatureVal;
            }
        }
        Assert.assertEquals(maxTemperature, wController.getTemperatureMaxFromCache(), 0.001);
        wController.close();
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");
        WeatherController wController = WeatherController.getInstance();
        int nHours = wController.getTotalHours();
        double sumTemp = 0;
        for (int i = 0; i < nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i + 1);
            sumTemp += temperatureVal;
        }
        double averageTemp = sumTemp / nHours;
        Assert.assertEquals(averageTemp, wController.getTemperatureAverageFromCache(), 0.001);
        wController.close();
    }

    @Test
    public void testTemperaturePersist() {
        System.out.println("+++ testTemperaturePersist +++");

        WeatherController wController = WeatherController.getInstance();

        Date fixedNow = new Date(); // Use a fixed time for both parts
        String expectedTime = new SimpleDateFormat("H:m:s").format(fixedNow);
        String persistTime = wController.persistTemperatureWithFixedTime(10, 19.5, fixedNow);

        System.out.println("Persist time: " + persistTime + ", expected: " + expectedTime);
        Assert.assertEquals(expectedTime, persistTime);

        wController.close();
    }
}
