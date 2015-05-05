package bicycleGarage;

import java.util.Random;

public class Bicycle {

	private String barcode;
	private boolean parkingStatus; //True if parked

	public Bicycle(String barcode, boolean parkingStatus) {
		this.barcode = barcode;
		this.parkingStatus = parkingStatus;
	}

	/**
	 * 
	 * @return returns barcode
	 */
	public String getBarcode() {
		return barcode;
	}

	public void changeStatus() {
		parkingStatus = !parkingStatus;
	}

	public boolean getStatus() {
		return parkingStatus;
	}
	
	public String toString() {
		return barcode;
	}
}
