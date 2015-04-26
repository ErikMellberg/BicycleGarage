package bicycleGarage;

import interfaces.*;
import testDrivers.*;

public class BicycleGarage{
	
	int capacity;

	public BicycleGarage() {
		BicycleGarageManager manager = new BicycleGarageManager();
		ElectronicLock entryLock = new ElectronicLockTestDriver("Entry lock");
		ElectronicLock exitLock = new ElectronicLockTestDriver("Exit lock");
		BarcodePrinter printer = new BarcodePrinterTestDriver();
		PinCodeTerminal terminal = new PinCodeTerminalTestDriver();
		manager.registerHardwareDrivers(printer, entryLock, exitLock, terminal);
		terminal.register(manager);
		BarcodeReader readerEntry = new BarcodeReaderEntryTestDriver();
		BarcodeReader readerExit = new BarcodeReaderExitTestDriver();
		readerEntry.register(manager);
		readerExit.register(manager);
	}
	/**
	 * Sets the capacity of the garage
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		
	}
	
	/**
	 * 
	 * @return returns the capacity of the garage
	 */
	public int getCapacity() {
		return 0;
	}

	public static void main(String[] args) {
		BicycleGarage garage = new BicycleGarage();
	}
}
