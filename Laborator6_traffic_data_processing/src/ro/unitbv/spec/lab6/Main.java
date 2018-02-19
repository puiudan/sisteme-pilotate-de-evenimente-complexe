package ro.unitbv.spec.lab6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import ro.unitbv.spec.lab6.events.TrafficObservation;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * This is a support project for SPEC Lab 6.
 * 
 * At the end of the main method a stream of events traffic observations is
 * generated from a CSV file. The application every second reads an observation
 * from the CSV and push it into the CEP engine.
 * 
 * The main fields of the traffic observation are: TIMESTAMP avgSpeed - the
 * average speed of the cars on the sensor area vehicleCount - the number of
 * cars for the sensor area
 * 
 * Create an event processing network which is able to detect the traffic jams.
 * A traffic jam is considered when the average speed is lower than 40 and the
 * number of cars is higher than 25 for at least 3 seconds.
 * 
 * The traffic jam should be reported only once even if the period is longer
 * than 3 seconds. At the end of the traffic jam period a notification has to be
 * generated.
 * 
 * Documentation: Esper 4.9 reference
 * 
 * @author dan.puiu
 * 
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Configuration config = new Configuration();
		config.addEventTypeAutoName("ro.unitbv.spec.lab6.events");
		EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);

		String expression = "select TIMESTAMP,avgSpeed,vehicleCount from TrafficObservation";
		EPStatement statement = epService.getEPAdministrator().createEPL(expression);

		statement.addListener(new UpdateListener() {

			@Override
			public void update(EventBean[] arg0, EventBean[] arg1) {
				for (int i = 0; i < arg0.length; i++) {
					EventBean event = arg0[i];

					System.out.println("Traffic observation: " + event.get("TIMESTAMP") + ", "
							+ (Integer) event.get("avgSpeed") + ", " + (Integer) event.get("vehicleCount"));

				}
			}
		});

		
		// TODO: solve the problem here
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		try {
			BufferedReader br = new BufferedReader(new FileReader("Resources/trafficData_mic.csv"));

			String line = br.readLine();
			while ((line = br.readLine()) != null) {

				String[] tokens = line.split(";");

				TrafficObservation measurement = new TrafficObservation(tokens[0], tokens[1],
						Integer.parseInt(tokens[2]), tokens[3], tokens[4], tokens[5], Integer.parseInt(tokens[6]),
						tokens[7], tokens[8]);

				epService.getEPRuntime().sendEvent(measurement);

				Thread.sleep(1000);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Finish");

	}

}
