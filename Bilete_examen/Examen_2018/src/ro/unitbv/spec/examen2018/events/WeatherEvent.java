package ro.unitbv.spec.examen2018.events;

public class WeatherEvent {

	private String aqisitionStation;
	private String nebulosityType;
	private Double pressure;
	private Integer relative_humidity;
	private Double temperature;
	private Integer wind;

	public String getAqisitionStation() {
		return aqisitionStation;
	}

	public void setAqisitionStation(String aqisitionStation) {
		this.aqisitionStation = aqisitionStation;
	}

	public String getNebulosityType() {
		return nebulosityType;
	}

	public void setNebulosityType(String nebulosityType) {
		this.nebulosityType = nebulosityType;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public Integer getRelative_humidity() {
		return relative_humidity;
	}

	public void setRelative_humidity(Integer relative_humidity) {
		this.relative_humidity = relative_humidity;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Integer getWind() {
		return wind;
	}

	public void setWind(Integer wind) {
		this.wind = wind;
	}

	public WeatherEvent(String aqisitionStation, String nebulosityType, Double pressure, Integer relative_humidity,
			Double temperature, Integer wind) {
		super();
		this.aqisitionStation = aqisitionStation;
		this.nebulosityType = nebulosityType;
		this.pressure = pressure;
		this.relative_humidity = relative_humidity;
		this.temperature = temperature;
		this.wind = wind;

	}

	@Override
	public String toString() {
		return "WeatherEvent [aqisitionStation=" + aqisitionStation + ", nebulosityType=" + nebulosityType
				+ ", pressure=" + pressure + ", relative_humidity=" + relative_humidity + ", temperature=" + temperature
				+ ", wind=" + wind + "]";
	}

}
