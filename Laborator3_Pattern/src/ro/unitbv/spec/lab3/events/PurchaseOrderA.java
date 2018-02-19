package ro.unitbv.spec.lab3.events;

public class PurchaseOrderA {

	private String purchaseOrderName;
	private int value;

	public PurchaseOrderA(String purchaseOrderName, int value) {
		super();
		this.purchaseOrderName = purchaseOrderName;
		this.value = value;
	}

	public String getPurchaseOrderName() {
		return purchaseOrderName;
	}

	public void setPurchaseOrderName(String purchaseOrderName) {
		this.purchaseOrderName = purchaseOrderName;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
