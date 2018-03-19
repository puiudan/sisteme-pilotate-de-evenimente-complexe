package ro.unitbv.spec.examen2015;

import ro.unitbv.spec.examen2015.events.Laptop;
import ro.unitbv.spec.examen2015.events.Phone;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;

/**
 * Acesta este un proiect suport pentru examenul SPEC.
 * 
 * Se considera un magazin online care vinde telefoane si laptop-uri. Sa se
 * proceseze fluxul de evenimente si sa se identivice urmatoarele:
 * 
 * 1) Media preturilor la calculatoarele vandute in ultimele 20 secunde.
 * 
 * 2) Media priturilor la ultimele 3 telefoane vandute.
 * 
 * 3) toate telefoanele care sunt vandute dupa ce a fost vandut un calcular la
 * maxim 5 secunde
 * 
 * 4)media preturilor pentru telefoanele vandude dupa ce a fost vandut un
 * calculator.
 * 
 * @author dan.puiu
 * 
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Configuration config = new Configuration();
		config.addEventTypeAutoName("ro.unitbv.spec.examnen2015.events");
		EPServiceProvider epService = EPServiceProviderManager
				.getDefaultProvider(config);

		// TODO: solve the problem here

		Phone phone;
		Laptop laptop;

		phone = new Phone("Samsung", 2.3);
		epService.getEPRuntime().sendEvent(phone);
		Thread.sleep(200);

		laptop = new Laptop("Dell", 40.3);
		epService.getEPRuntime().sendEvent(laptop);
		Thread.sleep(200);

		laptop = new Laptop("Dell", 20.3);
		epService.getEPRuntime().sendEvent(laptop);
		Thread.sleep(200);

		phone = new Phone("Samsung", 4.5);
		epService.getEPRuntime().sendEvent(phone);
		Thread.sleep(200);

		phone = new Phone("Samsung", 1.3);
		epService.getEPRuntime().sendEvent(phone);
		Thread.sleep(200);

		laptop = new Laptop("Dell", 44.3);
		epService.getEPRuntime().sendEvent(laptop);
		Thread.sleep(200);

		laptop = new Laptop("Dell", 42.1);
		epService.getEPRuntime().sendEvent(laptop);
		Thread.sleep(200);

		laptop = new Laptop("Dell", 100.33);
		epService.getEPRuntime().sendEvent(laptop);
		Thread.sleep(200);

		phone = new Phone("Samsung", 2.7);
		epService.getEPRuntime().sendEvent(phone);
		Thread.sleep(200);

		phone = new Phone("Samsung", 2.1);
		epService.getEPRuntime().sendEvent(phone);
		Thread.sleep(200);

		laptop = new Laptop("Dell", 41.3);
		epService.getEPRuntime().sendEvent(laptop);
		Thread.sleep(200);

		phone = new Phone("Samsung", 0.3);
		epService.getEPRuntime().sendEvent(phone);
		Thread.sleep(200);

		laptop = new Laptop("Dell", 40.3);
		epService.getEPRuntime().sendEvent(laptop);
		Thread.sleep(200);

		Thread.sleep(2000);
		System.out.println("Finish");

	}

}
