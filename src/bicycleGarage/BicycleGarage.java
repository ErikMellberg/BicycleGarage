package bicycleGarage;

import bicycleGarageGui.GUI;
import interfaces.*;
import testDrivers.*;

public class BicycleGarage{
	
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
		Database database = manager.getDatabase();
		new GUI(database);
	}

	public static void main(String[] args) {
		new BicycleGarage();
	}
}
