package ro.unitbv.spec.lab7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

import ro.unitbv.spec.lab7.events.ValveObservation;

/**
 * This is a support project for SPEC Lab 7.
 * 
 * At the end of the main method a stream of events valve observations is
 * generated from a CSV file. The application every second reads an observation
 * from the CSV and push it into the CEP engine.
 * 
 * The main fields of the valve observation are: TIMESTAMP; pressure - the
 * pressure of the liquid from tank; sound - the level of noise generate by the
 * valve
 * 
 * Create an event processing network which is able to detect the following
 * safety valve states:
 * 
 * Valve is working normal: when the pressure goes above 60 in lees than 3
 * seconds the safety valve is triggered and after that in less than 4 seconds
 * the pressure goes bellow 40.
 * 
 * Warning valve opened too late: when the pressure goes above 60, it takes more
 * than 3 seconds and less than 7 seconds for the safety valve to be triggered
 * and after that in less than 4 seconds the pressure goes bellow 40.
 *
 * Warning valve not open completely: when the pressure goes above 60 in lees
 * than 3 seconds the safety valve is triggered and after that it needs more
 * than 4 seconds for the pressure to go bellow 40.
 * 
 * Error valve failed to open: when the pressure goes above 60 and the safety
 * valve is not triggered in 7 seconds
 * 
 * Event safety valve maintenance needed: for every error event or if 2 warning
 * message are generated in less than 28 seconds and there is no safety valve
 * normal operation event in this interval.
 * 
 * 
 * Documentation: Esper 4.9 reference
 * 
 * @author dan.puiu
 * 
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Configuration config = new Configuration();
		config.addEventTypeAutoName("ro.unitbv.spec.lab7.events");
		EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);

		String expression = "select ID, TIMESTAMP,presure,sound from ValveObservation";
		EPStatement statement = epService.getEPAdministrator().createEPL(expression);

		statement.addListener(new UpdateListener() {

			@Override
			public void update(EventBean[] arg0, EventBean[] arg1) {
				for (int i = 0; i < arg0.length; i++) {
					EventBean event = arg0[i];

					System.out.println("Valve observation: " + event.get("ID") + ", "+ event.get("TIMESTAMP") + ", "
							+ (Integer) event.get("presure") + ", " + (Integer) event.get("sound"));

				}
			}
		});
		
		
		// TODO: solve the problem here
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		try {
			BufferedReader br = new BufferedReader(new FileReader("Resources/valveData_mic1.csv"));

			String line = br.readLine();
			while ((line = br.readLine()) != null) {

				String[] tokens = line.split(";");

				ValveObservation measurement = new ValveObservation(tokens[0], tokens[1], Integer.parseInt(tokens[2]),
						Integer.parseInt(tokens[3]));

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
