package bicycleGarage;

import java.util.Random;

public class Bicycle {

	private String barcode;
	private boolean parkingStatus; //True if parked

	/**
	 * Creates a bicycle and generates a barcode
	 */
	public Bicycle() {
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append(String.valueOf(r.nextInt(10)));
		}
		barcode = sb.toString();
		parkingStatus = false;
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
}
