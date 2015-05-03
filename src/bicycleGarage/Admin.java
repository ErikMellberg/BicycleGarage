package bicycleGarage;

public class Admin {

	private String idNumber;
	private String pin;

	/**
	 * Creates an admin
	 * 
	 * @param idnumber
	 *            idnumber of admin
	 * @param pin
	 *            pincode of admin
	 */
	public Admin(String idNumber, String pin) {
		this.idNumber = idNumber;
		this.pin = pin;
	}

	public String getIdNumber() {
		return idNumber;
	}

	/**
	 * Changes admin pin
	 * 
	 * @param pin
	 *            new pin
	 */
	public void changePin(String pin) {
		this.pin = pin;
	}
	
	public String getPin() {
		return pin;
	}

	public String toString() {
		return idNumber;
	}
}
