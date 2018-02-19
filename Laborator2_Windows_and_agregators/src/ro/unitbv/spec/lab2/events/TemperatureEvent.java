package ro.unitbv.spec.lab2.events;

public class TemperatureEvent {

	private int temperature;
	private String location;

	public TemperatureEvent(int temperature, String location) {
		super();
		this.temperature = temperature;
		this.location = location;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
