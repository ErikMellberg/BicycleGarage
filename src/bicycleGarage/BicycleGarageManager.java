package bicycleGarage;

import java.time.Instant;

import interfaces.*;

public class BicycleGarageManager {

	private BarcodePrinter printer;
	private ElectronicLock entryLock;
	private ElectronicLock exitLock;
	private PinCodeTerminal terminal;
	private Database database;
	private StringBuilder pincode;
	private Instant firstChar;

	public BicycleGarageManager() {
		database = new Database();
		pincode = new StringBuilder();
	}

	public void registerHardwareDrivers(BarcodePrinter printer,
			ElectronicLock entryLock, ElectronicLock exitLock,
			PinCodeTerminal terminal) {
		this.printer = printer;
		this.entryLock = entryLock;
		this.exitLock = exitLock;
		this.terminal = terminal;
	}

	public void entryCharacter(char c) {
		if (pincode.length() == 0) {
			firstChar = Instant.now();
		} else if (firstChar.isBefore(Instant.now().minusSeconds(5))) {
			firstChar = Instant.now();
			pincode = new StringBuilder();
			terminal.lightLED(0, 2);
		}
		pincode.append(c);
		if (pincode.length() == 4) {
			if (database.checkPinCode(pincode.toString())) {
				entryLock.open(10);
				terminal.lightLED(1, 10);
			} else {
				terminal.lightLED(0, 2);
			}
			pincode = new StringBuilder();
		}
	}

	public void exitBarcode(String barcode) {
		if (barcode.length() == 5) {
			if (database.checkExitBarcode(barcode)) {
				exitLock.open(10);
				
			}
		}
	}

	public void entryBarcode(String barcode) {
		if (barcode.length() == 5) {
			if (database.checkEntryBarcode(barcode)) {
				entryLock.open(10);
			}
		}
	}

	/**
	 * Sets the capacity of the garage
	 * 
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		database.setCapacity(capacity);
	}

	/**
	 * 
	 * @return returns the capacity of the garage
	 */
	public int getCapacity() {
		return database.getCapacity();
	}
	
	public void printBarcode(String barcode) {
		printer.printBarcode(barcode);
	}
	
	public Database getDatabase(){
		return database;
	}
}
