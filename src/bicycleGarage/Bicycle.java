package bicycleGarage;

import java.util.Random;

public class Bicycle {
	
	String barcode;

	/**
	 * Creates a bicycle and generates a barcode
	 */
	public Bicycle() {
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			sb.append(String.valueOf(r.nextInt(10)));
		}
		barcode = sb.toString();
	}
	
	/**
	 * 
	 * @return returns barcode
	 */
	public String getBarcode() {
		return barcode;
	}
}
