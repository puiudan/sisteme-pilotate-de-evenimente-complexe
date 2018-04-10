package ro.unitbv.spec.lab8.events;

public class AverageTemperatureEvent {

	private String location;
	private Double averageTemperatureValue;
	private Long timestamp;

	public AverageTemperatureEvent(String location, Double averageTemperatureValue, Long timestamp) {
		super();
		this.location = location;
		this.averageTemperatureValue = averageTemperatureValue;
		this.timestamp = timestamp;
	}

	public String getLocation() {
		return location;
	}

	public Double getAverageTemperatureValue() {
		return averageTemperatureValue;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "AverageTemperatureEvent [location=" + location + ", averageTemperatureValue=" + averageTemperatureValue
				+ ", timestamp=" + timestamp + "]";
	}

}
