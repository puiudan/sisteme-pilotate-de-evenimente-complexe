package ro.unitbv.spec.lab3;

import ro.unitbv.spec.lab3.events.PurchaseOrderA;
import ro.unitbv.spec.lab3.events.PurchaseOrderB;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * This is a support project for SPEC Lab 3.
 * 
 * At the end of the main method a stream of events (of type PurchaseOrderA and
 * PurchaseOrderB) is generated.
 * 
 * The following patterns have to be detected:
 * 
 * 1) Detect all the PurchaseOrderA events followed by PurchaseOrderB events.
 * 
 * 2) Detect all PurchaseOrderA events that are not followed by a PurchaseOrderB
 * event within 2 sec 
 * 
 * 3) Detect all PurchaseOrderB events that are not preceded by a PurchaseOrderA event within 2 sec.
 * 
 * Documentation: Esper 4.9 reference - Chapter 6 EPL Reference: Patterns
 * 
 * @author dan.puiu
 * 
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Configuration config = new Configuration();
		config.addEventTypeAutoName("ro.unitbv.spec.lab3.events");
		EPServiceProvider epService = EPServiceProviderManager
				.getDefaultProvider(config);

		// TODO: solve the problem here

	
	
	
	
	
	
		
		
		

		PurchaseOrderA purchaseOrderA;
		PurchaseOrderB purchaseOrderB;

		purchaseOrderA = new PurchaseOrderA("Carte", 20);
		epService.getEPRuntime().sendEvent(purchaseOrderA);

		purchaseOrderB = new PurchaseOrderB("Roata", 200);
		epService.getEPRuntime().sendEvent(purchaseOrderB);

		purchaseOrderA = new PurchaseOrderA("Creion", 20);
		epService.getEPRuntime().sendEvent(purchaseOrderA);

		purchaseOrderA = new PurchaseOrderA("Caiet", 20);
		epService.getEPRuntime().sendEvent(purchaseOrderA);

		purchaseOrderB = new PurchaseOrderB("Surub", 200);
		epService.getEPRuntime().sendEvent(purchaseOrderB);
		
		purchaseOrderA = new PurchaseOrderA("Radiera", 20);
		epService.getEPRuntime().sendEvent(purchaseOrderA);

		Thread.sleep(2200);
		
		purchaseOrderB = new PurchaseOrderB("Robinet", 200);
		epService.getEPRuntime().sendEvent(purchaseOrderB);
		

		
		
		Thread.sleep(2000);
		System.out.println("Finish");
		
		

	}
}
