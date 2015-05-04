package bicycleGarage;

import java.util.Iterator;
import java.util.LinkedList;

public class User {
	
	private String idNumber;
	private String pin;
	private LinkedList<Bicycle> bicycles;

	/**
	 * Creates a user with ID-number nbr if available, else throws exception
	 * 
	 * @param id
	 *            ID-number of user
	 * @param bike
	 *            Bike of user
	 * @param pin
	 *            Pincode of user
	 * 
	 */
	public User(String idNumber, Bicycle bicycle, String pin) {
		bicycles = new LinkedList<Bicycle>();
		this.idNumber = idNumber;
		this.pin = pin;
		bicycles.add(bicycle);
	}

	public String getIdNumber() {
		return idNumber;
	}

	/**
	 * Adds a bike to a user
	 * 
	 * @param bike
	 *            Bike to be added
	 * @return True if added else false
	 */
	public boolean addBicycle(Bicycle bicycle) {
		bicycles.add(bicycle);
		return true;
	}

	/**
	 * removes specified bike
	 * 
	 * @param bike
	 *            Bike to be removed
	 * @return True if removed else false
	 */
	public boolean removeBicycle(String barcode) {
		Iterator<Bicycle> itr = bicycles.iterator();
		while(itr.hasNext()) {
			if(itr.next().getBarcode().equals(barcode)) {
				itr.remove();
				return true;
			}
		}
		return false;
	}

	/**
	 * Changes users pincode
	 * 
	 * @param pin
	 *            New pincode
	 */
	public void changePin(String pin) {
		this.pin = pin;
	}
	
	public String getPin() {
		return pin;
	}

	/**
	 *
	 * @return all bikes registered on this user
	 */
	public LinkedList<Bicycle> getBicycles() {
		return bicycles;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(idNumber + ": ");
		for (Bicycle bicycle : bicycles) {
			sb.append(bicycle + " ");
		}
		return sb.toString();
	}
}
