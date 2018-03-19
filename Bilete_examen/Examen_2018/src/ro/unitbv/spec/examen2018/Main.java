package ro.unitbv.spec.examen2018;

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

import ro.unitbv.spec.examen2018.events.WeatherEvent;

/**
 * Acesta este un proiect suport pentru examenul SPEC.
 * 
 * O statie meteo genereaza cate o masuratoare la fiecare secunda. Fiecare
 * masuratoare contine: numele statie, tipul de nebulozitate, presinea
 * atmosferica, umiditatea relativa, temperatura si viteza vantului.
 * 
 * Sa se proceseze fluxul de evenimente si sa se identifice urmatoarele:
 * 
 * 1) La fiecare patru masuratori care a fost maximul temperaturii.
 * 
 * 2) Evenimentele care au presiunea mai mare de 1000 si nu sunt urmate de un
 * eveniment care anunta ca temperatura este mai mare de 36 in 3 secunde.
 * 
 * 3) Momentele de timp in care avem mai mult de 3 masuratori a caror tip de
 * nebulositate nu este disponibil in ultimele 5 secunde.
 * 
 * 4) Pentru fiecare 24 de ore care a fost media umiditatii.
 * Raportul trebuie facut o singura data per 24 ore.
 * 
 * @author dan.puiu
 * 
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Configuration config = new Configuration();
		config.addEventTypeAutoName("ro.unitbv.spec.examen2018.events");
		EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);

		// TODO: solve the problem here

		String expression = "select * from WeatherEvent";
		EPStatement statement = epService.getEPAdministrator().createEPL(expression);

		statement.addListener(new UpdateListener() {

			@Override
			public void update(EventBean[] arg0, EventBean[] arg1) {
				for (int i = 0; i < arg0.length; i++) {
					EventBean event = arg0[i];

					System.out.println(event.toString().replace(
							"BeanEventBean eventType=BeanEventType name=WeatherEvent clazz=ro.unitbv.spec.examen2018.events.WeatherEvent bean=WeatherEvent ",
							""));

				}
			}
		});

		try {
			BufferedReader br = new BufferedReader(new FileReader("Resources/data.csv"));

			String line = br.readLine();
			while ((line = br.readLine()) != null) {

				String[] tokens = line.split(",");

				WeatherEvent measurement = new WeatherEvent(tokens[0], tokens[1], Double.parseDouble(tokens[2]),
						Integer.parseInt(tokens[3]), Double.parseDouble(tokens[4]), Integer.parseInt(tokens[5]));

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
