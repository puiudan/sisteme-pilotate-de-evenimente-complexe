package ro.unitbv.spec.lab4.events;

public class TemperatureEvent {

	private Double temperature;

	public TemperatureEvent(Double temperature) {
		this.temperature = temperature;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

}
