package ro.unitbv.spec.lab5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ro.unitbv.spec.lab5.events.Measurement;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * This is a support project for SPEC Lab 5.
 * 
 * At the end of the main method a stream of events Temperature measurements is
 * generated from a CSV file. The application every 200 milliseconds reads an
 * observation from the CSV and push it into the CEP engine. There are 5 sensors
 * which can generate temperature observations.
 * 
 * We define the 1 sec growing rate as being the slope of the signal in that
 * particular 1 second window.
 * 
 * 1) Detect the moments of time when the temperature 1 sec growing rate is
 * bigger than 0.1 for more than 3 seconds.
 * 
 * 2) Detect the average values of the last 5 observations for each and every
 * sensorID.
 *  
 * Documentation: Esper 4.9 reference - Chapter 12 EPL Reference: Views
 * 
 * @author dan.puiu
 * 
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Configuration config = new Configuration();
		config.addEventTypeAutoName("ro.unitbv.spec.lab5.events");
		EPServiceProvider epService = EPServiceProviderManager
				.getDefaultProvider(config);

		// TODO: solve the problem here

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"Resources/dataset_mic.csv"));

			String line;
			while ((line = br.readLine()) != null) {

				String[] tokens = line.split(",");

				Measurement measurement = new Measurement(
						Double.parseDouble(tokens[1]),
						Integer.parseInt(tokens[0]), tokens[2]);

				epService.getEPRuntime().sendEvent(measurement);

				if ((measurement.getTime() % 25) == 0)
					System.out.println(measurement);

				Thread.sleep(200);
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
