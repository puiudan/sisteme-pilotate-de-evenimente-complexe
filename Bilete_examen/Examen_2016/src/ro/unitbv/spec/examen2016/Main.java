package ro.unitbv.spec.examen2016;

import ro.unitbv.spec.examen2016.events.Temperatura;
import ro.unitbv.spec.examen2016.events.Humidity;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * Acesta este un proiect suport pentru examenul SPEC.
 * 
 * Se considera ca un senzor de temperarura si unul de umiditate genereaza
 * masuratori la momente diferite de timp. Sa se proceseze fluxul de evenimente
 * si sa se identifice urmatoarele:
 * 
 * 1) Media temperaturilor pentru ultimele 3 mesaje.
 * 
 * 2) Mesajele de umiditate care nu sunt urmate de un mesaj de temperatura timp
 * de 2 secunde.
 * 
 * 3) Cate mesaje de umiditate nu au fost urmate de un mesaj de temperatura timp
 * de 2 secunde in ultimele 20 de secunde.
 * 
 * 4) Media masuratorilor de umiditate care au fost receptionate de cand a
 * pornit aplicatia.
 * 
 * @author dan.puiu
 * 
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Configuration config = new Configuration();
		config.addEventTypeAutoName("ro.unitbv.spec.examen2016.events");
		EPServiceProvider epService = EPServiceProviderManager
				.getDefaultProvider(config);

		// TODO: solve the problem here

	
		
		

		// TODO: until here

		Humidity humidity;
		Temperatura temperatura;

		humidity = new Humidity(2.3);
		epService.getEPRuntime().sendEvent(humidity);
		Thread.sleep(4200);

		temperatura = new Temperatura(40.3);
		epService.getEPRuntime().sendEvent(temperatura);
		Thread.sleep(200);

		temperatura = new Temperatura(20.3);
		epService.getEPRuntime().sendEvent(temperatura);
		Thread.sleep(200);

		humidity = new Humidity(4.5);
		epService.getEPRuntime().sendEvent(humidity);
		Thread.sleep(200);

		humidity = new Humidity(1.3);
		epService.getEPRuntime().sendEvent(humidity);
		Thread.sleep(200);

		temperatura = new Temperatura(44.3);
		epService.getEPRuntime().sendEvent(temperatura);
		Thread.sleep(200);

		temperatura = new Temperatura(42.1);
		epService.getEPRuntime().sendEvent(temperatura);
		Thread.sleep(200);

		temperatura = new Temperatura(100.33);
		epService.getEPRuntime().sendEvent(temperatura);
		Thread.sleep(200);

		humidity = new Humidity(2.7);
		epService.getEPRuntime().sendEvent(humidity);
		Thread.sleep(2200);

		humidity = new Humidity(2.1);
		epService.getEPRuntime().sendEvent(humidity);
		Thread.sleep(200);

		temperatura = new Temperatura(41.3);
		epService.getEPRuntime().sendEvent(temperatura);
		Thread.sleep(200);

		humidity = new Humidity(0.3);
		epService.getEPRuntime().sendEvent(humidity);
		Thread.sleep(200);

		temperatura = new Temperatura(40.3);
		epService.getEPRuntime().sendEvent(temperatura);
		Thread.sleep(200);

		Thread.sleep(2000);
		System.out.println("Finish");

	}

}
