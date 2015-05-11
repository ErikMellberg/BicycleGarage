package bicycleGarage;

import bicycleGarageGui.GUI;
import interfaces.*;
import testDrivers.*;

public class BicycleGarage{
	
	public BicycleGarage() {
		new GUI();
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

	public static void main(String[] args) {
		new BicycleGarage();
	}
}
