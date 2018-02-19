package ro.unitbv.spec.lab4.events;

public class ErrorEvent {

	private Integer errorCode;

	public ErrorEvent(Integer errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

}
