package ro.unitbv.spec.lab2;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

import ro.unitbv.spec.lab2.events.TemperatureEvent;

/**
 * This is a support project for SPEC Lab 2.
 * 
 * At the end of the main method a stream of events of type TemperatureEvent is
 * generated.
 * 
 * 1) Generate the average of the temperature events reported in the last 2
 * seconds using a sliding time window and the average aggregator.
 * 
 * 2) Count how many events of have been reported for location B in the last 3
 * seconds.
 * 
 * 3) Generate the average of the temperature events reported in the last 2
 * seconds for room "A".
 * 
 * Documentation: Esper 4.9 reference - Chapter 10 EPL Reference: Enumeration
 * Methods
 * 
 * @author dan.puiu
 * 
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Configuration config = new Configuration();
		config.addEventTypeAutoName("ro.unitbv.spec.lab2.events");
		EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);

		// TODO: solve the problem here

		
		
		
		
		
		
		
		
		
		
		
		
		
		TemperatureEvent temperatureEvent;

		temperatureEvent = new TemperatureEvent(23, "A");
		epService.getEPRuntime().sendEvent(temperatureEvent);
		Thread.sleep(200);

		temperatureEvent = new TemperatureEvent(20, "B");
		epService.getEPRuntime().sendEvent(temperatureEvent);
		Thread.sleep(1000);

		temperatureEvent = new TemperatureEvent(2, "A");
		epService.getEPRuntime().sendEvent(temperatureEvent);
		Thread.sleep(1200);

		temperatureEvent = new TemperatureEvent(3, "B");
		epService.getEPRuntime().sendEvent(temperatureEvent);
		Thread.sleep(800);

		temperatureEvent = new TemperatureEvent(12, "A");
		epService.getEPRuntime().sendEvent(temperatureEvent);
		Thread.sleep(500);

		temperatureEvent = new TemperatureEvent(25, "A");
		epService.getEPRuntime().sendEvent(temperatureEvent);
		Thread.sleep(300);

		Thread.sleep(2000);
		System.out.println("Finish");

	}
}