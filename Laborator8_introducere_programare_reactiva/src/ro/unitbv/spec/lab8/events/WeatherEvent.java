package ro.unitbv.spec.lab8.events;

public class WeatherEvent {

	private String location;
	private Double pressure;
	private Double relative_humidity;
	private Double temperature;
	private Long timestamp;

	public WeatherEvent(String location, Double pressure, Double relative_humidity, Double temperature,
			Long timestamp) {
		super();
		this.location = location;
		this.pressure = pressure;
		this.relative_humidity = relative_humidity;
		this.temperature = temperature;
		this.timestamp = timestamp;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public Double getRelative_humidity() {
		return relative_humidity;
	}

	public void setRelative_humidity(Double relative_humidity) {
		this.relative_humidity = relative_humidity;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "WeatherEvent [location=" + location + ", pressure=" + pressure + ", relative_humidity="
				+ relative_humidity + ", temperature=" + temperature + ", timestamp=" + timestamp + "]";
	}

}
