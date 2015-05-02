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
	public User(String idnumber, Bicycle bike, String pin) {

	}

	/**
	 * Adds a bike to a user
	 * 
	 * @param bike
	 *            Bike to be added
	 * @return True if added else false
	 */
	public boolean addBike(Bicycle bike) {
		return false;
	}

	/**
	 * removes specified bike
	 * 
	 * @param bike
	 *            Bike to be removed
	 * @return True if removed else false
	 */
	public boolean removeBike(Bicycle bike) {
		return false;
	}

	/**
	 * Changes users pincode
	 * 
	 * @param pin
	 *            New pincode
	 */
	public void changePinCode(String pin) {
	}

	/**
	 *
	 * @return all bikes registered on this user
	 */
	public LinkedList<Bicycle> getBikes() {
		return null;
	}
}
