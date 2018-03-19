package ro.unitbv.spec.examen2016;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;

import ro.unitbv.spec.examen2017.events.BookOrder;
import ro.unitbv.spec.examen2017.events.ToysOrder;

/**
 * Acesta este un proiect suport pentru examenul SPEC.
 * 
 * Se considera un magazin care vinde carti si jucarii. Cartile sunt vandute in
 * colete si pentru fiecare colet se genereaza un eveniment care contine numarul
 * de carti din colet. Jucariile sun vandute individual iar evenimentul generat
 * contine pretul acesteia. Sa se proceseze fluxul de evenimente si sa se
 * identifice urmatoarele:
 * 
 * 1) Coletele cu cel mai mic numar de carti pentru ultimele 3 evenimente.
 * 
 * 2) Evenimentele de vanzare jucarii care nu sunt urmate de un eveniment de
 * vanzare carte timp de 2 secunde.
 * 
 * 3) Cate evenimente de vanzare colet nu au fost urmate de un eveniment vanzare
 * jucarie timp de 4 secunde in ultimele 20 de secunde.
 * 
 * 4) Pentru fiecare 24 de ore care a fost pretul celei mai scumpe jucarii.
 * Raportul trebuie facut o singura data per 24 ore.
 * 
 * @author dan.puiu
 * 
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Configuration config = new Configuration();
		config.addEventTypeAutoName("ro.unitbv.spec.examen2017.events");
		EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider(config);

		// TODO: solve the problem here

		// TODO: until here

		ToysOrder toysOrder;
		BookOrder bookOrder;

		toysOrder = new ToysOrder(2.3);
		epService.getEPRuntime().sendEvent(toysOrder);
		Thread.sleep(4200);

		bookOrder = new BookOrder(40);
		epService.getEPRuntime().sendEvent(bookOrder);
		Thread.sleep(200);

		bookOrder = new BookOrder(20);
		epService.getEPRuntime().sendEvent(bookOrder);
		Thread.sleep(200);

		toysOrder = new ToysOrder(4.5);
		epService.getEPRuntime().sendEvent(toysOrder);
		Thread.sleep(200);

		toysOrder = new ToysOrder(1.3);
		epService.getEPRuntime().sendEvent(toysOrder);
		Thread.sleep(200);

		bookOrder = new BookOrder(44);
		epService.getEPRuntime().sendEvent(bookOrder);
		Thread.sleep(200);

		bookOrder = new BookOrder(42);
		epService.getEPRuntime().sendEvent(bookOrder);
		Thread.sleep(200);

		bookOrder = new BookOrder(100);
		epService.getEPRuntime().sendEvent(bookOrder);
		Thread.sleep(200);

		toysOrder = new ToysOrder(2.7);
		epService.getEPRuntime().sendEvent(toysOrder);
		Thread.sleep(2200);

		toysOrder = new ToysOrder(2.1);
		epService.getEPRuntime().sendEvent(toysOrder);
		Thread.sleep(200);

		bookOrder = new BookOrder(41.3);
		epService.getEPRuntime().sendEvent(bookOrder);
		Thread.sleep(200);

		toysOrder = new ToysOrder(0.3);
		epService.getEPRuntime().sendEvent(toysOrder);
		Thread.sleep(200);

		bookOrder = new BookOrder(40.3);
		epService.getEPRuntime().sendEvent(bookOrder);
		Thread.sleep(200);

		Thread.sleep(2000);
		System.out.println("Finish");

	}

}
