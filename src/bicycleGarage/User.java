package bicycleGarage;

import java.util.LinkedList;

public class User {

	/**
	 * Creates a user with ID-number nbr if available, else throws exception
	 * 
	 * @param nbr
	 *            ID-number of user
	 * @param bike
	 *            Bike of user
	 */
	public User(NationalIdentityNumber nbr, Bike bike) {

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
	 * @param bike Bike to be removed
	 * @return True if removed else false
	 */
	public boolean removeBike(Bike bike) {
		return false;
	}
	
	/**
	 * Changes users pincode
	 * @param pin New pincode
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
