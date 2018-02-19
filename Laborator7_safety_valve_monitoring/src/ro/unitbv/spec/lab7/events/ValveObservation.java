package ro.unitbv.spec.lab7.events;

public class ValveObservation {

	private String ID;
	private String TIMESTAMP;
	private Integer presure;
	private Integer sound;

	public ValveObservation(String iD, String tIMESTAMP, Integer presure, Integer sound) {
		super();
		ID = iD;
		TIMESTAMP = tIMESTAMP;
		this.presure = presure;
		this.sound = sound;
	}

	public String getID() {
		return ID;
	}

	public String getTIMESTAMP() {
		return TIMESTAMP;
	}

	public Integer getPresure() {
		return presure;
	}

	public Integer getSound() {
		return sound;
	}

	@Override
	public String toString() {
		return "ValveObservation [ID=" + ID + ", TIMESTAMP=" + TIMESTAMP + ", presure=" + presure + ", sound=" + sound
				+ "]";
	}

}
