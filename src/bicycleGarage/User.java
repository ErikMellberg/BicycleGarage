package bicycleGarage;

import java.util.LinkedList;

public class User {
	

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
	public User(String id, Bike bike, PinCode pin) {

	}

	/**
	 * Adds a bike to a user
	 * 
	 * @param bike
	 *            Bike to be added
	 * @return True if added else false
	 */
	public boolean addBike(Bike bike) {
		return false;
	}

	/**
	 * removes specified bike
	 * 
	 * @param bike
	 *            Bike to be removed
	 * @return True if removed else false
	 */
	public boolean removeBike(Bike bike) {
		return false;
	}

	/**
	 * Changes users pincode
	 * 
	 * @param pin
	 *            New pincode
	 */
	public void changePinCode(PinCode pin) {
	}

	/**
	 *
	 * @return all bikes registered on this user
	 */
	public LinkedList<Bike> getBikes() {
		return null;
	}
}
