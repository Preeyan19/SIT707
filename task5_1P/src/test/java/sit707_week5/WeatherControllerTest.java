package sit707_week5;

import org.junit.*;
import java.util.*;

public class WeatherControllerTest {

	private static WeatherController wController;
	private static double[] hourlyTemperatures;

	@BeforeClass
	public static void setUp() {
		// Initialise controller
		wController = WeatherController.getInstance();

		// Retrieve all the hours temperatures recorded as for today and cache them
		int nHours = wController.getTotalHours();
		hourlyTemperatures = new double[nHours];
		for (int i = 0; i < nHours; i++) {
			// Hour range: 1 to nHours
			hourlyTemperatures[i] = wController.getTemperatureForHour(i + 1);
		}
	}

	@AfterClass
	public static void tearDown() {
		// Shutdown controller
		wController.close();
	}

	@Test
	public void testStudentIdentity() {
		String studentId = "223960129"; 
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "PREEYAN"; 
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");

		// Arrange
		double minTemperature = 1000;
		for (double temperatureVal : hourlyTemperatures) {
			if (minTemperature > temperatureVal) {
				minTemperature = temperatureVal;
			}
		}

		// Act
		double actualMin = wController.getTemperatureMinFromCache();

		// Assert
		Assert.assertTrue(actualMin == minTemperature);
	}

	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");

		// Arrange
		double maxTemperature = -1;
		for (double temperatureVal : hourlyTemperatures) {
			if (maxTemperature < temperatureVal) {
				maxTemperature = temperatureVal;
			}
		}

		// Act
		double actualMax = wController.getTemperatureMaxFromCache();

		// Assert
		Assert.assertTrue(actualMax == maxTemperature);
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");

		// Arrange
		double sumTemp = 0;
		for (double temperatureVal : hourlyTemperatures) {
			sumTemp += temperatureVal;
		}
		double averageTemp = sumTemp / hourlyTemperatures.length;

		// Act
		double actualAverage = wController.getTemperatureAverageFromCache();

		// Assert
		Assert.assertTrue(actualAverage == averageTemp);
	}

	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}
