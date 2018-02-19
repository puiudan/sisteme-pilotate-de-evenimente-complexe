package ro.unitbv.spec.lab6.events;

public class TrafficObservation {

	private String status;
	private String avgMeasuredTime;
	private Integer avgSpeed;
	private String extID;
	private String medianMeasuredTime;
	private String TIMESTAMP;
	private Integer vehicleCount;
	private String _id;
	private String REPORT_ID;

	public TrafficObservation(String status, String avgMeasuredTime, Integer avgSpeed, String extID,
			String medianMeasuredTime, String tIMESTAMP, Integer vehicleCount, String _id, String rEPORT_ID) {
		super();
		this.status = status;
		this.avgMeasuredTime = avgMeasuredTime;
		this.avgSpeed = avgSpeed;
		this.extID = extID;
		this.medianMeasuredTime = medianMeasuredTime;
		TIMESTAMP = tIMESTAMP;
		this.vehicleCount = vehicleCount;
		this._id = _id;
		REPORT_ID = rEPORT_ID;
	}

	public String getStatus() {
		return status;
	}

	public String getAvgMeasuredTime() {
		return avgMeasuredTime;
	}

	public Integer getAvgSpeed() {
		return avgSpeed;
	}

	public String getExtID() {
		return extID;
	}

	public String getMedianMeasuredTime() {
		return medianMeasuredTime;
	}

	public String getTIMESTAMP() {
		return TIMESTAMP;
	}

	public Integer getVehicleCount() {
		return vehicleCount;
	}

	public String get_id() {
		return _id;
	}

	public String getREPORT_ID() {
		return REPORT_ID;
	}

	@Override
	public String toString() {
		return "TrafficObservation [status=" + status + ", avgMeasuredTime=" + avgMeasuredTime + ", avgSpeed="
				+ avgSpeed + ", extID=" + extID + ", medianMeasuredTime=" + medianMeasuredTime + ", TIMESTAMP="
				+ TIMESTAMP + ", vehicleCount=" + vehicleCount + ", _id=" + _id + ", REPORT_ID=" + REPORT_ID + "]";
	}
	
	

}
