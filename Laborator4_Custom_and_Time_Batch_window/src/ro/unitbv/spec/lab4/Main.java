package ro.unitbv.spec.lab4;

import ro.unitbv.spec.lab4.events.ErrorEvent;
import ro.unitbv.spec.lab4.events.TemperatureEvent;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * This is a support project for SPEC Lab 4.
 * 
 * At the end of the main method a stream of events (of type TemperatureEvent
 * and ErrorEvent) is generated.
 * 
 * 1) Generate the average of all temperature events reported until you receive
 * a new error event. When the error event is received the average should start
 * from 0.
 * 
 * 2) Every one second compute the average of the temperature measurements
 * received in the last 1 second. (time_batch window can be used for that).
 * 
 * Documentation: Esper 4.9 reference - Chapter 12 EPL Reference: Views
 * 
 * @author dan.puiu
 * 
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Configuration config = new Configuration();
		config.addEventTypeAutoName("ro.unitbv.spec.lab4.events");
		EPServiceProvider epService = EPServiceProviderManager
				.getDefaultProvider(config);

		// TODO: solve the problem here

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		Thread.sleep(200);
		TemperatureEvent temperatureEvent = new TemperatureEvent(1.0);
		epService.getEPRuntime().sendEvent(temperatureEvent);
		Thread.sleep(200);

		temperatureEvent = new TemperatureEvent(2.0);
		epService.getEPRuntime().sendEvent(temperatureEvent);
		Thread.sleep(200);

		temperatureEvent = new TemperatureEvent(3.0);
		epService.getEPRuntime().sendEvent(temperatureEvent);
		Thread.sleep(200);

		ErrorEvent errorEvent = new ErrorEvent(23);
		epService.getEPRuntime().sendEvent(errorEvent);

		temperatureEvent = new TemperatureEvent(4.0);
		epService.getEPRuntime().sendEvent(temperatureEvent);
		Thread.sleep(200);

		temperatureEvent = new TemperatureEvent(5.0);
		epService.getEPRuntime().sendEvent(temperatureEvent);
		Thread.sleep(200);

		temperatureEvent = new TemperatureEvent(6.0);
		epService.getEPRuntime().sendEvent(temperatureEvent);
		Thread.sleep(200);

		errorEvent = new ErrorEvent(23);
		epService.getEPRuntime().sendEvent(errorEvent);

		temperatureEvent = new TemperatureEvent(7.0);
		epService.getEPRuntime().sendEvent(temperatureEvent);
		Thread.sleep(6200);

		System.out.println("Finish");

	}

}

