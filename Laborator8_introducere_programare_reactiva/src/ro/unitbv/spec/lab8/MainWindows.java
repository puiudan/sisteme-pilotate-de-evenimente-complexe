package ro.unitbv.spec.lab8;

/**
 * This is a support project for SPEC Lab 8.
 * 
 * At the end of the main method a stream of weather events is
 * generated from a CSV file. Each line of the CSV file is pushed to
 * a reactive PublishSubject<WeatherEvent>.
 * 
 * Process the weather events and generate the following alarms:
 * 
 *  Alarm1: when the daily temperature average for location "BRASOV GHIMBAV"
 *  is higher than 22 degrees Celsius. 
 *  
 *  Alarm2: when three consecutive days have the average temperature for
 *  location "BRASOV GHIMBAV" higher than 20 degrees Celsius.
 *  
 * 
 * Documentation: http://reactivex.io/documentation/operators.html
 * 
 * @author dan.puiu
 * 
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import ro.unitbv.spec.lab8.events.AverageTemperatureEvent;
import ro.unitbv.spec.lab8.events.WeatherEvent;
import rx.Observable;
import rx.schedulers.TestScheduler;
import rx.subjects.PublishSubject;

public class MainWindows {
	
	public static void main(String... str) {

		PublishSubject<WeatherEvent> stream = PublishSubject.create();
		TestScheduler scheduler = new TestScheduler();

		stream
		//put your code here
		.forEach(value->System.out.println(value));
		

		try {
			BufferedReader br = new BufferedReader(new FileReader("Resources/TemperatureEventMR_long.csv"));

			//first line is for header
			String line = br.readLine();
			
			line = br.readLine();
			WeatherEvent event = createWeatherEventFromString(line);
			Long lastTimestamp = event.getTimestamp();
			stream.onNext(event);
			
			long advanceInterval;
			
			while ((line = br.readLine()) != null){
				event = createWeatherEventFromString(line);
				advanceInterval = event.getTimestamp()-lastTimestamp;
				scheduler.advanceTimeBy(advanceInterval, TimeUnit.MILLISECONDS);
				lastTimestamp = event.getTimestamp();
				stream.onNext(event);
			}

			br.close();
			stream.onCompleted();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Finish");

	}
	
	public static WeatherEvent createWeatherEventFromString(String csvLine){
		
		String[] csvLineTokens =  csvLine.split(",");
		
		return new WeatherEvent(csvLineTokens[1].replace("\"", ""), Double.parseDouble(csvLineTokens[2]),
				Double.parseDouble(csvLineTokens[3]), Double.parseDouble(csvLineTokens[4]),
				Long.parseLong(csvLineTokens[5]));
		
	}


}
