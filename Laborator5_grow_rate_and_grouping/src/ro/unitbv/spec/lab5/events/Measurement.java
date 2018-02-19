package ro.unitbv.spec.lab5.events;

public class Measurement {

	private Double value;
	private Integer time;
	private String sensorID;

	public Measurement(Double value, Integer time, String sensorID) {
		super();
		this.value = value;
		this.time = time;
		this.sensorID = sensorID;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getSensorID() {
		return sensorID;
	}

	public void setSensorID(String sensorID) {
		this.sensorID = sensorID;
	}

	@Override
	public String toString() {
		return "Measurement [value=" + value + ", time=" + time + ", sensorID="
				+ sensorID + "]";
	}

}
