package bicycleGarage;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Database {

	private List<User> users;
	private List<Admin> admins;
	private int capacity;
	private int size;

	public Database() {
		users = new LinkedList<User>();
		admins = new LinkedList<Admin>();
	}

	public boolean addUser(String idNumber, String pin) {
		for (User user : users) {
			if (user.getIdNumber().equals(idNumber)) {
				return false;
			}
		}
		users.add(new User(idNumber, new Bicycle(), pin));
		return true;
	}

	public boolean addAdmin(String idNumber, String pin) {
		for (Admin admin : admins) {
			if (admin.getIdNumber().equals(idNumber)) {
				return false;
			}
		}
		admins.add(new Admin(idNumber, pin));
		return true;
	}

	public boolean removeUser(String idNumber) {
		Iterator<User> itr = users.iterator();
		while (itr.hasNext()) {
			if (itr.next().getIdNumber().equals(idNumber)) {
				itr.remove();
				return true;
			}
		}
		return false;
	}

	public boolean removeAdmin(String idNumber) {
		Iterator<Admin> itr = admins.iterator();
		while (itr.hasNext()) {
			if (itr.next().getIdNumber().equals(idNumber)) {
				itr.remove();
				return true;
			}
		}
		return false;
	}

	public boolean addBicycle(String idNumber, Bicycle bicycle) {
		if (size == capacity) {
			return false;
		}
		for (User user : users) {
			if (user.getIdNumber().equals(idNumber)) {
				user.addBicycle(bicycle);
				size++;
				return true;
			}
		}
		return false;
	}

	public boolean removeBicycle(String idNumber, String barcode) {
		for (User user : users) {
			for (Bicycle bicycle : user.getBicycles()) {
				if (bicycle.getBarcode().equals(barcode)) {
					user.removeBicycle(barcode);
					size--;
					return true;
				}
			}
		}
		return false;
	}

	public boolean changeUserPin(String idNumber, String pin) {
		for (User user : users) {
			if (user.getIdNumber().equals(idNumber)) {
				user.changePin(pin);
				return true;
			}
		}
		return false;
	}

	public boolean changeAdminPin(String idNumber, String pin) {
		for (Admin admin : admins) {
			if (admin.getIdNumber().equals(idNumber)) {
				admin.changePin(pin);
				return true;
			}
		}
		return false;
	}

	public String listUsers() {
		StringBuilder list = new StringBuilder();
		for (User user : users) {
			list.append(user.toString() + "\n");
		}
		return list.toString();
	}

	public String listCurrentUsers() {
		
		return null;
	}

	public List<Admin> listAdmins() {
		
	}

	public boolean checkEntryBarcode(String barcode) {
		
	}

	public boolean checkExitBarcode(String barcode) {
		
	}

	public boolean checkPinCode(String pincode) {
		for(User user : users) {
			if (user.getPin().equals(pincode)) {
				return true;
			}
		}
		for (Admin admin : admins) {
			if (admin.getPin().equals(pincode)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Sets the capacity of the garage
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * 
	 * @return returns the capacity of the garage
	 */
	public int getCapacity() {
		return capacity;
	}

}
