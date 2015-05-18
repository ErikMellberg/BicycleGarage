package bicycleGarage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Database {

	private List<User> users;
	private List<Admin> admins;
	private int capacity;
	private int size;

	public Database() {
		users = new LinkedList<User>();
		admins = new LinkedList<Admin>();
		read();
	}

	public boolean addUser(String idNumber, String pin) {
		if (idNumber.length() != 10 || pin.length() != 4) {
			return false;
		}
		for (User user : users) {
			if (user.getIdNumber().equals(idNumber)) {
				return false;
			}
		}
		users.add(new User(idNumber, pin));
		return true;
	}

	public boolean addAdmin(String idNumber, String pin) {
		if (idNumber.length() != 10 || pin.length() != 4) {
			return false;
		}
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
		int n = 0;
		while (itr.hasNext()) {
			if (itr.next().getIdNumber().equals(idNumber)) {
				if(itr.hasNext() || n != 0){
					itr.remove();
					return true;
				}
			}
			n++;
		}
		return false;
	}

	public boolean addBicycle(String idNumber) {
		if (size == capacity) {
			return false;
		}
		for (User user : users) {
			if (user.getIdNumber().equals(idNumber)) {
				Random r = new Random();
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 5; i++) {
					sb.append(r.nextInt(10));
				}
				user.addBicycle(new Bicycle(sb.toString(), false));
				size++;
				return true;
			}
		}
		return false;
	}
	
	public boolean addBicycle(String idNumber, String barcode, boolean parkingStatus) {
		if (size == capacity) {
			return false;
		}
		for (User user : users) {
			if (user.getIdNumber().equals(idNumber)) {
				user.addBicycle(new Bicycle(barcode, parkingStatus));
				size++;
				return true;
			}
		}
		return false;
	}
	
	public boolean hasParkedBicycles(String idNumber){
		for(User user: users){
			if (user.getIdNumber().equals(idNumber)) {
				return !user.getParkedBicycles().isEmpty();
			}
		}
		return false;
	}

	public boolean removeBicycle(String idNumber, String barcode) {
		for (User user : users) {
			if(user.getIdNumber().equals(idNumber)){
 			for (Bicycle bicycle : user.getBicycles()) {
				if (bicycle.getBarcode().equals(barcode)) {
					user.removeBicycle(barcode);
					size--;
					return true;
				}
			}
			}
		}
		return false;
	}
	
	public boolean changeUserId(String idNumber, String newId){
		if (newId.length() != 10) {
			return false;
		}
		for (User user : users) {
			if (user.getIdNumber().equals(newId)) {
				return false;
			}
		}
		for(User user: users){
			if(user.getIdNumber().equals(idNumber)){
				user.changeidNumber(newId);
				return true;
			}
		}
		return false;
	}

	public boolean changeUserPin(String idNumber, String pin) {
		if (pin.length() != 4) {
			return false;
		}
		for (User user : users) {
			if (user.getIdNumber().equals(idNumber)) {
				user.changePin(pin);
				return true;
			}
		}
		return false;
	}
	
	public boolean changeAdminId(String idNumber, String newId){
		if (newId.length() != 10) {
			return false;
		}
		for (Admin admin : admins) {
			if (admin.getIdNumber().equals(newId)) {
				return false;
			}
		}
		for(Admin admin: admins){
			if(admin.getIdNumber().equals(idNumber)){
				admin.changeidNumber(newId);
				return true;
			}
		}
		return false;
	}

	public boolean changeAdminPin(String idNumber, String pin) {
		if (pin.length() != 4) {
			return false;
		}
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
		int num = 0;
		for (User user : users) {
			num++;
			list.append(num + ". " + user.print() + "\n");
		}
		return list.toString();
	}

	public String listCurrentUsers() {
		StringBuilder list = new StringBuilder();
		for (User user : users) {
			for (Bicycle bicycle : user.getBicycles()) {
				StringBuilder activeUser = new StringBuilder();
				if (bicycle.getStatus()) {
					if (activeUser.length() == 0) {
						activeUser.append(user.getIdNumber() + ": "
								+ bicycle.getBarcode());
					} else {
						activeUser.append(bicycle.getBarcode());
					}
				}
				list.append(activeUser + " ");
			}
		}
		return list.toString();
	}

	public boolean checkEntryBarcode(String barcode) {
		for (User user : users) {
			for (Bicycle bicycle : user.getBicycles()) {
				if (bicycle.getBarcode().equals(barcode)) {
					if (bicycle.getStatus()) {
						return false;
					} else {
						bicycle.changeStatus();
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean checkExitBarcode(String barcode) {
		for (User user : users) {
			for (Bicycle bicycle : user.getBicycles()) {
				if (bicycle.getBarcode().equals(barcode)) {
					if (bicycle.getStatus()) {
						bicycle.changeStatus();
						return true;
					} else {
						return false;
					}
				}
			}
		}
		return false;
	}

	public boolean checkPinCode(String pincode) {
		for (User user : users) {
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
	 * 
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

	public void save() {
		File file = new File("Database.txt");
		PrintWriter out = null;
		try {
			out = new PrintWriter(file);
			out.println(capacity);
			for (Admin admin : admins) {
				out.println("A " + admin.toString());
			}
			for (User user : users) {
				out.println("U " + user.toString());
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void read() {
		Scanner scan;
		try {
			scan = new Scanner(new File("Database.txt"));
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] parts = line.split(" ");
				if (parts[0].equals("A")) {
					addAdmin(parts[1], parts[2]);
				} else if (parts[0].equals("U")) {
					addUser(parts[1], parts[2]);
					for (int i = 3; i < parts.length; i += 2) {
						addBicycle(parts[1], parts[i], Boolean.parseBoolean(parts[i+1]));
					}
				} else {
					setCapacity(Integer.parseInt(parts[0]));
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
